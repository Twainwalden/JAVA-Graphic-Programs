package DiskDemo;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Bouncing little guy.
 *
 * @author Jackie Trumpower
 * @version 4.8.2024
 */
public class Logo {
    private int x;
    private int y;
    private int height;
    private int width;
    private String filename;
    private Diagonal currentDirection;

    /**
     * Logo class constructor.
     *
     * @param x x coord
     * @param y y coord
     * @param height height
     * @param width width
     * @param filename filename
     * @param c c
     */
    public Logo(int x, int y,  int height,
        int width, String filename, Diagonal c) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.filename = filename;
        this.currentDirection = c;
    }

    public Diagonal getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Diagonal direction) {
        this.currentDirection = direction;
    }

    /**
     * Returns true if logo is on or in a corner.
     *
     * @return boolean if in corner
     */
    public boolean inCorner() {
        if (x + width / 2 > TV.SCREEN_WIDTH
            && y + height / 2 > TV.SCREEN_HEIGHT
            || x + width / 2 > TV.SCREEN_WIDTH
            && y - height / 2 < 0
            || x - width / 2 < 0
            && y + height / 2 > TV.SCREEN_HEIGHT
            || x - width / 2 > TV.SCREEN_WIDTH
            && y - height / 2 < TV.SCREEN_HEIGHT) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if logo is on or in a wall.
     *
     * @return boolean if in wall
     */
    public boolean inSide() {
        if (x + width / 2 > TV.SCREEN_WIDTH
            || x - width / 2 < 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if Logo is in floor.
     *
     * @return if it is
     */
    public boolean inFloor() {
        if (y + height / 2 > TV.SCREEN_HEIGHT
            || y - height / 2 < 0) {
            return true;
        }
        return false;
    }

    /**
     * Update method for Logo.
     */
    public void step() {
        x += currentDirection.getDx();
        y += currentDirection.getDy();
    }

    /**
     * Draw method.
     */
    public void draw() {
        StdDraw.picture(x, y, filename, width, height);
    }
}
