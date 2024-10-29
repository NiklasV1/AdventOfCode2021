package utils.day5;

public class Line {
    public Position start;
    public Position end;

    public Line(int x1, int y1, int x2, int y2) {


        start = new Position(x1, y1);
        end = new Position(x2, y2);
    }

    public boolean isHorizontal() {
        return start.x == end.x;
    }

    public boolean isVertical() {
        return start.y == end.y;
    }

    public boolean isStraight() {
        return isHorizontal() || isVertical();
    }

    @Override
    public String toString() {
        return "Line: " + start.x + "," + start.y + "-" + end.x + "," + end.y;
    }
}
