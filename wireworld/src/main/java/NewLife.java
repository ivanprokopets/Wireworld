public class NewLife {
    private int[][] tabl;
    private int widht;
    private int hegth;
    private Canvas canvasPanel;

    public NewLife(int[][] tabl, int widht, int hegth, Canvas canvasPanel) {
        this.tabl = tabl;
        this.widht = widht;
        this.hegth = hegth;
        this.canvasPanel = canvasPanel;
    }

    public void newLife() {
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                tabl[x][y] = 0;
            }
        }
        canvasPanel.repaint();
    }
}
