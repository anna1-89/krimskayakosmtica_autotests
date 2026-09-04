package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Работа с результатами поиска")
public class SearchPageResultsTests extends TestBase{
    String productInCatalog = "Медовое мыло \"Тонус\" с маточным молочком";

    @Test
    @DisplayName("Проверка добавления найденного товара в Корзину")
    void productShouldBeAddedToCart() {
        mainPage.openPage();
        headerComponent.enterSearchProduct(productInCatalog);
        headerComponent.clickSearchButton();
        searchPage.clickAddToCartButton(productInCatalog);
        searchPage.assertProductAddedToCart(productInCatalog);
    }

    @Test
    @DisplayName("Проверка добавления найденного товара в Избранное")
    void productShouldBeAddedToFavorites() {
        mainPage.openPage();
        headerComponent.enterSearchProduct(productInCatalog);
        headerComponent.clickSearchButton();
        searchPage.clickAddToFavoritesButton(productInCatalog);
        searchPage.assertProductAddedToFavorites(productInCatalog);
    }


}
