package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Story("Функционал головного меню")
public class HeaderComponentTests extends TestBase{
    String productInCatalog = "Медовое мыло \"Тонус\" с маточным молочком";
    String productNotInCatalog = "Золотой бальзам Гвоздика масло косметическое мягкое 4г";


    @Test
    @DisplayName("Проверка раскрытия каталога")
    void catalogPageShouldAppear() {
        mainPage.openPage();
        headerComponent.clickCatalogButton();
        catalogPage.assertCatalogIsOpened();
    }

    @Test
    @DisplayName("Проверка открытия окна для авторизации")
    void loginPageShouldAppear() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
        });
        step("Проверить, что осуществлен переход на страницу авторизации", () -> {
            loginPage.assertLoginPageIsOpened();
            loginPage.assertLoginPageTitle();
        });
    }

    @Test
    @DisplayName("Проверка открытия окна корзины")
    void cartPageShouldAppear() {
        mainPage.openPage();
        headerComponent.clickCartButton();
        cartPage.assertCartPageIsOpened();
    }

    @Test
    @DisplayName("Проверка открытия окна избранное")
    void favoritesPageShouldAppear() {
        mainPage.openPage();
        headerComponent.clickFavoritesButton();
        favoritesPage.assertFavoritesPageIsOpened();
    }

    @Story("Работоспособность поисковой строки")

    @Test
    @DisplayName("Проверка поиска при наличии товара в Каталоге")
    void productShouldBeFound() {
        mainPage.openPage();
        headerComponent.enterSearchProduct(productInCatalog);
        headerComponent.clickSearchButton();
        searchPage.assertSuccessSearchResult(productInCatalog);
    }

    @Test
    @DisplayName("Проверка поиска при отсутствии товара в Каталоге")
    void productNotShouldBeFound() {
        mainPage.openPage();
        headerComponent.enterSearchProduct(productNotInCatalog);
        headerComponent.clickSearchButton();
        searchPage.assertNotFoundSearchResult();
    }
}
