import utils.day6.Fish;
import utils.day6.FishTank;
import utils.day6.FishTank2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        List<Integer> input = readInput();
        System.out.println(input);

        // Part 1
        int result1 = evaluate1(input, 80);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
        long result2 = evaluate2(input, 256);
        System.out.printf("Result 2: %d%n", result2);
    }

    public static List<Integer> readInput() {
        List<Integer> result = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input6.txt");
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

    public static int evaluate1(List<Integer> input, int days) {
        // Simulation Solution

        // Create Simulation
        List<Fish> fishes = new ArrayList<>();
        for (Integer value : input) {
            Fish fish = new Fish();
            fish.setTimer(value);
            fishes.add(fish);
        }
        FishTank tank = new FishTank(fishes);

        // Run Simulation
        for (int i = 0; i < days; i++) {
            tank.simulationStep();
        }
        return tank.countFish();
    }

    public static long evaluate2(List<Integer> input, int days) {
        // Efficient Mathematical Solution
        FishTank2 tank = new FishTank2(input);
        return tank.evaluate(days);
    }
}
