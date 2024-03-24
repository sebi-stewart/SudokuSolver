
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DisplayBoards window = new DisplayBoards();
        SudokuBoard sudokuBoard = new SudokuBoard();
        Solvers solver = new Solvers(sudokuBoard);

        window.createBackground(sudokuBoard);

        solver.iterateCells(window);

        System.out.println(solver.sudokuBoard);
        window.createForeground(sudokuBoard);
    }
}