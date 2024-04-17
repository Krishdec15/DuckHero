package com.game.duckhero;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class GameScreenController {
    //public static int scores;
    private Stick stick;
    private TranslateTransition backgroundTransition;
    private Platform playerPlatform;
    private Platform platform;
    private static final double SCREEN_WIDTH = 800;
    private static final double SCREEN_HEIGHT = 600;

    public void initialize(){
        Trans.fadeInTransition(gameContainer);
        stick = new Stick(stickline);
        playerPlatform = Platform.createPlayerPlatform(SCREEN_HEIGHT);
        gameContainer.getChildren().add(playerPlatform);
        spawnPlatform();
        //score = new Label();
        //resetScore();
    }
    private void spawnPlatform() {
        platform = Platform.generatePlatform(playerPlatform.getLayoutX(), SCREEN_HEIGHT,SCREEN_WIDTH);
        gameContainer.getChildren().add(platform);
        Rectangle bonusPointSquare = Platform.generateCenterSquare(platform);
        gameContainer.getChildren().add(bonusPointSquare);
    }

    private void stickfall(){
        if(!stick.isStickFallen()){
            double angle = 90;
            double xCoord = stickline.getStartX();
            double yCoord = stickline.getStartY();
            Rotate rotate = new Rotate(0, xCoord, yCoord);
            stickline.getTransforms().add(rotate);
            Timeline rotationTime = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(rotate.angleProperty(), angle)));
            rotationTime.setOnFinished(e -> {
                Character character = new Character(ducky);
                character.action(stickline,platform,playerPlatform,gameContainer);
            });
            rotationTime.play();
        }
    }
    @FXML
    private AnchorPane gameContainer;
    @FXML
    private ImageView ducky;
    @FXML
    private Line stickline;

    @FXML
    private ImageView buttonPause;

    @FXML
    private Label collectibleCount;

    @FXML
    private Label score;

    @FXML
    void pauseHover(MouseEvent event) {
        double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonPause, scaleX, scaleY);
        buttonPause.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Pause_hover.png")));

    }

    @FXML
    void pauseHoverOff(MouseEvent event) {
        double scaleX = 1.0 , scaleY = 1.0;
        Trans.scaleTransition(buttonPause, scaleX, scaleY);
        buttonPause.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Pause_Normal.png")));
    }

    @FXML
    void togglePauseButton(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/game/duckhero/settings_screen.fxml"));
            Pane pane = fxmlLoader.load();
            gameContainer.getChildren().add(pane);
            pane.toFront();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    @FXML
    private void mouseClickStickGrow(MouseEvent event) {
        //updateScoreLabel();
        stick.extendStick();
    }
    @FXML
    private void mouseReleaseStickFall(MouseEvent event) {
        stick.stopGrowth();
        stickfall();
        stick.setStickStatus(true);
        //updateScoreLabel();
    }
//    public void updateScoreLabel() {
//        if (score != null) {
//            score.setText(String.valueOf(scores));
//        } else {
//            System.out.println("Score label is null. Cannot update the score.");
//        }
//    }
//    public static void updateScore(){
//        scores++;
//    }
//    public static void resetScore(){
//        scores=0;
//    }
}
