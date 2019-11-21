
import org.junit.Test;
import java.io.FileWriter;

public class SaveFileTest {
    @Test
    public void save() throws Exception {
        FileWriter writer = new FileWriter("src/test/saveFileTest.txt");
        int widht = 0;
        int hegth = 0;
        int[][] tabl;
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                tabl = new int[x][y];
                if ((tabl[x][y]) == 3) {
                    String text = "ElectronHead: " + x + ", " + y + ";";
                    writer.write(text);
                    writer.append('\n');
                    writer.flush();
                }
                writer.close();
            }
        }
        System.out.println("The SaveFileTest was successful");
    }
}