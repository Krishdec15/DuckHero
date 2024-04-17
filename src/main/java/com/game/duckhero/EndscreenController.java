package com.game.duckhero;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EndscreenController {
    private MusicPlayerManager musicPlayerManager = MusicPlayerManager.getInstance();

    public void initialize(){
        Trans.fadeInTransition(endContainer);
    }
    public void setMusicPlayerManager(MusicPlayerManager musicPlayerManager) {
        this.musicPlayerManager = musicPlayerManager;
        System.out.println(musicPlayerManager.toString());

    }
    @FXML
    private AnchorPane endContainer;
    @FXML
    private ImageView buttonAudio;

    @FXML
    private ImageView buttonHome;

    @FXML
    private ImageView buttonMusic;

    @FXML
    private ImageView buttonRestart;

    @FXML
    private ImageView buttonSave;

    @FXML
    void audioHover(MouseEvent event) {
        double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonAudio, scaleX, scaleY);
        buttonAudio.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Sound_on.png")));
    }

    @FXML
    void audioHoverOff(MouseEvent event) {
        double scaleX = 1.0 , scaleY = 1.0;
        Trans.scaleTransition(buttonAudio, scaleX, scaleY);
        buttonAudio.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Sound_off.png")));
    }

    @FXML
    void homeHover(MouseEvent event) {
        double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonHome, scaleX, scaleY);
        buttonHome.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_home_hover.png")));
    }

    @FXML
    void homeHoverOff(MouseEvent event) {
        double scaleX = 1.0 , scaleY = 1.0;
        Trans.scaleTransition(buttonHome, scaleX, scaleY);
        buttonHome.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_home_normal.png")));
    }

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
    void restartHover(MouseEvent event) {
        double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonRestart, scaleX, scaleY);
        buttonRestart.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Replay_hover.png")));
    }

    @FXML
    void restartHoverOff(MouseEvent event) {
        double scaleX = 1.0 , scaleY = 1.0;
        Trans.scaleTransition(buttonRestart, scaleX, scaleY);
        buttonRestart.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Replay_Normal.png")));
    }

    @FXML
    void saveHover(MouseEvent event) {
        double scaleX = 1.2 , scaleY = 1.2;
        Trans.scaleTransition(buttonSave, scaleX, scaleY);
        buttonSave.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Saved_hover.png")));
    }

    @FXML
    void saveHoverOff(MouseEvent event) {
        double scaleX = 1.0 , scaleY = 1.0;
        Trans.scaleTransition(buttonSave, scaleX, scaleY);
        buttonSave.setImage(new Image(getClass().getResourceAsStream("/com/game/duckhero/resources/Button_Save_game.png")));
    }

    @FXML
    void toggleAudio(MouseEvent event) {

    }

    @FXML
    void toggleHome(MouseEvent event) {
        try {
            Trans.fadeInTransition(endContainer,"start_screen.fxml");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @FXML
    void toggleMusic(MouseEvent event) {
        try {
            if (musicPlayerManager != null) {
                musicPlayerManager.toggleMusic();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    @FXML
    void toggleRestart(MouseEvent event) {
        try {
            Trans.fadeInTransition(endContainer,"game_screen.fxml");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @FXML
    void toggleSave(MouseEvent event) {

    }

}
