import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

// Top Level Window
public class DisplayBoards extends JFrame{

    final Background bgComp = new Background();

    DisplayBoards(){
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // What happens on close
        this.setResizable(false);

        // Display the window
        this.setSize(450, 450);
        this.setLocationRelativeTo(null); // Window appears in the centre of the screen
        this.setVisible(true); // Show the window

        this.getContentPane().setBackground(new Color(255, 255, 255));
    }

    public void createBackground(){
        bgComp.clearLines();

        Dimension windowSize = this.getSize();
        int xCoords, yCoords;
        bgComp.setPreferredSize(windowSize);
        this.getContentPane().add(bgComp, BorderLayout.CENTER);

        for(int i = 0; i < 8; i++){
            xCoords = (int) ((i+1)*windowSize.getWidth()/9);
            bgComp.addLine(xCoords, 0, xCoords, (int)windowSize.getHeight());
            yCoords = (int) ((i+1)*windowSize.getHeight()/9);
            bgComp.addLine(0, yCoords , (int)windowSize.getWidth(), yCoords);
        }

        this.pack();
        this.setVisible(true);
    }



    public static void main(String[] args){
        DisplayBoards window = new DisplayBoards();
        window.createBackground();








    }

}
