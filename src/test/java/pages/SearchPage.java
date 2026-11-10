package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static data.testData.*;

public class SearchPage {
    //Elements
    private final SelenideElement productNotFoundMessage = $(".empty-catalog-message");
    private final SelenideElement productCatalog = $(".catalog");

    //Actions
    @Step("Нажимаем на найденный товар для перехода к его просмотру")
    public SearchPage clickViewProduct(String value) {
        productCatalog.scrollTo();
        SelenideElement productItem = $x("//a[contains(text(),'" + value + "')]");
        productItem.click();
        return this;
    }

    @Step("Нажимаем на кнопку добавления товара в Корзину")
    public SearchPage clickAddToCartButton(String value) {
        productCatalog.scrollTo();
        SelenideElement addToCartButton = $$(".product-preview__content").findBy(text(value)).$("[class*='add-cart-counter__btn']");

    addToCartButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку добавления товара в Избранное")
    public SearchPage clickAddToFavoritesButton(String value) {
        productCatalog.scrollTo();
        SelenideElement addToFavoritesButton = $$(".product-preview__content").findBy(text(value)).$("[class*='favorites-not-added']");
        addToFavoritesButton.click();
        return this;
    }

    //Asserts
    @Step("Проверяем, что товар успешно найден в Каталоге: \"{value}\"")
    public SearchPage checkSuccessSearchResult(String value) {
        SelenideElement searchResult = $x("//a[contains(text(),'" + value + "')]");
        searchResult.should(exist);
        return this;
    }

    @Step("Проверяем, что товар не должен быть найден в Каталоге")
    public SearchPage checkNotFoundSearchResult() {
        productNotFoundMessage.shouldHave(text(productNotFoundText));
        return this;
    }

    @Step("Проверяем, что поменялась кнопка добавления товара в Корзину")
    public SearchPage checkProductAddedToCartButtonIsChanged(String value) {
        SelenideElement addedToCartButton = $$(".product-preview__content").findBy(text(value)).$("[class*='add-cart-counter__detail-text']");
        addedToCartButton.shouldHave(text(buttonTextAddedToCart));
        return this;
    }

    @Step("Проверяем, что поменялась кнопка добавления товара в Избранное")
    public SearchPage checkProductAddedToFavoritesButtonIsChanged(String value) {
        SelenideElement addedToFavoritesButton = $$(".product-preview__content").findBy(text(value)).$("[class*='favorites-added']");
        addedToFavoritesButton.shouldHave(attribute("title", buttonTitleAddedToFavorites));
        return this;
    }

}
