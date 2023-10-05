package basketTest;

import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import static steps.BaseSteps.*;
import static validator.ValidationOfElements.validateTitle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartItemAdditionTest implements ConfigSetup {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Поиск товара по наменованию и добавление его в корзину")
    public void ScriptWb() {
        String keys = "iphone";
        enterProductNameToSearchLine(keys);

        int indexOfGood = 0;
        String titleOfProductInProductCard = goToFirstProductPage(indexOfGood);

        addProductToBasket();

        goToBasket();

        String titleOfProductInBasket = getFirstProductFromBasket();

        validateTitle(titleOfProductInProductCard, titleOfProductInBasket);
    }
}