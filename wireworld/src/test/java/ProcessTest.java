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
}
