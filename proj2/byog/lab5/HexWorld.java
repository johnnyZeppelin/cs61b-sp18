package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static void addALine(int startPos, int endPos, int line,  TETile[][] world, TETile tile) {
        for (int i = startPos; i < endPos; ++i) {
            world[i][line] = TETile.colorVariant(tile, 120, 5, 6, new Random());
        }
    }

    public static void addHexagon(int size, Position p, TETile[][] world, TETile tile) {
        for (int i = 0; i < size; ++i) {
            int sp = p.px + i;
            int ep = sp + size + 2 * (size - i - 1);
            int lu = p.py + i; int ld = p.py - i - 1;
            addALine(sp, ep, lu, world, tile);
            addALine(sp, ep, ld, world, tile);
        }
    }

    public static void initializeWorld(TETile[][] world) {
        final int WIDTH = world.length;
        final int HEIGHT = world[0].length;
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    public static void main(String[] args) {
        final int WIDTH = 50;
        final int HEIGHT = 50;
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] zawaludo = new TETile[WIDTH][HEIGHT];
        initializeWorld(zawaludo);
        addHexagon(3, new Position(5, 25), zawaludo, Tileset.FLOWER);
        ter.renderFrame(zawaludo);
    }
}
class Position {
    transient int px, py;
    public Position(int _px, int _py) {
        px = _px;
        py = _py;
    }
}
