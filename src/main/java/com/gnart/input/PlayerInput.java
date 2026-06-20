package com.gnart.input;

/**
 * A lightweight data snapshot representing the player's intentional
 * inputs during a single simulation frame.
 * forward 1 being forward, -1 being backward, and 0 being no direction
 * side 1 being right, -1 being left, and 0 being no side
 */
public class PlayerInput {
    public char forward;
    public char side;
    public boolean jumpPressed;
    public boolean crouchHold;

    public PlayerInput() {
        this.forward = 0;
        this.side = 0;
        this.jumpPressed = false;
        this.crouchHold = false;
    }
}