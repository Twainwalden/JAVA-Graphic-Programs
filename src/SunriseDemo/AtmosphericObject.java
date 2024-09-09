package SunriseDemo;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Objects in the sky.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public class AtmosphericObject extends AnimatedObject {
    private double xScale;
    private double yScale;

    /**
     * constructor.
     *
     * @param filename file
     * @param x x
     * @param y y
     * @param xScale xScale
     * @param yScale yScale
     */
    public AtmosphericObject(String filename, double x,
        double y, double xScale, double yScale) {
        super(filename, x, y);
    }

    /**
     * draw method.
     */
    public void draw() {
        StdDraw.picture(x, y, filename, xScale, yScale);
    }
}
