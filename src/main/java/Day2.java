import utils.day2.Command;
import utils.day2.Direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        List<Command> input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
        int result2 = evaluate2(input);
        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<Command> readInput() {
        List<Command> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input2.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    String[] splitLine = line.split(" ");

                    Direction direction = switch (splitLine[0]) {
                        case "forward" -> Direction.FORWARD;
                        case "up" -> Direction.UP;
                        default -> Direction.DOWN;
                    };

                    int amount = Integer.parseInt(splitLine[1]);
                    result.add(new Command(direction, amount));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return result;
    }

    public static int evaluate1(List<Command> input) {
        int position = 0;
        int depth = 0;

        for (Command command : input) {
            switch (command.direction) {
                case UP -> depth -= command.amount;
                case DOWN -> depth += command.amount;
                case FORWARD -> position += command.amount;
            }
        }

        return position * depth;
    }

    public static int evaluate2(List<Command> input) {
        int position = 0;
        int depth = 0;
        int aim = 0;

        for (Command command : input) {
            switch (command.direction) {
                case UP:
                    aim -= command.amount;
                    break;
                case DOWN:
                    aim += command.amount;
                    break;
                case FORWARD:
                    position += command.amount;
                    depth += command.amount * aim;
                    break;
            }
        }

        return position * depth;
    }
}
