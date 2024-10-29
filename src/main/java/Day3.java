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
        int result2 = evaluate2(input);
        System.out.printf("Result 2: %d%n", result2);
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

        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }

    public static int evaluate2(List<String> input) {
        return getOxygenRating(input, 0) * getCo2Rating(input, 0);
    }

    public static int getOxygenRating(List<String> input, int significantBit) {
        if (input.size() == 1) {
            return Integer.parseInt(input.getFirst(), 2);
        } else {
            // Filter
            List<String> newList = new ArrayList<>();
            int counter = 0;
            char significantChar;

            for (String binary : input) {
                if (binary.charAt(significantBit) == '1') {
                    counter++;
                }
            }

            if (counter * 2 >= input.size()) {
                significantChar = '1';
            } else {
                significantChar = '0';
            }

            for (String binary : input) {
                if (binary.charAt(significantBit) == significantChar) {
                    newList.add(binary);
                }
            }

            significantBit++;

            // Recursion
            return getOxygenRating(newList, significantBit);
        }
    }

    public static int getCo2Rating(List<String> input, int significantBit) {
        if (input.size() == 1) {
            return Integer.parseInt(input.getFirst(), 2);
        } else {
            // Filter
            List<String> newList = new ArrayList<>();
            int counter = 0;
            char significantChar;

            for (String binary : input) {
                if (binary.charAt(significantBit) == '1') {
                    counter++;
                }
            }

            if (counter * 2 >= input.size()) {
                significantChar = '0';
            } else {
                significantChar = '1';
            }

            for (String binary : input) {
                if (binary.charAt(significantBit) == significantChar) {
                    newList.add(binary);
                }
            }

            significantBit++;

            // Recursion
            return getCo2Rating(newList, significantBit);
        }
    }

}
