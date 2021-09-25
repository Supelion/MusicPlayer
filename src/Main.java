// Importing them juicy modules / classes
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

// The everything
public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Using JOptionPane to show the user an input dialog and asking the name of the .wav file. We add the extension manually later
        String filename = "./music/audio.wav";

        // All the actual stuff like getting the .wav file and playing it
        File file = new File(filename);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();

        JButton start = new JButton();
        start.setBounds(10, 10, 150, 50);
        start.setText("Start / Resume");
        start.setFocusable(false);
        start.setBackground(new Color(255, 255, 255));
        start.setForeground(new Color(25, 20, 20));
        start.addActionListener(e -> clip.start());

        JButton pause = new JButton();
        pause.setBounds(300, 10, 150, 50);
        pause.setText("Pause");
        pause.setFocusable(false);
        pause.setForeground(new Color(25, 20, 20));
        pause.setBackground(new Color(255, 255, 255));
        pause.addActionListener(e -> clip.stop());

        ImageIcon logo = new ImageIcon("./images/logo.png");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 160);
        frame.setVisible(true);
        frame.setTitle("Supelion's Music Player");
        frame.setResizable(false);
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(30, 215, 96));
        frame.add(pause);
        frame.add(start);

        System.out.println("Exiting...");
    }
}