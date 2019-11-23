import org.junit.Test;

public class NewLifeTest {
    @Test
    public void newLife() throws Exception {
        int[][] tabl;
        int widht = 0;
        int hegth = 0;
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                tabl = new int[x][y];
                tabl[x][y] = 0;
            }
        }
        System.out.println("The NewLifeTest was successful");
    }
}