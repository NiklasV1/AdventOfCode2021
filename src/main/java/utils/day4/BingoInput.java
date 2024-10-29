package utils.day4;

import java.util.List;

public class BingoInput {
    public List<BingoBoard> boards;
    public List<Integer> instructions;

    public BingoInput(List<BingoBoard> boards, List<Integer> instructions) {
        this.boards = boards;
        this.instructions = instructions;
    }
}
