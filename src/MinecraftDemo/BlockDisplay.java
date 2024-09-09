package MinecraftDemo;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Displays a random block assortment.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public class BlockDisplay {
    /**
     * main.
     *
     * @param args command args
     */
    public static void main(String[] args) {
        // create Block Display object
        // set up canvas
        StdDraw.setTitle("Jackie's 2D Minecraft");
        StdDraw.setCanvasSize(300, 300);
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        while (true) {
            // create blocks
            BlockGeneration blocks = new BlockGeneration();
            for (int y = 0; y < blocks.getGeneration().length; y++) {
                for (int x = 0; x < blocks.getGeneration()[0].length; x++) {
                    if (blocks.getGeneration()[y][x] == 0) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite0.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 1) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite1.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 2) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite2.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 3) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite3.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 4) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite4.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 6) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite6.png", 1, 1);
                    } else if (blocks.getGeneration()[y][x] == 7) {
                        StdDraw.picture(x + 0.5, -y + 9.5,
                            "MinecraftDemo/img/MC_sprite7.png", 1, 1);
                    }
                }
            }
            StdDraw.show();
            StdDraw.pause(400);
        }
    }
}
