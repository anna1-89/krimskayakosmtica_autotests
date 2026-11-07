package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    //Elements
    private final SelenideElement loginForm = $("form[class*='co-modal-login_form']");
    private final SelenideElement loginTitle = $(".co-checkout-title.co-title.co-title--h1");
    private final SelenideElement loginInput = $("#email");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement enterButton = $("button[name=commit]");
    private final SelenideElement errorMessage = $("[class*='co-notice--danger']");
    private final SelenideElement registrationButton = $x("//a[contains(text(),'Зарегистрироваться')]");

    private final String loginPageTitle = "Вход в кабинет покупателя";
    private final String errorMessageText = "Сочетание логина и пароля не подходит";

    //Actions
    @Step("Вводим телефон или Email пользователя): \"{value}\"")
    public LoginPage enterUserEmailOrPhoneNumber(String value) {
        loginInput.setValue(value);
        return this;
    }

    @Step("Вводим пароль пользователя): \"{value}\"")
    public LoginPage enterUserPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку входа")
    public LoginPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку перехода к регистрации")
    public LoginPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    //Asserts
    @Step("Проверяем, что открыта форма авторизации")
    public LoginPage assertLoginPageIsOpened() {
        loginForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем заголовок страницы авторизации")
    public LoginPage assertLoginPageTitle() {
        loginTitle.shouldHave(text(loginPageTitle));
        return this;
    }

    @Step("Проверяем отображение ошибки авторизации")
    public LoginPage assertLoginErrorMessage() {
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(errorMessageText));
        return this;
    }
}
