package com.gnart.entity;

import com.raylib.Raylib.Vector3;

public class Body {
    public Vector3 position;
    public Vector3 velocity;
    public Vector3 direction;
    public boolean isGrounded;

    public Body() {
        position = new Vector3().x(0).y(0) .z(0);
        velocity = new Vector3().x(0).y(0) .z(0);
        direction = new Vector3().x(0).y(0) .z(0);
        isGrounded = false;
    }
}
