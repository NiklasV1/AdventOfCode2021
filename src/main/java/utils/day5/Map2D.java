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
}
