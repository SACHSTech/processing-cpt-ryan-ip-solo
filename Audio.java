import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
    private Clip clip;
    private AudioInputStream audioInputStream;
    private long pausedPosition; // To store the position where playback was paused
    private boolean isPaused;

    public Audio(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        pausedPosition = 0;
        isPaused = false;
    }

    public void play(int loopCount) {
        if (!clip.isRunning()) {
            if (isPaused) {
                clip.setMicrosecondPosition(pausedPosition); // Resume from paused position
                isPaused = false;
            }
            clip.start();
            if (loopCount == 1) {
                clip.loop(0);
            } else if (loopCount == 0) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
    }

    public void stop() {
        if (clip.isRunning()) {
            pausedPosition = clip.getMicrosecondPosition(); // Store current position
            clip.stop();
            isPaused = true;
        }
    }

    public void reset() {
        clip.setMicrosecondPosition(0);
        pausedPosition = 0;
        isPaused = false;
    }

    public boolean isRunning() {
        return clip.isRunning();
    }

    public void setMicrosecondPosition(long microseconds) {
        clip.setMicrosecondPosition(microseconds);
    }

    public static Audio[] initializeAudioArray(String[] audioPaths) {
        Audio[] audioArray = new Audio[audioPaths.length];
        for (int i = 0; i < audioPaths.length; i++) {
            try {
                audioArray[i] = new Audio(audioPaths[i]);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                audioArray[i] = null;
            }
        }
        return audioArray;
    }
}
