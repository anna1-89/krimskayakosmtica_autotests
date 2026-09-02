package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
    @Step("Нажимаем на кнопку открытия каталога")
    public HeaderComponent clickCatalogButton() {
        catalogButton.click();
        return this;
    }

    @Step("Нажимаем на кеопку авторизации")
    public HeaderComponent clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку перехода в Избранное")
    public HeaderComponent clickFavoritesButton() {
        favoritesButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку перехода в Корзину")
    public HeaderComponent clickCartButton() {
        cartButton.click();
        return this;
    }

    @Step("Вводим поисковый запрос")
    public HeaderComponent enterSearchProduct(String data) {
        searchField.setValue(data);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public HeaderComponent clickSearchButton() {
        searchButton.click();
        return this;
    }

}
