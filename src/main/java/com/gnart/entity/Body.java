package com.gnart.entity;

import com.raylib.Raylib.Vector3;

public class Body {
    Vector3 position;
    Vector3 velocity;
    Vector3 direction;
    boolean isGrounded;

    public Body() {
        position = new Vector3().x(0).y(0) .z(0);
        velocity = new Vector3().x(0).y(0) .z(0);
        direction = new Vector3().x(0).y(0) .z(0);
        isGrounded = false;
    }
}
