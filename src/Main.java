// Importing them juicy modules / classes
import javax.sound.sampled.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

// The everything
public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException {
        String filename = "./music/audio.wav";

        // Loading custom font (Sora)
        Font sora = Font.createFont(Font.TRUETYPE_FONT, new File("./images/Sora.ttf")).deriveFont(14f);
        Color fontColor = new Color(215, 70, 193);
        Color backgroundColor = new Color(255, 255, 255);

        // All the actual stuff like getting the .wav file and playing it
        File file = new File(filename);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();

        // Styling and code for the start / resume button
        JButton start = new JButton("Start / Resume", new ImageIcon("./images/resume.png"));
        start.setBounds(10, 10, 190, 50);
        start.setFocusable(false);
        start.setBackground(backgroundColor);
        start.setForeground(fontColor);
        start.addActionListener(e -> clip.start());
        start.setFont(sora);

        // Styling and code for the pause button
        JButton pause = new JButton("Pause", new ImageIcon("./images/pause.png"));
        pause.setBounds(300, 10, 170, 50);
        pause.setText("Pause");
        pause.setFocusable(false);
        pause.setForeground(fontColor);
        pause.setBackground(backgroundColor);
        pause.addActionListener(e -> clip.stop());
        pause.setFont(sora);

        // The actual frame of the music player app
        JFrame frame = new JFrame();
        ImageIcon logo = new ImageIcon("./images/logo.png");
        frame.setTitle("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(249, 220, 126));
        frame.setSize(500, 160);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(pause);
        frame.add(start);
    }
}
