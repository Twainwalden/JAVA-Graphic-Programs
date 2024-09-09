package DiskDemo;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

/**
 * Main code.
 *
 * @author Jackie Trumpower
 * @version 4.8.2024
 */
public class TV {
    public static final Color SCREEN_COLOR = Color.BLACK;
    public static final int SCREEN_HEIGHT = 300;
    public static final int SCREEN_WIDTH = 400;

    /**
     * TV main.
     *
     * @param args extra
     */
    public static void main(String[] args) {

        Logo logo = new Logo(90, 60,
            SCREEN_HEIGHT / 5, SCREEN_WIDTH / 5, "DiskDemo/logo_sprite.png",
            Diagonal.NORTHWEST);

        StdDraw.setTitle("Jackie's Television");
        StdDraw.setCanvasSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        StdDraw.setXscale(0, SCREEN_WIDTH);
        StdDraw.setYscale(0, SCREEN_HEIGHT);
        StdDraw.enableDoubleBuffering();

        while (true) {
            logo.draw();
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.show();
            StdDraw.pause(15);
            if (logo.inCorner()) {
                logo.setCurrentDirection(
                    logo.getCurrentDirection().bounceInCorner()
                );
            } else if (logo.inSide()) {
                logo.setCurrentDirection(
                    logo.getCurrentDirection().bounceInSide()
                );
            } else if (logo.inFloor()) {
                logo.setCurrentDirection(
                    logo.getCurrentDirection().bounceInBase()
                );
            }
            logo.step();
            StdDraw.clear(SCREEN_COLOR);
        }
    }
}
