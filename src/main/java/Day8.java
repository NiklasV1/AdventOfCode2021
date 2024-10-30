import utils.day8.CableInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) {
        List<CableInput> input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
//        int result2 = evaluate2(input);
//        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<CableInput> readInput() {
        List<CableInput> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input8.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    String[] split = line.split(" \\| ");
                    String[] sigPatterns = split[0].split(" ");
                    String[] outValues = split[1].split(" ");

                    List<String> signalPatterns = new ArrayList<>(Arrays.asList(sigPatterns));
                    List<String> outputValues = new ArrayList<>(Arrays.asList(outValues));

                    result.add(new CableInput(signalPatterns, outputValues));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return result;
    }

    public static int evaluate1(List<CableInput> input) {
        int sum = 0;
        for (CableInput cable : input) {
            for (String output : cable.outputValues) {
                switch (output.length()) {
                    case 2, 3, 4, 7 -> sum++;
                }
            }
        }
        return sum;
    }

}
