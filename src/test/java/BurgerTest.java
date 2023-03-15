import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {

    Burger burger= new Burger();

    @Test
    public void setBunsTest() {
        Bun bun = new Bun("Космо булка", 50);
        burger.setBuns(bun);
        Assert.assertSame("Не получен объект булки", burger.bun, bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient sauceSpaceMix = new Ingredient (IngredientType.SAUCE, "Соус инопланетный микс" , 131);
        burger.addIngredient(sauceSpaceMix);
        Assert.assertTrue("Не добавлен ингридиент", burger.ingredients.contains(sauceSpaceMix));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Ingredient ingredientTwo = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("spaceMeat");
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0,1);
        assertEquals("Не добавлен ингридиент","spaceMeat", burger.ingredients.get(1).getName());
    }
    
    @Test
    public void removeIngredientTest() {
        Ingredient sauceSpaceMix = new Ingredient (IngredientType.SAUCE, "Соус инопланетный микс" , 131);
        burger.addIngredient(sauceSpaceMix);
        burger.removeIngredient(0);
        Assert.assertFalse("Не удален ингридиент", burger.ingredients.contains(sauceSpaceMix));
    }

    @Mock
    Bun bun = Mockito.mock(Bun.class);

    @Test
    public void getPriceBurgerWithBunTest() {
        Mockito.when(bun.getPrice()).thenReturn(150f);
        burger.setBuns(bun);
        float expectedPriceBun = 300;
        assertEquals("Не верно считается цена булочек в бургере", expectedPriceBun, burger.getPrice(), 0);
    }

    @Mock
    Ingredient ingredient = Mockito.mock(Ingredient.class);

    @Test
    public void getPriceBurgerWithOneIngridientTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPriceIngridient = 300;
        assertEquals("Не верно считается цена булки и ингридиента в бургере", expectedPriceIngridient, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBurgerWithTreeIngridientsTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedPriceIngridient = 500;
        assertEquals("Не верно считается цена булки и ингридиента в бургере", expectedPriceIngridient, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n",
                        burger.ingredients.get(0).getType().toString().toLowerCase(),
                        burger.ingredients.get(0).getName()) +
                String.format("(==== %s ====)%n", "black bun") +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();
        assertEquals(expectedReceipt, actual);
    }
}
