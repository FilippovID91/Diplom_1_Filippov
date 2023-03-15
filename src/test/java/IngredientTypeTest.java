import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeСontainsFillingTest() {
        Assert.assertNotNull("Начинки не указаны в ингредиентах", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void IngredientTypeСontainsSauceTest() {
        Assert.assertNotNull("Соусы не указаны в ингредиентах", IngredientType.valueOf("SAUCE"));
    }
}
