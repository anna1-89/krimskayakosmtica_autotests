package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Story("Работа с поиском и результатами поиска")
public class ProductTests extends TestBase{
    String productInCatalog = "Медовое мыло \"Тонус\" с маточным молочком";
    String productNotInCatalog = "Золотой бальзам Гвоздика масло косметическое мягкое 4г";

    @Test
    @DisplayName("Проверка поиска при наличии товара в Каталоге")
    void productShouldBeFound() {
        step("Перейти на главную страницу и ввести запрос на поиск", () -> {
            mainPage.openPage();
            headerComponent.enterSearchProduct(productInCatalog);
            headerComponent.clickSearchButton();
        });
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

    @Test
    @DisplayName("Проверка открытия карточки найденного товара")
    void productCardShouldBeOpen() {
        step("Перейти на главную страницу, ввести запрос на поиск и выполнить действие добавления товара в Корзину", () -> {
            mainPage.openPage();
            headerComponent.enterSearchProduct(productInCatalog);
            headerComponent.clickSearchButton();
            searchPage.clickViewProduct(productInCatalog);
        });
        step("Проверить успешность перехода в карточку товара", () -> {
            productPage.assertProductPageIsOpened();
            productPage.assertProductItemIsCorrect(productInCatalog);
        });
    }

    @Test
    @DisplayName("Проверка добавления найденного товара в Корзину")
    void productShouldBeAddedToCart() {
        step("Перейти на главную страницу, ввести запрос на поиск и выполнить действие добавления товара в Корзину", () -> {
            mainPage.openPage();
            headerComponent.enterSearchProduct(productInCatalog);
            headerComponent.clickSearchButton();
            searchPage.clickAddToCartButton(productInCatalog);
        });
        step("Проверить успешность добавления товара в Корзину", () -> {
            searchPage.assertProductAddedToCartButtonIsChanged(productInCatalog);
            headerComponent.clickCartButton();
            cartPage.assertCartItemExists(productInCatalog);
        });
    }

    @Test
    @DisplayName("Проверка добавления найденного товара в Избранное")
    void productShouldBeAddedToFavorites() {
        step("Перейти на главную страницу, ввести запрос на поиск и выполнить действие добавления товара в Избранное", () -> {
            mainPage.openPage();
            headerComponent.enterSearchProduct(productInCatalog);
            headerComponent.clickSearchButton();
            searchPage.clickAddToFavoritesButton(productInCatalog);
        });
        step("Проверить успешность добавления товара в Избранное", () -> {
            searchPage.assertProductAddedToFavoritesButtonIsChanged(productInCatalog);
            headerComponent.clickFavoritesButton();
            favoritesPage.assertFavoritesItemExists(productInCatalog);
        });

    }


}
