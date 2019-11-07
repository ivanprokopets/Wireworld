import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private int[][] tabl;
    private int widht;
    private int hegth;
    private Canvas canvasPanel;
    private int POINT_RADIUS;


    public Canvas(int[][] tabl, int widht, int hegth, Canvas canvasPanel, int POINT_RADIUS) {
        this.widht = widht;
        this.hegth = hegth;
        this.tabl = tabl;
        this.canvasPanel = canvasPanel;
        this.POINT_RADIUS = POINT_RADIUS;
    }

    @Override
    public void paint(Graphics g) {

    }
}
