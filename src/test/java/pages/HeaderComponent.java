package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {
    //Elements
    private final SelenideElement loginButton = $("a[title='Личный кабинет']");
    private final SelenideElement favoritesButton = $("a[title='Избранное']");
    private final SelenideElement cartButton = $("a[title='Корзина']");
    private final SelenideElement catalogButton = $(".header__area-catalog");
    private final SelenideElement searchField = $("input[class='form-control form-control_size-l header__search-field']");
    private final SelenideElement searchButton = $("button[class='button button_size-l header__search-btn']");

    //Actions
    public HeaderComponent clickCatalogButton() {
        catalogButton.click();
        return this;
    }

    public HeaderComponent clickLoginButton() {
        loginButton.click();
        return this;
    }

    public HeaderComponent clickFavoritesButton() {
        favoritesButton.click();
        return this;
    }

    public HeaderComponent clickCartButton() {
        cartButton.click();
        return this;
    }

    public HeaderComponent enterSearchProduct(String data) {
        searchField.setValue(data);
        return this;
    }

    public HeaderComponent clickSearchButton() {
        searchButton.click();
        return this;
    }

}
