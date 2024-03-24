import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Foreground extends JComponent {

    private static class Number{
        final String data;
        final int x;
        final int y;
        final Color color;

        public Number(String data, int x, int y, Color color){
            this.data = data;
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private final LinkedList<Foreground.Number> numbers = new LinkedList<>();

    public void addNumber(String data, int x, int y){
        addNumber(data, x, y, Color.blue);
    }
    public void addNumber(String data, int x, int y, Color color){
        numbers.add(new Foreground.Number(data, x, y, color));
        repaint();
    }


    public void clearNumbers(){
        numbers.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Foreground.Number number : numbers){
            g.setColor(number.color);
            g.drawString(
                    number.data,
                    number.x, number.y);
        }
    }
}
