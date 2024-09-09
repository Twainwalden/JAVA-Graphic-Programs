package SunriseDemo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Moonrise.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public class MoonriseVector {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 250;
    public static final Color SKY_COLOR = new Color(0, 63, 117);

    /**
     * main method.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // initialize moon object
        CelestialObject moon = new CelestialObject(
            "SunriseDemo/img/moon_sprite.png",
            -100, 0, 100);
        // initialize sun object
        CelestialObject sun = new CelestialObject(
            "SunriseDemo/img/sun_sprite.png",
            -150, 0, 150);
        // set up canvas
        StdDraw.setTitle("Moonrise");
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.enableDoubleBuffering();
        // set step value for speed up and slow down
        double step = 1;
        // forever loop
        while (true) {
            for (double i = -50.0; i <= 550.0; i = i + step) {
                moon.draw();
                StdDraw.show();
                StdDraw.pause(1);
                moon.setX(i);
                moon.setY(moon.path((double) i));
                StdDraw.clear(StdDraw.BLACK);
                step = keyStep(step);
            }
            for (double i = -75.0; i <= 575.0; i = i + step) {
                sun.draw();
                StdDraw.show();
                StdDraw.pause(1);
                sun.setX(i);
                sun.setY(sun.path((double) i));
                StdDraw.clear();
                step = keyStep(step);
            }
        }
    }

    /**
     * key step.
     *
     * @param currentStep step from before call
     * @return step
     */
    public static double keyStep(double currentStep) {
        double step = currentStep;
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            step += 0.1;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)
            && step - 1 > 0) {
            step -= 0.1;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
            if (step == 0) {
                step += 1;
            } else {
                step = 0;
            }
        }
        return step;
    }
}
