package com.gnart.game;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector3;
import com.gnart.entity.Player;

public class Game {
    private Player player;
    private Raylib.Camera3D camera;

    public Game() {
        Raylib.InitWindow(800, 450, "Explore With Friends");
        Raylib.SetTargetFPS(60);
        player = new Player();
        camera = new Raylib.Camera3D()
                ._position(new Vector3(player.position))
                .target(new Vector3())
                .up(new Vector3().x(0).y(1).z(0))
                .fovy(45).projection(Raylib.CAMERA_PERSPECTIVE);
    }

    public void playGame() {
        while (!Raylib.WindowShouldClose()) {
            // 1. input


            // 2. update
            player.update();
            Raylib.UpdateCamera(camera, Raylib.CAMERA_ORBITAL);

            // 3. render
            Raylib.BeginDrawing();
            Raylib.ClearBackground(Colors.RAYWHITE);
            Raylib.BeginMode3D(camera);
            Raylib.DrawGrid(20, 1.0f);
            Raylib.EndMode3D();
            Raylib.DrawText("Hello world", 190, 200, 20, Colors.VIOLET);
            Raylib.DrawFPS(20, 20);
            Raylib.EndDrawing();
        }
        Raylib.CloseWindow();
    }
}
