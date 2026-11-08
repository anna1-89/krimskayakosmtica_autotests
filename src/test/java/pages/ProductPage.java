package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage {

    //Elements
    private final SelenideElement productForm = $("form[class*='product']");
    private final SelenideElement productTitle = $(".product__title");

    //Asserts
    @Step("Проверяем, что открыта карточка товара")
    public ProductPage assertProductPageIsOpened() {
        productForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что открыта карточка выбранного товара")
    public ProductPage assertProductItemIsCorrect(String value) {
        String actualProduct = productTitle.text();
        assertThat(actualProduct).isEqualTo(value);
        return this;
    }

}
