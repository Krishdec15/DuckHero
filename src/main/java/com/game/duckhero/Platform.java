package com.game.duckhero;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Platform extends Rectangle {
    private static final double platformHeight = 220;
    private static final Color platformColor = Color.BLACK;

    public Platform(double width, double height, double x, double y) {
        super(width, height, platformColor);
        setLayoutX(x);
        setLayoutY(y);
    }

    public static Platform createPlayerPlatform(double screenHeight) {
        double platformWidth = 240;
        double platformX = 0; // Left side
        double platformY = screenHeight - platformHeight;
        return new Platform(platformWidth, platformHeight, platformX, platformY);
    }

    public static Platform generatePlatform(double previousPlatformX, double screenHeight,double screenWidth) {
        Random random = new Random();

        double minWidth = 50;
        double maxWidth = 200;
        double platformWidth = random.nextDouble() * (maxWidth - minWidth) + minWidth;

        double minDistance = 300; // Minimum distance from the left side
        double maxDistance = 700; // Maximum distance from the left side

        double distance = random.nextDouble() * (maxDistance - minDistance) + minDistance;
        double platformX = Math.min(previousPlatformX + distance, screenWidth - platformWidth);
        double platformY = screenHeight - platformHeight;

        Platform platform = new Platform(platformWidth, platformHeight, platformX, platformY);
        return platform;
    }

    public static Rectangle generateCenterSquare(Platform platform) {
        double centerX = platform.getLayoutX() + platform.getWidth() / 2;
        double centerY = platform.getLayoutY();

        Rectangle centerSquare = new Rectangle(20, 20, Color.RED); // Adjust the size and color
        centerSquare.setLayoutX(centerX - 10); // Adjust for centering
        centerSquare.setLayoutY(centerY);

        return centerSquare;
    }
}
