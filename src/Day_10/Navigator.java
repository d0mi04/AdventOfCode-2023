package Day_10;

import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.Map;
import java.util.stream.Collectors;

public class Navigator {
    private static final Map<Character, UnaryOperator<Direction>> PIPE_MAP = Map.of(
            '|', d -> {
                if(d == Direction.NORTH || d == Direction.SOUTH) {
                    return d;
                }
                return null;
            },
            '-', d -> {
                if(d == Direction.EAST || d == Direction.WEST) {
                    return d;
                }
                return null;
            },
            'L', d -> {
                if(d == Direction.SOUTH) {
                    return Direction.EAST;
                } else if (d == Direction.WEST) {
                    return Direction.NORTH;
                }
                return null;
            },
            'J', d -> {
                if(d == Direction.SOUTH) {
                    return Direction.WEST;
                } else if (d == Direction.EAST) {
                    return Direction.NORTH;
                }
                return null;
            },
            '7', d -> {
                if(d == Direction.EAST) {
                    return Direction.SOUTH;
                } else if (d == Direction.NORTH) {
                    return Direction.WEST;
                }
                return null;
            },
            'F', d -> {
                if(d == Direction.NORTH) {
                    return Direction.EAST;
                } else if (d == Direction.WEST) {
                    return Direction.SOUTH;
                }
                return null;
            }
    );

    public int findFarthestPipe(ArrayList<String> lines) {
        String data = lines.stream().collect(Collectors.joining());

        int width = lines.getFirst().length();
        int height = lines.size();

        PipeMap pipeMap = new PipeMap(data, width, height);

        int startIndex = data.indexOf('S');
        Pipe startPipe = new Pipe(startIndex % width, startIndex / width);

        Direction initialDirection = null;
        for(Direction direction : Direction.values()) {
            Pipe nextPipe = startPipe.nextMove(direction);

            if(pipeMap.isPositionOnMap(nextPipe)) {
                char symbol = pipeMap.getChar(nextPipe);

                UnaryOperator<Direction> directionFunction = PIPE_MAP.getOrDefault(symbol, __ -> null);

                if(directionFunction.apply(direction) != null) {
                    initialDirection = direction;
                    break;
                }
            }
        }

        return navigate(pipeMap, startPipe, initialDirection);
    }

    public int navigate(PipeMap pipeMap, Pipe startPipe, Direction initialDirection) {
        int step = 0;
        Pipe pipe = startPipe;
        Direction direction = initialDirection;

        while(true) {
            pipe = pipe.nextMove(direction);
            char symbol = pipeMap.getChar(pipe);

            if(symbol == 'S') {
                break;
            }

            direction = PIPE_MAP.get(symbol).apply(direction);
            step++;
        }

        return step / 2 + step % 2;
    }
}
