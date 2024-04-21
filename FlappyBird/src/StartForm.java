/* Saya Boy Aditya Rohmaulana NIM 2203488 mengerjakan
soal Latihan Praktikum 7 dalam mata kuliah DPBO untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends JFrame {
    public StartForm() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add a label at the top
        JLabel titleLabel = new JLabel("Welcome to Flappy Bird!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        // Add some space between the label and the image
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Add an image in the center
        ImageIcon icon = new ImageIcon(getClass().getResource("assets/bird.png"));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(imageLabel);

        // Add some space between the image and the button
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Add a start button at the bottom
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close StartForm
                dispose();

                // Open FlappyBird
                JFrame frame = new JFrame("Flappy Bird");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(360, 640);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                FlappyBird flappyBird = new FlappyBird();
                frame.add(flappyBird);
                frame.pack();
                flappyBird.requestFocus();
                frame.setVisible(true);
            }
        });
        add(startButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}