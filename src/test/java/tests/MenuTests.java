package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.testData.*;

@Story("Функционал головного меню")
public class MenuTests extends TestBase{

    @Test
    @DisplayName("Проверка раскрытия каталога")
    void catalogPageShouldBeOpened() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickCatalogButton();
        });
        catalogPage.checkCatalogIsOpened();
    }

    @Test
    @DisplayName("Проверка открытия окна авторизации")
    void loginPageShouldBeOpened() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
        });
        step("Проверить, что осуществлен переход на страницу авторизации", () -> {
            loginPage.checkLoginPageIsOpened();
            loginPage.checkLoginPageTitle(loginPageTitle);
        });
    }

    @Test
    @DisplayName("Проверка открытия окна корзины")
    void cartPageShouldBeOpened() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу корзины", () -> {
            mainPage.openPage();
            headerComponent.clickCartButton();
        });
        step("Проверить, что осуществлен переход на страницу корзины", () -> {
            cartPage.checkCartPageIsOpened();
            cartPage.checkCartPageTitle(cartPageTitle);
        });
    }

    @Test
    @DisplayName("Проверка открытия окна избранное")
    void favoritesPageShouldBeOpened() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу избранного", () -> {
            mainPage.openPage();
            headerComponent.clickFavoritesButton();
        });
        step("Проверить, что осуществлен переход на страницу избранного", () -> {
            favoritesPage.checkFavoritesPageIsOpened();
            favoritesPage.checkFavoritesPageTitle(favoritesPageTitle);
        });
    }

}
