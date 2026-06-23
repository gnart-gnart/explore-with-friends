package com.gnart.entity;

import com.raylib.Raylib.Vector2;

public class Player {
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

    public Body body;

    public Player() {
        this.body = new Body();
    }

    public void update() {

    }
}
