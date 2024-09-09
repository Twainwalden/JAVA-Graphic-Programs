package DiskDemo;

/**
 * Diagonal direction enumerated class for TV visual.
 *
 * @author Jackie Trumpower
 * @version 4.8.2024
 */
public enum Diagonal {

    NORTHWEST(0, 2),
    NORTHEAST(2, 2),
    SOUTHWEST(0, 0),
    SOUTHEAST(2, 0);

    private final double dx;
    private final double dy;

    /**
     * Explicit Value Constructor.
     *
     * @param dx delta in x
     * @param dy delta in y
     */
    Diagonal(double dx, double dy) {
        this.dx = dx - 1;
        this.dy = dy - 1;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Method to calculate a bounce from a corner.
     *
     * @return resulting direction
     */
    public Diagonal bounceInCorner() {
        switch (this) {
            case NORTHWEST:
                return SOUTHEAST;
            case NORTHEAST:
                return SOUTHWEST;
            case SOUTHWEST:
                return NORTHEAST;
            case SOUTHEAST:
            default:
                return NORTHWEST;
        }
    }

    /**
     * Method to calculate a bounce from a side.
     *
     * @return resulting direction
     */
    public Diagonal bounceInSide() {
        switch (this) {
            case NORTHWEST:
                return NORTHEAST;
            case NORTHEAST:
                return NORTHWEST;
            case SOUTHWEST:
                return SOUTHEAST;
            case SOUTHEAST:
            default:
                return SOUTHWEST;
        }
    }

    /**
     * Method to calculate a bounce from the floor/ceiling.
     *
     * @return resulting direction
     */
    public Diagonal bounceInBase() {
        switch (this) {
            case NORTHWEST:
                return SOUTHWEST;
            case NORTHEAST:
                return SOUTHEAST;
            case SOUTHWEST:
                return NORTHWEST;
            case SOUTHEAST:
            default:
                return NORTHEAST;
        }
    }
}
