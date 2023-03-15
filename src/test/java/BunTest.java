import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Булка мастера йоды", 4815);

    @Test
    public void getNameBunTest() {
        String actualNameBun = bun.getName();
        String expectedNameBun = "Булка мастера йоды";
        Assert.assertEquals("Не получено название булки", expectedNameBun, actualNameBun);
    }

    @Test
    public void getPriceBunTest() {
        float actualPriceBun = bun.getPrice();
        float expectedPriceBun = 4815;
        Assert.assertEquals("Не получена стоимость булки", expectedPriceBun, actualPriceBun, 0);
    }
}
