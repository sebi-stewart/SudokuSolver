import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

// Top Level Window
public class DisplayBoards extends JFrame{

    final Background bgComp = new Background();
    final Foreground fgComp = new Foreground();
    final Dimension windowSize;
    final int xRatio;
    final int yRatio;

    DisplayBoards(){
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // What happens on close
        this.setResizable(false);

        // Display the window
        this.setSize(450, 450);
        this.setLocationRelativeTo(null); // Window appears in the centre of the screen
        this.setVisible(true); // Show the window

        this.getContentPane().setBackground(new Color(255, 255, 255));

        windowSize = this.getSize();
        xRatio = (int)windowSize.getWidth()/9;
        yRatio = (int)windowSize.getHeight()/9;

    }

    public void createBackground(SudokuBoard sudoku){
        bgComp.clearLines();
        bgComp.clearNumbers();

        int xCoords, yCoords;
        bgComp.setPreferredSize(windowSize);
        this.getContentPane().add(bgComp, BorderLayout.CENTER);

        // Separating Lines
        for(int i = 0; i < 8; i++){
            xCoords = (i+1)*xRatio;
            bgComp.addLine(xCoords, 0, xCoords, (int)windowSize.getHeight());
            yCoords = (i+1)*yRatio;
            bgComp.addLine(0, yCoords , (int)windowSize.getWidth(), yCoords);
        }

        // Initial Numbers
        bgComp.setFont(bgComp.getFont().deriveFont((float) xRatio));
        int[][] initialBoard = sudoku.getInitialBoard();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (initialBoard[y][x] != 0){
                    bgComp.addNumber(
                            Integer.toString(initialBoard[y][x]),
                            x*xRatio + (int)(xRatio/4.5), (y+1)*yRatio - yRatio/9);
                }
            }
        }

        this.pack();
        this.setVisible(true);
    }

    public void createForeground(SudokuBoard sudoku){
        fgComp.clearNumbers();

        fgComp.setPreferredSize(windowSize);
        this.getContentPane().add(fgComp, BorderLayout.CENTER);

        // Fill with the new / currently being generated numbers
        fgComp.setFont(bgComp.getFont());
        int[][] initialBoard = sudoku.getInitialBoard();
        int[][] filledBoard = sudoku.getBoard();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (initialBoard[y][x] == 0 && filledBoard[y][x] != 0){
                    fgComp.addNumber(
                            Integer.toString(filledBoard[y][x]),
                            x*xRatio + (int)(xRatio/4.5), (y+1)*yRatio - yRatio/9);
                }
            }
        }
    }


    public static void main(String[] args){
        DisplayBoards window = new DisplayBoards();
        SudokuBoard sudokuBoard = new SudokuBoard();

        window.createBackground(sudokuBoard);
        window.createForeground(sudokuBoard);








    }

}
