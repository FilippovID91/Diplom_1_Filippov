import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус космический кокос" , 99);

    @Test
    public void getNameIngredientTest() {
        String actualNameIngredient = ingredient.getName();
        String expectedNameIngredient = "Соус космический кокос";
        Assert.assertEquals("Не получено имя ингридиента", expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void getPriceIngredientTest() {
        float actualPriceIngredient = ingredient.getPrice();
        float expectedPriceIngredient = 99;
        Assert.assertEquals("Не получена стоимость ингридиента", expectedPriceIngredient, actualPriceIngredient, 0);
    }
}
