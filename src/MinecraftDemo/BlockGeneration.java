package MinecraftDemo;

import java.util.Random;

/**
 * Creates a list of values for random generation.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public class BlockGeneration {
    private Random random = new Random();
    private int[][] generation = {
        // Dirt Layers
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // LAYER 0: Grass Blocks Only
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // Layer 1: Dirt Blocks Only
        // Dirt + Stone Layers
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // Layer 2: Average of 2 Stone Blocks
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // Layer 3: Average of 8 Stone Blocks
        // Stone + Mineral Layers
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, // Layer 4: Chance for Coal or Minerals
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };

    /**
     * Randomizes list.
     */
    public BlockGeneration() {
        for (int i = 0; i < generation.length; i++) {
            if (i == 2) {
                createRandomLayerDirtAndStone(0.1, 2);
            } else if (i == 3) {
                createRandomLayerDirtAndStone(0.3, 3);
            }
        }
        addVeins(2, 7, 6);
        addVeins(1, 2, 3);
        addVeins(1, 2, 4);
    }

    public int[][] getGeneration() {
        return generation;
    }

    /**
     * Creates blend layers between stone and dirt.
     *
     * @param chance chance that a block will be stone
     * @param layerIndex depth of layer
     */
    public void createRandomLayerDirtAndStone(double chance, int layerIndex) {
        for (int i = 0; i < generation[layerIndex].length; i++) {
            if (random.nextFloat() < chance
                || generation[layerIndex - 1][i] == 2
                && layerIndex > 2) {
                generation[layerIndex][i] = 2;
            }
        }
    }

    /**
     * addVeins.
     *
     * @param numberOfVeins how many veins are drawn
     * @param numberOfShell how many vein blocks surround the first
     * @param blockNumber type of block used
     */
    public void addVeins(int numberOfVeins, int numberOfShell,
        int blockNumber) {
        for (int i = 0; i < numberOfVeins; i++) {
            int y = random.nextInt(4, generation.length);
            int x = random.nextInt(generation[0].length);
            if (generation[y][x] == 2) {
                generation[y][x] = blockNumber;
            }
            for (int j = 0; j < numberOfShell; j++) {
                int y2 = random.nextInt(-1, 1);
                int x2 = random.nextInt(-1, 1);
                if (0 <= (y + y2) && (y + y2) <= 9
                    && 0 <= (x + x2) && (x + x2) <= 9
                    && generation[y + y2][x + x2] == 2) {
                    generation[y + y2][x + x2] = blockNumber;
                }
            }
        }
    }

    /**
     * Place a given block.
     *
     * @param x x
     * @param y y
     * @param blockType type of block
     */
    public void placeBlock(int x, int y, int blockType) {
        generation[y][x] = blockType;
    }
}
