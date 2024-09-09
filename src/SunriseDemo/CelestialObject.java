package SunriseDemo;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Class for mimicing an arc across the screen.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public class CelestialObject extends AnimatedObject {
    private int scale;

    /**
     * Constructor.
     *
     * @param filename filename
     * @param x x
     * @param y y
     * @param scale scale
     */
    public CelestialObject(String filename, double x, double y, int scale) {
        super(filename, x, y);
        this.scale = scale;
    }

    /**
     * path calculation.
     *
     * @param x x
     * @return y
     */
    public double path(double x) {
        double result = (
            -3.8 * (Math.pow(((x / (double) 40) - 6.25), 2))) + 150;
        return result;
    }

    /**
     * draw.
     */
    public void draw() {
        StdDraw.picture(x, y, filename, scale, scale);
    }
}
