package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
            "You got this!", "You're a star!", "Go Bears!",
            "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40, seed);
        game.startGame();
    }

    public MemoryGame(int width, int height, int seed) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //TODO: Initialize random number generator
        rand = new Random(seed);
    }

    public String generateRandomString(int n) {
        //TODO: Generate random string of letters of length n
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; ++i) {
            sb.append(CHARACTERS[rand.nextInt(26)]);
        }
        return sb.toString();
    }

    public void drawFrame(String s) {
        //TODO: Take the string and display it in the center of the screen
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(new Color(255, 160, 32));
        StdDraw.text(width / 2, height / 2, s);
        //StdDraw.enableDoubleBuffering(); // has been enabled in the constructor
        StdDraw.setFont(new Font("Monaco", Font.CENTER_BASELINE, 23));
        StdDraw.text(width / 8, height * 0.95, "Round: " + round);
        if (!gameOver) {
            StdDraw.text(width / 2, height * 0.95, playerTurn ? "Type!" : "Watch!");
        }
        if (playerTurn) {
            StdDraw.text(width * 5 / 6, height * 0.95, ENCOURAGEMENT[new Random().nextInt(round > 10 ? 7 : 6)]);
        }
        StdDraw.line(0, height * 0.923, width, height * 0.923);
        StdDraw.show();

        //TODO: If game is not over, display relevant game information at the top of the screen
    }

    public void flashSequence(String letters) {
        //TODO: Display each character in letters, making sure to blank the screen between letters
        char[] cs = letters.toCharArray();
        for (char c : cs) {
            drawFrame("" + c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            drawFrame("");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String solicitNCharsInput(int n) {
        //TODO: Read n letters of player input
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < n) {
            if (StdDraw.hasNextKeyTyped()) {
                ++i;
                try {
                    sb.append(StdDraw.nextKeyTyped());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public void startGame() {
        //TODO: Set any relevant variables before the game starts
        round = 1;
        gameOver = false;
        playerTurn = false;

        //TODO: Establish Game loop
        for (round = 1; !gameOver; ++round) {
            drawFrame("Round: " + round);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String target = generateRandomString(round);
            flashSequence(target);
            playerTurn = true;
            drawFrame("");
            String attempt = solicitNCharsInput(round);
            drawFrame(attempt);
            playerTurn = false;
            if (!target.equals(attempt)) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                drawFrame("Game Over! You made it to round: " + round);
                gameOver = true;
            } else {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
