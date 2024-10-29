package utils.day6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FishTank2 {
    long[] fishStates;

    public FishTank2(List<Integer> input) {
        fishStates = new long[9];
        for (int i = 0; i < fishStates.length; i++) {
            fishStates[i] = Collections.frequency(input, i);
        }
        System.out.println(Arrays.toString(fishStates));
    }

    public long evaluate(int days) {
        for (int i = 0; i < days; i++) {
            long[] newStates = new long[9];

            // Progress States
            for (int j = 0; j < fishStates.length; j++) {
                newStates[j] = fishStates[(j + 1) % 9];
            }

            // Reset Adults
            newStates[6] += fishStates[0];

            // Update Current State
            fishStates = newStates;
        }

        long sum = 0;
        for (long number : fishStates) {
            sum += number;
        }
        return sum;
    }
}
