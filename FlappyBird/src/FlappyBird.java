/* Saya Boy Aditya Rohmaulana NIM 2203488 mengerjakan
soal Latihan Praktikum 7 dalam mata kuliah DPBO untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    // Frame attributes
    int frameWidth = 360;
    int frameHeight = 640;

    // Image attriutes
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    // Player
    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    // Pipes
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    // Game logic
    Timer gameloop;
    int gravity = 1;
    Timer pipesCooldown;
    boolean isGameOver = false;
    int score = 0;
    JLabel scoreLabel;

    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);
        // setBackground(Color.blue);

        // Load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        // Score label
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(scoreLabel);

        // Player
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        // Pipes cooldown timer
        pipesCooldown = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        pipesCooldown.start();

        gameloop = new Timer(1000 / 60, this);
        gameloop.start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        // Draw pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }
    }


    public void move() {
        // Player movement
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        // Pipe movement
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();

        // Check if player hits the bottom of the frame
        if (player.getPosY() + player.getHeight() >= frameHeight) {
            gameOver();
        }

        // Check if player hits a pipe
        for (Pipe pipe : pipes) {
            Rectangle playerRect = new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
            Rectangle pipeRect = new Rectangle(pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight());

            if (playerRect.intersects(pipeRect)) {
                gameOver();
            }

            // Check if player passes a pipe
            if (pipe.getImage() == lowerPipeImage && player.getPosX() > pipe.getPosX() + pipe.getWidth() && !pipe.isPassed()) {
                pipe.setPassed(true);
                score++;
                scoreLabel.setText("Score: " + score);
            }
        }

        repaint();
    }


    // gameOver method to stop the game
    private void gameOver() {
        gameloop.stop();
        pipesCooldown.stop();
        isGameOver = true;
    }

    // restartGame method to restart the game
    public void restartGame() {
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();
        score = 0;
        scoreLabel.setText("Score: " + score);
        isGameOver = false;
        gameloop.start();
        pipesCooldown.start();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Press SPACE to make the player jump
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10);
        }

        // Press R to restart the game
        if (isGameOver && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void placePipes() {
        int randomPipePosY = (int) (pipeStartPosY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = frameHeight / 4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPipePosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, randomPipePosY + pipeHeight + openingSpace, pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }
}
