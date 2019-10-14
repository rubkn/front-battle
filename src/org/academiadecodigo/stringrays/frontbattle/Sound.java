package org.academiadecodigo.stringrays.frontbattle;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;

    public void playMusic(String path) {

        try{
            File musicPath = new File(path);

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.drain();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Wrong path.");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        clip.stop();
    }
}
