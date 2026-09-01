package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    //Elements
    private final SelenideElement catalogModal = $(".header__collections.is-show");

    //Asserts
    @Step("Проверяем открытие окна с каталогом")
    public CatalogPage assertCatalogIsOpened() {
        catalogModal.shouldBe(visible);
        return this;
    }
}
