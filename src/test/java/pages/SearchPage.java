package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPage {
    //Elements
    private final SelenideElement productNotFoundMessage = $(".empty-catalog-message");
    private final SelenideElement productItems = $(".catalog");

    private final String productNotFoundText = "По вашему запросу ничего не найдено";
    private final String buttonTextAddedToCart = "В корзине";
    private final String buttonTitleAddedToFavorites = "Добавлен в избранное";

    //Actions
    @Step("Нажимаем на найденный товар для перехода к его просмотру")
    public SearchPage clickViewProduct(String value) {
        productItems.scrollTo();
        SelenideElement productItem = $x("//a[contains(text(),'" + value + "')]");
        productItem.click();
        return this;
    }

    @Step("Нажимаем на кнопку добавления товара в Корзину")
    public SearchPage clickAddToCartButton(String value) {
        productItems.scrollTo();
        SelenideElement addToCartButton = $x("//a[contains(text(),'" + value + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'button add-cart-counter__btn')]");
        addToCartButton.click();
        Selenide.sleep(10000);
        return this;
    }

    @Step("Нажимаем на кнопку добавления товара в Избранное")
    public SearchPage clickAddToFavoritesButton(String value) {
        productItems.scrollTo();
        SelenideElement addToFavoritesButton = $x("//a[contains(text(),'" + value + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'favorites_trigger button is-icon favorites-not-added')]");
        addToFavoritesButton.click();
        Selenide.sleep(10000);
        return this;
    }

    //Asserts
    @Step("Проверяем, что товар успешно найден в Каталоге: \"{value}\"")
    public SearchPage assertSuccessSearchResult(String value) {
        SelenideElement searchResult = $x("//a[contains(text(),'" + value + "')]");
        searchResult.should(exist);
        return this;
    }

    @Step("Проверяем, что товар не должен быть найден в Каталоге")
    public SearchPage assertNotFoundSearchResult() {
        productNotFoundMessage.shouldHave(text(productNotFoundText));
        return this;
    }

    @Step("Проверяем, что поменялась кнопка добавления товара в Корзину")
    public SearchPage assertProductAddedToCartButtonIsChanged(String value) {
        SelenideElement addedToCartButton = $x("//a[contains(text(),'" + value + "')]/ancestor::div[contains(@class, 'product-preview__content')]//span[contains(@class, 'add-cart-counter__detail-text')]");
        addedToCartButton.shouldHave(text(buttonTextAddedToCart));
        return this;
    }

    @Step("Проверяем, что поменялась кнопка добавления товара в Избранное")
    public SearchPage assertProductAddedToFavoritesButtonIsChanged(String value) {
        SelenideElement addedToFavoritesButton = $x("//a[contains(text(),'" + value + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'favorites_trigger button is-icon favorites-added')]");
        String title = addedToFavoritesButton.getAttribute("title");
        assertEquals(buttonTitleAddedToFavorites, title);
        return this;
    }

}
