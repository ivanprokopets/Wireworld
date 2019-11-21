import org.junit.Test;

import java.io.FileReader;

public class ReadFileTest {
    @Test
    public void read() throws Exception {
        FileReader fileReader = new FileReader("src/test/saveFileTest.txt");
        fileReader.close();
        System.out.println("The ReadFileTest was successful");
    }

}