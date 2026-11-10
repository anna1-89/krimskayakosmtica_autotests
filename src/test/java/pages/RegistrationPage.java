package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //Elements
    private final SelenideElement registrationForm = $("form[id='new_client']");
    private final SelenideElement registrationTitle = $("[class*='co-checkout-title']");
    private final SelenideElement usernameInput = $("#client_name");
    private final SelenideElement userPhoneInput = $("#client_phone");
    private final SelenideElement userEmailInput = $("#client_email");
    private final SelenideElement userPasswordInput = $("#client_password");
    private final SelenideElement userPasswordConfirmationInput = $("#client_password_confirmation");
    private final SelenideElement registrationButton = $("button[class*='js-co-login-submit']");

    private final SelenideElement errorGeneralMessage =$("div[class='co-login']").$("[class*='co-notice--danger']") ;
    private final SelenideElement errorUserNameMessage =$("div[class*='co-input--name'][class*='co-input--error']").$("[class*='co-notice--danger']") ;
    private final SelenideElement errorEmailMessage =$("div[class*='co-input--email'][class*='co-input--error']").$("[class*='co-notice--danger']") ;
    private final SelenideElement errorPhoneNumberMessage =$("div[class*='co-input--tel']").$("[class*='co-notice--danger']") ;
    private final SelenideElement errorPasswordMessage =$("div[class*='co-input--password'][class*='co-input--error']").$("[class*='co-notice--danger']") ;

    //Actions
    @Step("Вводим контактное лицо (ФИО)): \"{value}\"")
    public RegistrationPage enterUserFIOData(String value) {
        usernameInput.setValue(value);
        return this;
    }

    @Step("Вводим контактный телефон пользователя): \"{value}\"")
    public RegistrationPage enterUserPhoneNumber(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    @Step("Вводим email пользователя): \"{value}\"")
    public RegistrationPage enterUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Вводим пароль пользователя): \"{value}\"")
    public RegistrationPage enterUserPassword(String value) {
        userPasswordInput.setValue(value);
        return this;
    }

    @Step("Вводим подтверждение пароля пользователя): \"{value}\"")
    public RegistrationPage enterUserConfirmationPassword(String value) {
        userPasswordConfirmationInput.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку регистрации")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    //Asserts
    @Step("Проверяем, что находимся форма регистрации")
    public RegistrationPage checkRegistrationPageIsOpen() {
        registrationForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем заголовок страницы регистрации")
    public RegistrationPage checkRegistrationPageTitle(String expectedPageTitle) {
        registrationTitle.shouldHave(text(expectedPageTitle));
        return this;
    }

    @Step("Проверяем отображение ошибки в общем блоке с ошибками")
    public RegistrationPage checkGeneralErrorMessage(String expectedErrorText) {
        errorGeneralMessage.shouldHave(text(expectedErrorText));
        return this;
    }

    @Step("Проверяем отображение ошибки для поля имени пользователя")
    public RegistrationPage checkUsernameErrorMessage(String expectedErrorText) {
        errorUserNameMessage.shouldHave(text(expectedErrorText));
        return this;
    }

    @Step("Проверяем отображение ошибки для поля Email")
    public RegistrationPage checkEmailErrorMessage(String expectedErrorText) {
        errorEmailMessage.shouldHave(text(expectedErrorText));
        return this;
    }

    @Step("Проверяем отображение ошибки для поля Email")
    public RegistrationPage checkPhoneNumberErrorMessage(String expectedErrorText) {
        errorPhoneNumberMessage.shouldHave(text(expectedErrorText));
        return this;
    }

    @Step("Проверяем отображение ошибки для пароля")
    public RegistrationPage checkPasswordConfirmationErrorMessage(String expectedErrorText) {
        errorPasswordMessage.shouldHave(text(expectedErrorText));
        return this;
    }

    @Step("Проверяем отображение ошибки для поля пароля")
    public RegistrationPage checkPasswordErrorMessage(String expectedErrorText) {
        errorPasswordMessage.shouldHave(text(expectedErrorText));
        return this;
    }


}
