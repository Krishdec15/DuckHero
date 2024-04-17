package com.game.duckhero;
// SINGLETON DESIGN PATTERN USED
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayerManager {
    private static MusicPlayerManager musicPlayerManager;
    private List<String> musicFiles = loadFiles("src/main/resources/com/game/duckhero/resources/music");
    private MediaPlayer mediaPlayer;
    private boolean isMusicPlaying;
    private MusicPlayerManager() {}
    public static MusicPlayerManager getInstance() {
        if (musicPlayerManager == null) {
            musicPlayerManager = new MusicPlayerManager();
        }
        return musicPlayerManager;
    }

    public void initialize() {
        if (!musicFiles.isEmpty()) {
            playRandomTrack(musicFiles);
        }
    }

    public void toggleMusic() {
        if (mediaPlayer != null) {
            if (isMusicPlaying) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
            isMusicPlaying = !isMusicPlaying;
        }
    }

    private void playRandomTrack(List<String> files) {
        String randomMusicFile = getRandomElement(files);
        Media sound = new Media(new File(randomMusicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(.5);

        // Autostart the media player
        mediaPlayer.setOnEndOfMedia(() -> playRandomTrack(files));

        mediaPlayer.play();
    }

    private <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
    public static List<String> loadFiles(String folderPath) {
        List<String> soundFiles = new ArrayList<>();
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isSoundFile(file.getName())) {
                        soundFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return soundFiles;
    }
    private static boolean isSoundFile(String fileName) {
        return fileName.endsWith(".mp3") || fileName.endsWith(".wav") || fileName.endsWith(".ogg")|| fileName.endsWith(".m4a");
    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}

