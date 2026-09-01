package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Работоспособность кнопок головной компоненты")
public class HeaderComponentTests extends TestBase{
    String productInCatalog = "Медовое мыло \"Тонус\" с маточным молочком";
    String productNotInCatalog = "Золотой бальзам Гвоздика масло косметическое мягкое 4г";


    @Test
    @DisplayName("Проверка раскрытия каталога")
    void catalogPageShouldAppear() {
        step("Открыть главную страницу", () ->
                mainPage.openPage());
        step("Нажать на кнопку раскрытия каталога", () ->
                headerComponent.clickCatalogButton());
        step("Проверить раскрытие каталога", () ->
                catalogPage.assertCatalogIsOpened());
    }

    @Test
    @DisplayName("Проверка открытия окна для авторизации")
    void loginPageShouldAppear() {
        step("Открыть главную страницу", () ->
                mainPage.openPage());
        step("Нажать на кнопку авторизации", () ->
                headerComponent.clickLoginButton());
        step("Проверить появление окна авторизации", () ->
                loginPage.assertLoginPageIsOpened());
    }

    @Test
    @DisplayName("Проверка открытия окна корзины")
    void cartPageShouldAppear() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Нажать на кнопку корзины", () ->
                headerComponent.clickCartButton());
        step("Проверить появление окна корзины", () ->
                cartPage.assertCartPageIsOpened());
    }

    @Test
    @DisplayName("Проверка открытия окна избранное")
    void favoritesPageShouldAppear() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Нажать на кнопку избранного", () ->
                headerComponent.clickFavoritesButton());
        step("Проверить появление окна избранного", () ->
                favoritesPage.assertFavoritesPageIsOpened());
    }

    @Story("Работоспособность поисковой строки")

    @Test
    @DisplayName("Проверка поиска при наличии товара в Каталоге")
    void productShouldBeFound() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Ввести запрос на поиск", () ->
                headerComponent.enterSearchProduct(productInCatalog));
        step("Нажать на поиск", () ->
                headerComponent.clickSearchButton());
        step("Проверить результат поиска", () ->
                searchPage.assertSuccessSearchResult(productInCatalog));
    }

    @Test
    @DisplayName("Проверка поиска при отсутствии товара в Каталоге")
    void productNotShouldBeFound() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Ввести запрос на поиск", () ->
                headerComponent.enterSearchProduct(productNotInCatalog));
        step("Нажать на поиск", () ->
                headerComponent.clickSearchButton());
        step("Проверить результат поиска", () ->
                searchPage.assertNotFoundSearchResult());
    }
}
