import javax.swing.JComponent;
import java.awt.*;
import java.util.LinkedList;

public class Background extends JComponent{

    private record Line(int x1, int y1, int x2, int y2, Color color) {
    }

    private final LinkedList<Line> lines = new LinkedList<>();

    public void addLine(int x1, int y1, int x2, int y2){
        addLine(x1, y1, x2, y2, Color.black);
    }
    public void addLine(int x1, int y1, int x2, int y2, Color color){
        lines.add(new Line(x1, y1, x2, y2, color));
        repaint();
    }

    public void clearLines(){
        lines.clear();
        repaint();
    }

    private record Number(String data, int x, int y, Color color) {
    }

    private final LinkedList<Background.Number> numbers = new LinkedList<>();

    public void addNumber(String data, int x, int y){
        addNumber(data, x, y, Color.black);
    }
    public void addNumber(String data, int x, int y, Color color){
        numbers.add(new Background.Number(data, x, y, color));
        repaint();
    }

    public void clearNumbers(){
        numbers.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Line line : lines){
            g.setColor(line.color);
            g.drawLine(
                    line.x1, line.y1,
                    line.x2, line.y2);
        }
        for (Background.Number number : numbers){
            g.setColor(number.color);
            g.drawString(
                    number.data,
                    number.x, number.y);
        }
    }

}
