import org.junit.Test;

public class ProcessOfLifeTest {
    @Test
    public void processOfLife() throws Exception {
        int[][] tabl;
        int widht = 0;
        int hegth = 0;
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                tabl = new int[x][y];
                tabl[x][y] = tabl[x][y];
                if ((tabl[x][y]) == 3) {
                    tabl[x][y] = 2;
                }
                if ((tabl[x][y]) == 2) {
                    tabl[x][y] = 1;
                }
            }
        }
    }
}