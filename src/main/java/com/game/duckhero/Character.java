package com.game.duckhero;

import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.Random;



public class Character {
    GameScreenController gameScreenController = new GameScreenController();
    private static final Random random = new Random();
    private ImageView character;
    private TranslateTransition traversal;

    public Character (ImageView image){
        this.character = image;
        this.traversal = new TranslateTransition();
        configureTraversalTransition();
    }

    private void configureTraversalTransition() {
        traversal.setInterpolator(Interpolator.LINEAR);
        traversal.setOnFinished(event -> {
            character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_idle.gif")));
        });
    }

    public void action(Line stick, Platform platform,Platform platform2,AnchorPane gameContainer){
        changeAnimation();
        double platformLeft = platform.getBoundsInParent().getMinX();
        double platformRight = platform.getBoundsInParent().getMaxX();
        traverseStick(stick,platformLeft,platformRight,platform2,gameContainer);
    }

    private void traverseStick(Line stick, double platformLeft, double platformRight, Platform platform2, AnchorPane gameContainer) {
        double startX = stick.getStartY();
        double endX = stick.getEndY();
        double characterLayoutX = character.getLayoutX();
        double platformLeft_2 = platform2.getBoundsInParent().getMinX();
        double platformRight_2 = platform2.getBoundsInParent().getMaxX();
        double stickLength = Math.abs(startX-endX);
        double distanceToStick = Math.abs(character.getLayoutX()-startX);
        double traverseLength= stickLength+40;

        traversal.setNode(character);
        traversal.setDuration(Duration.seconds(1));
        traversal.setToX(traverseLength);
        traversal.play();
        traversal.setOnFinished(e->{
            if(stickLength+platformRight_2>=platformLeft && stickLength+platformRight_2<=platformRight){
//                GameScreenController.updateScore();
//                gameScreenController.updateScoreLabel();
                character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_idle.gif")));
            }else {
                character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_hit.gif")));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {
                    character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_death.png")));
                    TranslateTransition fallAnimation = new TranslateTransition(Duration.seconds(1), character);
                    fallAnimation.setToY(500); // Adjust the value to control how far the character falls
                    fallAnimation.play();
//                    GameScreenController.resetScore();
//                    gameScreenController.updateScoreLabel();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/game/duckhero/end_screen.fxml"));
                        Pane pane = fxmlLoader.load();
                        gameContainer.getChildren().add(pane);
                        pane.toFront();
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }
                });
                pause.play();

            }
        });


    }

    private void changeAnimation() {
        if(random.nextBoolean()){
            character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_walk.gif")));
        }else{
            character.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/ducky_roll_2.gif")));
        }
    }

}