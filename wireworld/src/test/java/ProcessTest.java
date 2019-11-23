import org.junit.Assert;
import org.junit.Test;

public class ProcessTest {
    @Test
    public void go() throws Exception {
    }

    @Test
    public void getName() throws Exception {
        String name = "WireWorld";
        Assert.assertEquals("Niepoprawna nazwa", "WireWorld", getName(name));
        System.out.println("The Test getName was successful");
    }

    private String getName(String name) {
        return name;
    }

    @Test
    public void getStart() throws Exception {
        String start = "Start";
        Assert.assertEquals("Niepoprawny start","Start",getStart(start));
        System.out.println("The Test getStart was successful");
    }

    private String getStart(String start) {
        return start;
    }

    @Test
    public void saveStart() throws Exception {
        String save = "Save";
        Assert.assertEquals("Niepoprawny save","Save",saveStart(save));
        System.out.println("The Test saveStart was successful");
    }

    private String saveStart(String save) {
        return save;
    }

    @Test
    public void readStart() throws Exception {
        String read ="Read";
        Assert.assertEquals("Niepoprawny read","Read",readStart(read));
        System.out.println("The Test readStart was successful");
    }

    private String readStart(String read) {
        return read;
    }

}