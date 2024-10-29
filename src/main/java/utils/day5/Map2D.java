package utils.day5;

public class Map2D {
    public int width;
    public int height;
    public int[][] map;

    public Map2D(int width, int height) {
        this.width = width;
        this.height = height;

        map = new int[width][height];
    }

    public void drawStraightLine(Line line) {
        if (line.isHorizontal()) {
            int min = Math.min(line.start.y, line.end.y);
            int max = Math.max(line.start.y, line.end.y);

            for (int y = min; y <= max; y++) {
                map[line.start.x][y]++;
            }
        } else if (line.isVertical()) {
            int min = Math.min(line.start.x, line.end.x);
            int max = Math.max(line.start.x, line.end.x);

            for (int x = min; x <= max; x++) {
                map[x][line.start.y]++;
            }
        }
    }

    public void drawLine(Line line) {
        if (line.isStraight()) {
            drawStraightLine(line);
        } else {
            int[] xRange = getIntsInRange(line.start.x, line.end.x);
            int[] yRange = getIntsInRange(line.start.y, line.end.y);

            for (int i = 0; i < xRange.length; i++) {
                drawPosition(new Position(xRange[i], yRange[i]));
            }
        }
    }

    private int[] getIntsInRange(int a, int b) {
        int[] result;

        if (a >= b) {
            int size = a - b + 1;
            result = new int[size];
            for (int i = 0; i < size; i++) {
                result[i] = a - i;
            }

        } else {
            int size = b - a + 1;
            result = new int[size];
            for (int i = 0; i < size; i++) {
                result[i] = a + i;
            }
        }
        return result;
    }

    public void drawPosition(Position position) {
        map[position.x][position.y]++;
    }

    public int evaluateMap(int threshold) {
        int amount = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int value = map[x][y];
                if (value >= threshold) {
                    amount++;
                }
            }
        }

        return amount;
    }

    public void emptyMap() {
        map = new int[width][height];
    }
}
