package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FavoritesPage {
    //Elements
    private final SelenideElement favoritesTitle = $(".page-headding");

    private final String favoritesPageTitle = "Избранное";

    //Asserts
    @Step("Проверяем открытие окна Избранное")
    public FavoritesPage assertFavoritesPageIsOpened() {
        favoritesTitle.shouldHave(text(favoritesPageTitle));
        return this;
    }
}
