import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("Hehe");
        ArrayList<Integer> input = readInput();
        System.out.println(input);
    }

    public static ArrayList<Integer> readInput() {
        ArrayList<Integer> result = new ArrayList<>();

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
}