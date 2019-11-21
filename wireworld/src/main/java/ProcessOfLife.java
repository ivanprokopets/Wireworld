
public class ProcessOfLife {
    private int[][] tabl;
    private int[][] tabl2;
    private int widht;
    private int hegth;
    private Canvas canvasPanel;

    public ProcessOfLife(int[][] tabl, int[][] tabl2, int widht, int hegth, Canvas canvasPanel) {
        this.widht = widht;
        this.hegth = hegth;
        this.tabl = tabl;
        this.tabl2 = tabl2;
        this.canvasPanel = canvasPanel;
    }

    public void processOfLife() {
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                tabl2[x][y] = tabl[x][y];
                if ((tabl[x][y]) == 3) {
                    tabl2[x][y] = 2;
                }
                if ((tabl[x][y]) == 2) {
                    tabl2[x][y] = 1;
                }
                if ((tabl[x][y]) == 1 && x != 0 && x != 49 && y != 0 && y != 49) {
                    int countNeighbourgs = 0;
                    if ((tabl[x - 1][y - 1]) == 3) countNeighbourgs++;
                    if ((tabl[x - 1][y]) == 3) countNeighbourgs++;
                    if ((tabl[x - 1][y + 1]) == 3) countNeighbourgs++;
                    if ((tabl[x][y + 1]) == 3) countNeighbourgs++;
                    if ((tabl[x + 1][y + 1]) == 3) countNeighbourgs++;
                    if ((tabl[x + 1][y]) == 3) countNeighbourgs++;
                    if ((tabl[x + 1][y - 1]) == 3) countNeighbourgs++;
                    if ((tabl[x][y - 1]) == 3) countNeighbourgs++;
                    if (countNeighbourgs == 1 || countNeighbourgs == 2) {
                        tabl2[x][y] = 3;
                    }
                }
            }
        }
        for (int x = 0; x < widht; x++) {
            System.arraycopy(tabl2[x], 0, tabl[x], 0, widht);
        }
        canvasPanel.repaint();
    }
}
