package com.game.duckhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;


public class HomeScreenController {
    private TranslateTransition backgroundTransition;
    private MusicPlayerManager musicPlayerManager = MusicPlayerManager.getInstance();
    public void initialize() {
        // Background movements
        backgroundTransition = new TranslateTransition(Duration.seconds(8), background);
        backgroundTransition.setByX(450); // Adjust the value based on your scene size
        backgroundTransition.setCycleCount(TranslateTransition.INDEFINITE);
        backgroundTransition.play();
    }

    @FXML
    private ImageView background;

    @FXML
    private AnchorPane homeContainer;

    @FXML
    private ImageView buttonMusic;

    @FXML
    private ImageView buttonPlay;

    @FXML
    private ImageView buttonSound;

    //Methods
    @FXML
        void musicHover(MouseEvent event) {
            double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonMusic, scaleX, scaleY);
            buttonMusic.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Music_Hover.png")));
        }

        @FXML
        void musicHoverOff(MouseEvent event) {
            double scaleX = 1.0 , scaleY = 1.0;
            Trans.scaleTransition(buttonMusic, scaleX, scaleY);
            buttonMusic.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Music_Normal.png")));
        }

        @FXML
        void playHover(MouseEvent event) {
            double scaleX = 1.2 , scaleY = 1.2;
            Trans.scaleTransition(buttonPlay, scaleX, scaleY);
            buttonPlay.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Play_Hover.png")));
        }

        @FXML
        void playHoverOff(MouseEvent event) {
            double scaleX = 1.0 , scaleY = 1.0;
            Trans.scaleTransition(buttonPlay, scaleX, scaleY);
            buttonPlay.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Play_Normal.png")));
        }

        @FXML
        void soundHover(MouseEvent event) {
            double scaleX = 1.2 , scaleY = 1.2;
            Trans.scaleTransition(buttonSound, scaleX, scaleY);
            buttonSound.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Sound_on.png")));
        }

        @FXML
        void soundHoverOff(MouseEvent event) {
            double scaleX = 1.0 , scaleY = 1.0;
            Trans.scaleTransition(buttonSound,scaleX,scaleY);
            buttonSound.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Sound_off.png")));
        }

    @FXML
    void toggleMusicButton(MouseEvent event) {
        try {
            if (musicPlayerManager != null) {
                musicPlayerManager.toggleMusic();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    @FXML
    public void togglePlayButton(MouseEvent event) {
        try {
            Trans.fadeOutTransition(homeContainer,"game_screen.fxml");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    @FXML
    public void toggleAudioButton(MouseEvent event) {

    }
}