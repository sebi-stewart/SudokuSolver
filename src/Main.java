import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();

        Solvers solver = new Solvers(sudokuBoard);

        solver.iterateCells();
        System.out.println(solver.sudokuBoard);
    }
}