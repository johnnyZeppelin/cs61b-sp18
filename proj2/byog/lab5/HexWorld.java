package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static class Position {
        transient int px, py;

        public Position(int _px, int _py) {
            px = _px;
            py = _py;
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

    public static TETile getTile(int code, boolean isVariant) {
        switch (code) {
            case 0:
                return isVariant ? TETile.colorVariant(Tileset.TREE, 128, 128, 128, new Random()) : Tileset.TREE;
            case 1:
                return isVariant ? TETile.colorVariant(Tileset.WALL, 128, 128, 128, new Random()) : Tileset.WALL;
            case 2:
                return isVariant ? TETile.colorVariant(Tileset.FLOOR, 128, 128, 128, new Random()) : Tileset.FLOOR;
            case 3:
                return isVariant ? TETile.colorVariant(Tileset.GRASS, 128, 128, 128, new Random()) : Tileset.GRASS;
            case 4:
                return isVariant ? TETile.colorVariant(Tileset.WATER, 128, 128, 128, new Random()) : Tileset.WATER;
            case 5:
                return isVariant ? TETile.colorVariant(Tileset.FLOWER, 128, 128, 128, new Random()) : Tileset.FLOWER;
            case 6:
                return isVariant ? TETile.colorVariant(Tileset.LOCKED_DOOR, 128, 128, 128, new Random()) : Tileset.LOCKED_DOOR;
            case 7:
                return isVariant ? TETile.colorVariant(Tileset.UNLOCKED_DOOR, 128, 128, 128, new Random()) : Tileset.UNLOCKED_DOOR;
            case 8:
                return isVariant ? TETile.colorVariant(Tileset.SAND, 128, 128, 128, new Random()) : Tileset.SAND;
            case 9:
                return isVariant ? TETile.colorVariant(Tileset.MOUNTAIN, 128, 128, 128, new Random()) : Tileset.MOUNTAIN;
            case 10:
                return isVariant ? TETile.colorVariant(Tileset.PLAYER, 128, 128, 128, new Random()) : Tileset.PLAYER;
            case 11:
                return isVariant ? TETile.colorVariant(Tileset.NOTHING, 128, 128, 128, new Random()) : Tileset.NOTHING;
            default:
                return getTile(new Random().nextInt(10), true);
        }
    }

    private static void addALine(int startPos, int endPos, int line, TETile[][] world, TETile tile, boolean isVariant) {
        for (int i = startPos; i < endPos; ++i) {
            world[i][line] = isVariant ? TETile.colorVariant(tile, 128, 128, 128, new Random()) : tile;
        }
    }

    public static void addHexagon(int size, Position p, TETile[][] world, TETile tile, boolean isVariant) {
        for (int i = 0; i < size; ++i) {
            int sp = p.px + i;
            int ep = sp + size + 2 * (size - i - 1);
            int lu = p.py + i;
            int ld = p.py - i - 1;
            addALine(sp, ep, lu, world, tile, isVariant);
            addALine(sp, ep, ld, world, tile, isVariant);
        }
    }

    public static void copyHexagon(int size, Position source, Position dest, TETile[][] world) {
        int total = size * (4 * size - 2);
        TETile[] backup = new TETile[total];
        int index = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = source.px + i; j < source.px + i + size + 2 * (size - 1 - i); ++j) {
                backup[index++] = world[j][source.py + i];
            }
        }
        for (int i = 0; i < size; ++i) {
            for (int j = source.px + i; j < source.px + i + size + 2 * (size - 1 - i); ++j) {
                backup[index++] = world[j][source.py - i - 1];
            }
        }

        int dexIndex = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = dest.px + i; j < dest.px + i + size + 2 * (size - 1 - i); ++j) {
                world[j][dest.py + i] = backup[dexIndex++];
            }
        }
        for (int i = 0; i < size; ++i) {
            for (int j = dest.px + i; j < dest.px + i + size + 2 * (size - 1 - i); ++j) {
                world[j][dest.py - i - 1] = backup[dexIndex++];
            }
        }
    }

    private static void addAColumnHexagons(int size, Position p, TETile[][] world, TETile tile, int amount, boolean isRandom, boolean isVariant, boolean mulTerrain) {
        if (amount == 0) return;
        if (!isRandom && isVariant) {
            addHexagon(size, p, world, tile, true);
            for (int i = 1; i < amount; ++i) {
                copyHexagon(size, p, new Position(p.px, p.py - i * 2 * size), world);
            }
            return;
        }
        for (int i = 0; i < amount; ++i) {
            if (mulTerrain) tile = getTile(new Random().nextInt(10), isVariant);
            if (isRandom && isVariant) {
                addHexagon(size, new Position(p.px, p.py - i * 2 * size), world, tile, true);
            } else if (isRandom) {
                addHexagon(size, new Position(p.px, p.py - i * 2 * size), world, tile, false);
                tile = TETile.colorVariant(tile, 128, 128, 128, new Random());
            } else {
                addHexagon(size, new Position(p.px, p.py - i * 2 * size), world, tile, false);
            }
        }
    }

    public static void add19Hexagons(int size, Position position, TETile[][] world, TETile tile, boolean isRandom, boolean isVariant, boolean mulTerrain) {
        Position p = new Position(position.px - (size / 2 + size - 1), position.py);
        p.px -= 2 * (2 * size - 1);
        p.py += 2 * size;
        for (int i = 3; i < 5; ++i) {
            addAColumnHexagons(size, p, world, tile, i, isRandom, isVariant, mulTerrain);
            p.px += 2 * size - 1;
            p.py += size;
        }
        for (int i = 5; i > 2; --i) {
            addAColumnHexagons(size, p, world, tile, i, isRandom, isVariant, mulTerrain);
            p.px += 2 * size - 1;
            p.py -= size;
        }
    }

    public static void main(String[] args) {
        final int WIDTH = 81;
        final int HEIGHT = 81;

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] zaWorld = new TETile[WIDTH][HEIGHT];
        initializeWorld(zaWorld);


        //addHexagon(3, new Position(5, 25), zaWorld, TETile.colorVariant(Tileset.FLOWER, 128, 128, 128, new Random()));
        add19Hexagons(6, new Position(40, 40), zaWorld, getTile(new Random().nextInt(10), true), true, true, true);

        ter.renderFrame(zaWorld);
    }
}
