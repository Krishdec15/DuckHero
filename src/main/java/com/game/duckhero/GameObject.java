package com.game.duckhero;

import javafx.scene.shape.Line;

public abstract class GameObject {
    protected Line line;
    protected boolean isFallen;

    public GameObject(Line line) {
        this.line = line;
        this.isFallen = false;
    }

    public abstract void update();

    public abstract void reset();

    public abstract double getLength();

    public boolean isFallen() {
        return isFallen;
    }

    public void setFallen(boolean fallen) {
        isFallen = fallen;
    }
}
