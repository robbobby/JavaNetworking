package com.mir2.client.entity;


import com.mir2.client.helpers.Position;
import com.mir2.client.helpers.Size;

import java.awt.*;

public abstract class GameObject {
    private Position position;
    private Size size;

    public GameObject(Position position, Size size) {
        setPosition(position);
        setSize(size);
    }

    public abstract void update();
    public abstract Image getImage();

    public Position getPosition() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    protected void setPositionX(int x) {
        this.position.setX(x);
    }

    protected void setPositionY(int y) {
        this.position.setY(y);
    }

    public Size getSize() {
        return size;
    }

    protected void setSize(Size size) {
        this.size = size;
    }
}
