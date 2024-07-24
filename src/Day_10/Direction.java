package Day_10;

public enum Direction {
    // direction: x, y
    NORTH(0, -1), // one up
    SOUTH(0, 1), // one down
    EAST(1, 0), // one right
    WEST(-1, 0); // one left

    final int dx;
    final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
