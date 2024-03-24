import java.util.ArrayList;
import java.util.List;

public class Solvers {


    SudokuBoard sudokuBoard; // Initial Board
    ArrayList<Integer> contains;


    public Solvers(SudokuBoard sudoku){
        sudokuBoard = sudoku;
    }

    public void iterateCells(){
        List<Integer> mutableCells = sudokuBoard.getMutableCells();
        int x, y, val;
        for(int i = 0; i < mutableCells.size(); i++){
            x = mutableCells.get(i)%9;
            y = mutableCells.get(i)/9;
            val = sudokuBoard.getCell(x, y);

            if (val + 1 <= 9){
                sudokuBoard.setCell(x, y,val+1);
            } else{
                i -= 2;
                sudokuBoard.setCell(x, y, 0);
                continue;
            }
            if (!checkCell(x, y)){
                i--;
            }
        }
    }


    public boolean checkCell(int x, int y){
        return checkColumn(x) && checkRow(y) && checkBlock(x, y);
    }


    private boolean checkColumn(int columnId){
        contains = new ArrayList<>();
        int[] column = sudokuBoard.getColumn(columnId);

        return checkColRow(column);
    }

    private boolean checkRow(int rowId){
        contains = new ArrayList<>();
        int[] row = sudokuBoard.getRow(rowId);

        return checkColRow(row);
    }

    private boolean checkColRow(int[] colRow){
        for(int i: colRow){
            if (i == 0){
                continue;
            }
            if (!contains.contains(i)){
                contains.add(i);
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean checkBlock(int columnId, int rowId){
        contains = new ArrayList<>();
        int[][] block = sudokuBoard.getBlock(columnId/3, rowId/3);

        for(int[] row: block){
            for(int cell: row){
                if (cell == 0){
                    continue;
                }
                if (!contains.contains(cell)){
                    contains.add(cell);
                    continue;
                }
                return false;
            }
        }
        return true;
    }

}
