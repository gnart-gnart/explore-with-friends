package com.gnart;

import com.gnart.input.Player;
import com.raylib.Raylib.Camera3D;
import static uk.co.electronstudio.jaylib.Jaylib.*;

public class Main {
    public static final float GRAVITY = 32.0f;

    public static void main(String[] args) {
        Player player = new Player();

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
            player.update();
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