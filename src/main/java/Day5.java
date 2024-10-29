import utils.day5.Line;
import utils.day5.Map2D;
import utils.day5.MapInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        MapInput input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        input.map.emptyMap();

        // Part 2
        int result2 = evaluate2(input);
        System.out.printf("Result 2: %d%n", result2);
    }

    public static MapInput readInput() {
        List<Line> lines = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input5.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    String[] split = line.split(" -> ");
                    String[] splitStart = split[0].split(",");
                    String[] splitEnd = split[1].split(",");

                    int x1 = Integer.parseInt(splitStart[0]);
                    int y1 = Integer.parseInt(splitStart[1]);

                    int x2 = Integer.parseInt(splitEnd[0]);
                    int y2 = Integer.parseInt(splitEnd[1]);

                    lines.add(new Line(x1, y1, x2, y2));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        System.out.println(lines);
        return new MapInput(lines, new Map2D(1000, 1000));
    }

    public static int evaluate1(MapInput input) {
        for (Line line : input.lines) {
            input.map.drawStraightLine(line);
        }
        return input.map.evaluateMap(2);
    }

    public static int evaluate2(MapInput input) {
        for (Line line : input.lines) {
            input.map.drawLine(line);
        }
        return input.map.evaluateMap(2);
    }
}
