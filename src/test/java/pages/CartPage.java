package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    //Elements
    private final SelenideElement cartForm = $("[class*='widget-type_system_widget_v4_cart_1']");
    private final SelenideElement cartTitle = $(".heading");

    //Asserts
    @Step("Проверяем, что открыто окно Корзины")
    public CartPage checkCartPageIsOpened() {
        cartForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем заголовок окна Корзина")
    public CartPage checkCartPageTitle(String expectedPageTitle) {
        cartTitle.shouldHave(text(expectedPageTitle));
        return this;
    }

    @Step("Проверяем, что товар добавлен в Корзину: \"{value}\"")
    public CartPage checkCartItemExists(String value) {
        SelenideElement productInCart = $x("//a[contains(text(),value)]");
        productInCart.shouldBe(visible);
        return this;
    }
}
