package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Работа с результатами поиска")
public class SearchPageResultsTests extends TestBase{
    String productInCatalog = "Медовое мыло \"Тонус\" с маточным молочком";

    @Test
    @DisplayName("Проверка добавления найденного товара в Корзину")
    void productShouldBeAddedToCart() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Ввести запрос на поиск", () ->
                headerComponent.enterSearchProduct(productInCatalog));
        step("Нажать на поиск", () ->
                headerComponent.clickSearchButton());
        step("Нажать на добавление найденного товара в корзину", () ->
                searchPage.clickAddToCartButton(productInCatalog));
        step("Проверить добавление товара в корзину", () ->
                searchPage.assertProductAddedToCart(productInCatalog));
    }

    @Test
    @DisplayName("Проверка добавления найденного товара в Избранное")
    void productShouldBeAddedToFavorites() {
        step("Открыть страницу аптеки", () ->
                mainPage.openPage());
        step("Ввести запрос на поиск", () ->
                headerComponent.enterSearchProduct(productInCatalog));
        step("Нажать на поиск", () ->
                headerComponent.clickSearchButton());
        step("Нажать на добавление найденного товара в корзину", () ->
                searchPage.clickAddToFavoritesButton(productInCatalog));
        step("Проверить добавление товара в корзину", () ->
                searchPage.assertProductAddedToFavorites(productInCatalog));
    }


}
