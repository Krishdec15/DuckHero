package com.game.duckhero;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Trans {
    public static void scaleTransition(ImageView img, double scaleX, double scaleY){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), img);
        scaleTransition.setToX(scaleX);
        scaleTransition.setToY(scaleY);
        scaleTransition.play();
    }
    public static void fadeOutTransition (AnchorPane anchorPane ,String fxmlPath){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(e->loadNextScene(anchorPane, fxmlPath));
        fadeTransition.play();
    }
    public static void fadeInTransition (AnchorPane anchorPane ,String fxmlPath){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(e->loadNextScene(anchorPane, fxmlPath));
        fadeTransition.play();
    }
    public static void fadeInTransition (AnchorPane anchorPane){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public static void loadNextScene(AnchorPane anchorPane, String fxmlPath){
    try {
        System.out.println("Loading FXML: " + fxmlPath);
        Parent secondScene = (AnchorPane) FXMLLoader.load(Trans.class.getResource(fxmlPath));
        System.out.println("FXML Loaded successfully");
        Scene newScene = new Scene(secondScene);
        Stage currentStage = (Stage) anchorPane.getScene().getWindow();
        currentStage.setScene(newScene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
