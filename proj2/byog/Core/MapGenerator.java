package byog.Core;

import byog.TileEngine.TETile;

import java.awt.*;

public class MapGenerator {
    private int seed;
    private TETile[][] world;

    public MapGenerator(int seed, TETile[][] world) {
        this.seed = seed;
        this.world = world;
    }

    public void addBlocks(int x0, int y0, int x1, int y1, TETile tile) {
        int sx = x1 > x0 ? 1 : -1, sy = y1 > y0 ? 1 : -1;
        for (int i = x0; sx * i < sx * x1 + sx; i += sx) {
            for (int j = y0; sy * j < sy * y1 + sy; j += sy) {
                world[i][j] = tile;
            }
        }
    }
}
