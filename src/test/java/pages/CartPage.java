package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    //Elements
    private final SelenideElement cartTitle = $(".heading");

    private final String cartPageTitle = "Корзина";

    //Asserts
    @Step("Проверяем открытие окна Корзины")
    public CartPage assertCartPageIsOpened() {
        cartTitle.shouldHave(text(cartPageTitle));
        return this;
    }
}
