package com.gnart;

import com.gnart.entity.Body;
import com.gnart.input.PlayerController;
import com.raylib.Raylib.Camera3D;
import static uk.co.electronstudio.jaylib.Jaylib.*;

// Movement constants
public static final float GRAVITY = 32.0f;
public static final float MAX_SPEED = 20.0f;
public static final float CROUCH_SPEED = 5.0f;
public static final float JUMP_FORCE = 12.0f;
public static final float MAX_ACCEL = 150.0f;
// Grounded drag
public static final float FRICTION = 0.86f;
// Increasing air drag, increases strafing speed
public static final float AIR_DRAG = 0.98f;
// Responsiveness for turning movement direction to looked direction
public static final float CONTROL = 15.0f;
public static final float CROUCH_HEIGHT = 0.0f;
public static final float STAND_HEIGHT = 1.0f;
public static final float BOTTOM_HEIGHT = 0.5f;
public static final boolean NORMALIZE_INPUT = true;

public class Main {
    static void main() {
        Body player = new Body();
        PlayerController controller = new PlayerController();

        InitWindow(800, 450, "Explore With Friends");
        SetTargetFPS(60);
        Camera3D camera = new Camera3D()
                ._position(new Vector3(player.position))
                .target(new Vector3())
                .up(new Vector3().x(0).y(1).z(0))
                .fovy(45).projection(CAMERA_PERSPECTIVE);

        while (!WindowShouldClose()) {
            // 1. input

            // 2. update
            UpdateCamera(camera, CAMERA_ORBITAL);

            // 3. render
            BeginDrawing();
            ClearBackground(RAYWHITE);
            BeginMode3D(camera);
            DrawGrid(20, 1.0f);
            EndMode3D();
            DrawText("Hello world", 190, 200, 20, VIOLET);
            DrawFPS(20, 20);
            EndDrawing();
        }
        CloseWindow();
    }
}