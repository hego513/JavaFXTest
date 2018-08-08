package sample;

import javax.sound.sampled.*;
import java.io.File;

public class SoundVoice {

    public  void soundVoice(File soundFile) throws Exception{

        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, af);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(ais);
            clip.loop(0);
            clip.flush();
            while(clip.isActive()) {
                Thread.sleep(100);
            }
        }finally {
            ais.close();
        }
    }
}

