package com.gnart.input;

import com.raylib.Raylib;

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

    public PlayerInput() {
        this.forward = 0;
        this.side = 0;
        this.jumpPressed = false;
        this.crouchHold = false;
    }

    public void getInput() {
        if (IsKeyDown(KEY_W)) {
            forward = 1;
        }
        else if (IsKeyDown(KEY_S)) {
            forward = -1;
        }
        else {
            forward = 0;
        }
        if (IsKeyDown(KEY_D)) {
            side = 1;
        }
        else if (IsKeyDown(KEY_A)) {
            side = -1;
        }
        else  {
            side = 0;
        }
        crouchHold = IsKeyDown(KEY_LEFT_CONTROL)) {
        jumpPressed = IsKeyPressed(KEY_SPACE);
    }
}