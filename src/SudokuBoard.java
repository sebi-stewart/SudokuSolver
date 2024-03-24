import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard {

    private final int[][] initialBoard;
    private int[][] board;
    private List<Integer> mutableCells = new ArrayList<>();

    public SudokuBoard() {
        this.initialBoard = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        this.board = this.initialBoard.clone();
        for(int y = 0; y < 9; y++){
            for (int x = 0; x < 9; x++) {
                if (this.initialBoard[y][x] == 0){
                    this.mutableCells.add(y*9+x);
                }
            }
        }
    }

    public int[][] getBlock(int blockX, int blockY){

        int[][] block ={{0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}};
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                block[y][x] = this.board[blockY*3+y][blockX*3+x];
            }
        }
        return block;
    }

    public int[] getColumn(int columnId){

        int[] column = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int y = 0; y<9; y++){
            column[y] = this.board[y][columnId];
        }
        return column;
    }

    public int[] getRow(int rowId){
        return this.board[rowId];
    }

    public int[][] getBoard(){
        return this.board;
    }

    public boolean checkComplete(){
        for (int y=0; y<9; y++) {
            for (int x = 0; x < 9; x++) {
                if (this.board[y][x] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> getMutableCells(){
        return this.mutableCells;
    }

    public int getCell(int x, int y){
        return this.board[y][x];
    }

    public void setCell(int x, int y, int val){
        this.board[y][x] = val;
    }



    @Override
    public String toString() {
        String boardString = "";
        for (int[] line : this.board)
            boardString = boardString.concat(Arrays.toString(line) + "\n");
        return boardString;
    }
}
