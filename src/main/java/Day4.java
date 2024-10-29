import utils.day4.BingoBoard;
import utils.day4.BingoInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        BingoInput input = readInput();
        System.out.println(input.boards);

        // Part 1
        int result1 = evaluate1(input);
        System.out.printf("Result 1: %d%n", result1);

        // Part 2
//        int result2 = evaluate2(input);
//        System.out.printf("Result 2: %d%n", result2);
    }

    public static BingoInput readInput() {
        List<BingoBoard> boards = new ArrayList<>();
        List<Integer> instructions = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try {
            File input = new File("./src/main/resources/Input4.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }
            reader.close();

            // Read Instructions
            String[] split = lines.getFirst().split(",");
            for (String num : split) {
                instructions.add(Integer.parseInt(num));
            }

            // Read Bingo Boards
            List<List<String>> boardList = splitList(lines.subList(2, lines.size()));
            int size = boardList.getFirst().size();
            for (List<String> strings : boardList) {
                int[][] board = new int[size][size];

                for (int x = 0; x < size; x++) {
                    String[] row = strings.get(x).trim().replaceAll(" +", " ").split(" ");

                    for (int y = 0; y < size; y++) {
                        board[x][y] = Integer.parseInt(row[y]);
                    }
                }

                boards.add(new BingoBoard(board, size));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return new BingoInput(boards, instructions);
    }

    public static List<List<String>> splitList(List<String> input) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 5; i <= input.size(); i += 6) {
            result.add(input.subList(i - 5, i));
        }

        return result;
    }

    public static int evaluate1(BingoInput input) {
        for (int val : input.instructions) {
            for (BingoBoard board : input.boards) {
                board.markValue(val);
                if (board.checkWin()) {
                    return board.calculateScore();
                }
            }
        }
        return 0;
    }
}
