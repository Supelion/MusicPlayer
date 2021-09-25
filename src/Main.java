// Importing them juicy modules / classes
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

// The everything
public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Using JOptionPane to show the user an input dialog and asking the name of the .wav file. We add the extension manually later
        String filename = "./Music/audio.wav";

        // All the actual stuff like getting the .wav file and playing it
        File file = new File(filename);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();

        String response = "";

        // As long as the response is not q, do this
        while (!response.equals("q")) {
            // Giving the user a list of options to choose from, because the can, unlike the people of china
            response = JOptionPane.showInputDialog(null, "R = Resume / Play\nP = Pause\nQ = Quit");
            response = response.toLowerCase();

            switch (response) {
                case "r": clip.start();
                break;
                case "p": clip.stop();
                break;
                case "q": clip.close();
                break;
                default: System.out.println("Invalid Response!");
            }
        }

        System.out.println("Exiting...");
    }
}