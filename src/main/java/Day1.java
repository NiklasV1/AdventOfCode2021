import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        List<Integer> input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
        int result2 = evaluate2(input);
        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<Integer> readInput() {
        List<Integer> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input1.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    result.add(Integer.parseInt(line));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return result;
    }

    public static int evaluate1(List<Integer> input) {
        int result = 0;
        int previousDepth = input.getFirst();

        for (Integer value : input) {
            if (value > previousDepth) {
                result++;
            }
            previousDepth = value;
        }

        return result;
    }

    public static int evaluate2(List<Integer> input) {
        int result = 0;
        int previousDepth = input.get(0) + input.get(1) + input.get(2);

        for (int i = 3; i < input.size(); i++) {
            int newDepth = input.get(i) + input.get(i - 1) + input.get(i - 2);
            if (newDepth > previousDepth) {
                result++;
            }
            previousDepth = newDepth;
        }

        return result;
    }
}