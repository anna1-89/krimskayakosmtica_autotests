package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {
    //Elements
    private final SelenideElement personalAccountTitle = $("[class*='co-checkout-title']");
    private final SelenideElement ordersMenuButton = $x("//a[contains(text(),'История заказов')]");
    private final SelenideElement exitMenuButton = $x("//a[contains(text(),'Выход')]");

    private final String personalAccountPageTitle = "История заказов";

    //Asserts
    @Step("Проверяем заголовок страницы авторизации")
    public PersonalAccountPage assertPersonalAccountPageTitle() {
        personalAccountTitle.shouldHave(text(personalAccountPageTitle));
        return this;
    }

    @Step("Проверяем, что доступна кнопка выхода из личного кабинета")
    public PersonalAccountPage assertPersonalAccountExistButtonIsAvailable() {
        exitMenuButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что доступна кнопка перехода к Истории заказов")
    public PersonalAccountPage assertPersonalAccountOrdersButtonIsAvailable() {
        ordersMenuButton.shouldBe(visible);;
        return this;
    }

}
