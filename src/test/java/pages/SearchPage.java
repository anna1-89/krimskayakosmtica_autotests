package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPage {
    //Elements
    private final SelenideElement productNotFoundMessage = $(".empty-catalog-message");

    private final String productNotFoundText = "По вашему запросу ничего не найдено";
    private final String buttonTextAddedToCart = "В корзине";
    private final String buttonTitleAddedToFavorites = "Добавлен в избранное";

    //Actions
    public SearchPage clickAddToCartButton(String data) {
        SelenideElement addToCartButton = $x("//a[contains(text(),'" + data + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'button add-cart-counter__btn')]");
        addToCartButton.click();
        return this;
    }

    public SearchPage clickAddToFavoritesButton(String data) {
        SelenideElement addToFavoritesButton = $x("//a[contains(text(),'" + data + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'favorites_trigger button is-icon favorites-not-added')]");
        addToFavoritesButton.click();
        return this;
    }

    //Asserts
    public SearchPage assertSuccessSearchResult(String data) {
        SelenideElement searchResult = $x("//a[contains(text(),'" + data + "')]");
        searchResult.should(exist);
        return this;
    }

    public SearchPage assertNotFoundSearchResult() {
        productNotFoundMessage.shouldHave(text(productNotFoundText));
        return this;
    }

    public SearchPage assertProductAddedToCart(String data) {
        SelenideElement addedToCartButton = $x("//a[contains(text(),'" + data + "')]/ancestor::div[contains(@class, 'product-preview__content')]//span[contains(@class, 'add-cart-counter__detail-text')]");
        addedToCartButton.shouldHave(text(buttonTextAddedToCart));
        return this;
    }

    public SearchPage assertProductAddedToFavorites(String data) {
        SelenideElement addedToFavoritesButton = $x("//a[contains(text(),'" + data + "')]/ancestor::div[contains(@class, 'product-preview__content')]//button[contains(@class, 'favorites_trigger button is-icon favorites-added')]");
        String title = addedToFavoritesButton.getAttribute("title");
        assertEquals(buttonTitleAddedToFavorites, title);
        return this;
    }

}
