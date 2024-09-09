package SunriseDemo;

/**
 * Animated abstract class.
 *
 * @author Jackie Trumpower
 * @version 4.12.2024
 */
public abstract class AnimatedObject {
    protected String filename;
    protected double x;
    protected double y;

    /**
     * constructor for abstract.
     *
     * @param filename file
     * @param x x
     * @param y y
     */
    public AnimatedObject(String filename, double x, double y) {
        this.filename = filename;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getFilename() {
        return filename;
    }

    /**
     * abstract for draw method.
     */
    public abstract void draw();
}
