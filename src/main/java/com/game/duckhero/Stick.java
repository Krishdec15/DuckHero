package com.game.duckhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Stick extends GameObject {
    private static final double MAX_LENGTH = 1200;
    private double stickLength;
    private Timeline time;

    public Stick(Line line) {
        super(line);
        this.stickLength = 0;

        time = new Timeline(
                new KeyFrame(Duration.millis(10), e -> {
                    if (stickLength < MAX_LENGTH) {
                        stickLength += 10;
                        line.setEndY(line.getEndY() - 4);
                    } else {
                        stopGrowth();
                        time.stop();
                    }
                })
        );
        time.setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    public void update() {
        extendStick();
    }

    @Override
    public void reset() {
        stickLength = 0;
        line.setEndY(line.getStartY());
    }

    @Override
    public double getLength() {
        return stickLength;
    }

    public void extendStick() {
        if (stickLength == 0) {
            time.play();
        }
    }

    public void stopGrowth() {
        if (stickLength > 0) {
            time.stop();
        }
    }

    public boolean isStickFallen() {
        return isFallen;
    }

    public void setStickStatus(boolean b) {
        isFallen=b;
    }
}