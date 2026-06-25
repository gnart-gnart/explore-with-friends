package com.gnart.input;

import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;

/**
 * A lightweight data snapshot representing the player's intentional
 * inputs during a single simulation frame.
 * forward 1 being forward, -1 being backward, and 0 being no direction
 * side 1 being right, -1 being left, and 0 being no side
 */
public class PlayerInput {
    public byte forward;
    public byte side;
    public boolean jumpPressed;
    public boolean crouchHold;
    public Vector2 mouseDelta;

    public PlayerInput() {
        this.forward = 0;
        this.side = 0;
        this.jumpPressed = false;
        this.crouchHold = false;
    }

    public void getInputData() {
        mouseDelta = Raylib.GetMouseDelta();
        if (Raylib.IsKeyDown(Raylib.KEY_W)) {
            forward = 1;
        }
        else if (Raylib.IsKeyDown(Raylib.KEY_S)) {
            forward = -1;
        }
        else {
            forward = 0;
        }
        if (Raylib.IsKeyDown(Raylib.KEY_D)) {
            side = 1;
        }
        else if (Raylib.IsKeyDown(Raylib.KEY_A)) {
            side = -1;
        }
        else  {
            side = 0;
        }
        crouchHold = Raylib.IsKeyDown(Raylib.KEY_LEFT_CONTROL);
        jumpPressed = Raylib.IsKeyPressed(Raylib.KEY_SPACE);
    }
}