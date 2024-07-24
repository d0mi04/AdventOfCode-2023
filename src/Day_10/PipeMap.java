package Day_10;

// create the map and work on the map
public class PipeMap {
    // Map of pipes
    private final String data;
    private final int width;
    private final int height;

    public PipeMap(String data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public boolean isPositionOnMap(Pipe pipe) {
        return pipe.x >= 0 && pipe.x < width &&
                pipe.y >= 0 && pipe.y < height;
    }

    public char getChar (Pipe pipe) {
        return data.charAt(pipe.x + pipe.y * width);
    }

}
