package Day_10;

import shared.DataSet;

// it represents position on the map
public class Pipe {
    int x;
    int y;

    public Pipe (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pipe nextMove(Direction direction) {
        Pipe nextPipe = new Pipe(x + direction.dx, y + direction.dy);

        return nextPipe;
    }
}
