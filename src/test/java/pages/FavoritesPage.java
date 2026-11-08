package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FavoritesPage {
    //Elements
    private final SelenideElement favoritesForm = $("[class*='widget-type_page_favorite']");
    private final SelenideElement favoritesTitle = $(".page-headding");

    private final String favoritesPageTitle = "Избранное";

    //Asserts
    @Step("Проверяем заголовок окна Избранное")
    public FavoritesPage assertFavoritesPageTitle() {
        favoritesTitle.shouldHave(text(favoritesPageTitle));
        return this;
    }

    @Step("Проверяем, что открыто окно Избранное")
    public FavoritesPage assertFavoritesPageIsOpened() {
        favoritesForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что товар добавлен в Избранное: \"{value}\"")
    public FavoritesPage assertFavoritesItemExists(String value) {
        SelenideElement productInFavorites = $x("//a[contains(text(),value)]");
        productInFavorites.shouldBe(visible);
        return this;
    }

}
