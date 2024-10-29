import utils.Command;
import utils.Direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {
    public static void main(String[] args) {
        List<String> input = readInput();
        int binLength = input.getFirst().length();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input, binLength);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
//        int result2 = evaluate2(input);
//        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<String> readInput() {
        List<String> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input3.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    result.add(line);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return result;
    }

    public static int evaluate1(List<String> input, int binLength) {
        int[] sum = new int[binLength];
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (String binary : input) {
            char[] binArray = binary.toCharArray();
            for (int i = 0; i < binArray.length; i++) {
                sum[i] += Integer.parseInt(String.valueOf(binArray[i]));
            }
        }

        for (int value : sum) {
            if (value * 2 > input.size()) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println(gamma);
        System.out.println(epsilon);

        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }
}
