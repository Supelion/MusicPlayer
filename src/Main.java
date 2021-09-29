// Importing them juicy modules / classes
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

// The everything
public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = "./music/audio.wav";

        // All the actual stuff like getting the .wav file and playing it
        File file = new File(filename);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();

        JButton start = new JButton("Start / Resume", new ImageIcon("./images/resume.png"));
        start.setBounds(10, 10, 170, 50);
        start.setFocusable(false);
        start.setBackground(new Color(255, 255, 255));
        start.setForeground(new Color(25, 20, 20));
        start.addActionListener(e -> clip.start());

        JButton pause = new JButton("Pause", new ImageIcon("./images/pause.png"));
        pause.setBounds(300, 10, 170, 50);
        pause.setText("Pause");
        pause.setFocusable(false);
        pause.setForeground(new Color(25, 20, 20));
        pause.setBackground(new Color(255, 255, 255));
        pause.addActionListener(e -> clip.stop());

        JFrame frame = new JFrame();
        ImageIcon logo = new ImageIcon("./images/logo.png");
        frame.setTitle("Supelion's Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(30, 215, 96));
        frame.setSize(500, 160);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(pause);
        frame.add(start);
    }
}