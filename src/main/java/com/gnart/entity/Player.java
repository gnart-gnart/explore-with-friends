package com.gnart.entity;

import com.gnart.input.PlayerInput;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Vector3;
import com.raylib.Helpers;

public class Player extends Body {
    // Movement variables
    public float maxSpeed = 20.0f;
    public float crouchSpeed = 5.0f;
    public float jumpForce = 12.0f;
    public float maxAccel = 150.0f;
    // Grounded drag
    public float friction = 0.86f;
    // Increasing air drag, increases strafing speed
    public float airDrag = 0.98f;
    // Responsiveness for turning movement direction to looked direction
    public float control = 15.0f;
    public float crouchHeight = 0.0f;
    public float standHeight = 1.0f;
    public float bottomHeight = 0.5f;
    public boolean normalizeInput = true;
    // Internal tracking variables
    private final Vector2 sensitivity = new Vector2().x(0.001f).y(0.001f);
    private final Vector2 lookRotation = new Vector2().x(0).y(0);
    private float headTimer = 0.0f;
    private float walkLerp = 0.0f;
    private float headLerp = standHeight;
    private final Vector2 lean = new Vector2().x(0).y(0);


    private final float GRAVITY = 32.0f;
    private final float JUMP_FORCE = 32.0f;
    private final float CONTROL = 32.0f;


    private PlayerInput input;
    Vector2 inputVector;

    public Player(PlayerInput input) {
        this.input = input;
    }

    public void update(float delta) {
        lookRotation.x(lookRotation.x() - input.mouseDelta.x() * sensitivity.x());
        lookRotation.y(lookRotation.y() - input.mouseDelta.y() * sensitivity.y());
        inputVector = Helpers.newVector2(input.side, -input.forward);
        if (normalizeInput && input.side != 0 && input.forward != 0) {
            inputVector = Raylib.Vector2Normalize(inputVector);
        }
        if (!isGrounded) {
            velocity.y(velocity.y() - GRAVITY * delta);
        }
        if (isGrounded && input.jumpPressed) {
            velocity.y(jumpForce);
            isGrounded = false;
        }

        float lookX = lookRotation.x();
        Vector3 front = Helpers.newVector3((float)Math.sin(lookX), 0, (float)Math.cos(lookX));
        Vector3 right = Helpers.newVector3((float)Math.sin(-lookX), 0, (float)Math.cos(-lookX));

        Vector3 desiredDirection = Helpers.newVector3(inputVector.x() * right.x() + inputVector.y() * front.x(),
                0, inputVector.x() * right.z() + inputVector.y() * front.z());
        direction = Raylib.Vector3Lerp(direction, desiredDirection, control * delta);

        float deceleration = (isGrounded) ? friction : airDrag;
        Vector3 hvel = Helpers.newVector3(velocity.x() * deceleration, 0, velocity.z() * deceleration);

        float hvelLength = Raylib.Vector3Length(hvel); // Magnitude
        if (hvelLength < (maxSpeed * 0.01f)) {
            hvel = Helpers.newVector3(0,0,0);
        }
        // This is what creates strafing
        float speed = Raylib.Vector3DotProduct(hvel, direction);

        float currentMaxSpeed = input.crouchHold ? crouchSpeed : maxSpeed;
        float accel = Raylib.Clamp(currentMaxSpeed - speed, 0, maxAccel * delta);
        hvel.x(hvel.x() + direction.x() * accel);
        hvel.z(hvel.z() + direction.z() * accel);

        velocity.x(hvel.x());
        velocity.y(hvel.y());
        position.x(position.x() + velocity.x() * delta);
        position.y(position.y() + velocity.y() * delta);
        position.z(position.z() + velocity.z() * delta);

        if (position.y() <= 0) {
            position.y(0);
            velocity.y(0);
            isGrounded = true;
        }
    }
}
