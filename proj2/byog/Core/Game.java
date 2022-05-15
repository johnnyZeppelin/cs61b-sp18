package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    private class Position {
        private int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Game() {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        StdDraw.setCanvasSize(WIDTH * 16, HEIGHT * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();
    }

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().

        TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];
        initializeWorld(finalWorldFrame);

        Random random = new Random(input.length());

        int index = random.nextInt(10);

        int maxWidth = index == 0 ? index + 1 : index;

        addRandomLinesOfBlocks(new Position(maxWidth, HEIGHT - maxWidth), new Position(WIDTH - maxWidth, maxWidth), maxWidth, random,
                Tileset.WALL, finalWorldFrame);

        return finalWorldFrame;
    }

    public void initializeWorld(TETile[][] world) {
        final int WIDTH = world.length;
        final int HEIGHT = world[0].length;
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    public void drawFrame(String s) {
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(WIDTH / 2, HEIGHT / 2, s);
        StdDraw.show();
    }

    public String solicitNCharsInput(int n) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < n) {
            if (StdDraw.hasNextKeyTyped()) {
                ++i;
                try {
                    sb.append(StdDraw.nextKeyTyped());
                    drawFrame(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public void addALineOfBlocks(Position p0, Position p1, TETile tile, TETile[][] world) {
        int sx = p0.x < p1.x ? 1 : -1, sy = p0.y < p1.y ? 1 : -1;
        int i = p0.x, j = p0.y;
        while (i != p1.x + sx || j != p1.y + sy) {
            world[i][j] = tile;
            i = i == p1.x ? i : i + sx;
            j = j == p1.y ? j : j + sy;
        }
    }

    public void addALineOfBlocks(int p, int len, boolean isHorizontal, int maxWidth, Random random, TETile tile, TETile[][] world) {
        for (int i = 0; i < len; ++i) {
            int a = random.nextInt(maxWidth);
            if (isHorizontal) {
                world[i + a][p] = tile;
            } else {
                world[p][i + a] = tile;
            }
        }
    }

    public void addRandomLinesOfBlocks(Position leftUp, Position rightDown, int maxWidth, Random random, TETile tile, TETile[][] world) {
        for (int i = leftUp.x; i < rightDown.x; i += random.nextInt(maxWidth)) {
            addALineOfBlocks(i, leftUp.y - rightDown.y - random.nextInt(maxWidth), false, maxWidth, random, tile, world);
        }
        for (int i = leftUp.y; i > rightDown.y; i -= random.nextInt(maxWidth)) {
            addALineOfBlocks(i, rightDown.x - leftUp.x - random.nextInt(maxWidth), true, maxWidth, random, tile, world);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.drawFrame("Input the string: ");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = game.solicitNCharsInput(5);

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = game.playWithInputString(string);
        ter.renderFrame(world);
    }
}
