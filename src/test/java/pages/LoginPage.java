package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    //Elements
    private final SelenideElement loginTitle = $(".co-checkout-title.co-title.co-title--h1");

    private final String loginPageTitle = "Вход в кабинет покупателя";

    //Asserts
    @Step("Проверяем открытие страница авторизации")
    public LoginPage assertLoginPageIsOpened() {
        loginTitle.shouldHave(text(loginPageTitle));
        return this;
    }
}
