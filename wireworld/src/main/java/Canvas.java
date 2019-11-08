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
        super.paint(g);
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                if (tabl[x][y] == 0) {
                    g.setColor(Color.black);
                    g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                }
                if (tabl[x][y] == 1) {
                    Color c1 = new Color(255, 215, 0);
                    g.setColor(c1);
                    if (x == 0 || x == 49 || y == 0 || y == 49) {
                        Color c0 = new Color(92, 184, 92);
                        g.setColor(c0);
                    }
                    g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                }
                if (tabl[x][y] == 2) {
                    Color c1 = new Color(255, 64, 0);
                    g.setColor(c1);
                    g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                }
                if (tabl[x][y] == 3) {
                    Color c2 = new Color(0, 128, 255);
                    g.setColor(c2);
                    g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                }
            }
        }
    }
}
