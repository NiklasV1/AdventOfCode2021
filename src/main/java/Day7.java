import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
        List<Integer> input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
//        long result2 = evaluate2(input, 256);
//        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<Integer> readInput() {
        List<Integer> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input7.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    String[] split = line.split(",");
                    for (String value : split) {
                        result.add(Integer.parseInt(value));
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return result;
    }

    public static int evaluate1(List<Integer> input) {
        Collections.sort(input);
        if (input.size() % 2 == 0) {
            return Math.min(calculateFuelCost(input,input.get(input.size()/2)), calculateFuelCost(input,input.get(input.size()/2)));
        } else {
            return calculateFuelCost(input,input.get(input.size()/2));
        }
    }

    public static int calculateFuelCost(List<Integer> input, int median) {
        int cost = 0;
        for (Integer value : input) {
            cost += Math.abs(value - median);
        }
        return cost;
    }
}
