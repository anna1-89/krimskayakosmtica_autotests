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

    private final String registrationTitlePage = "Регистрация";
    private final String userAlreadyExistsErrorMessageText = "Пользователь с таким email уже зарегистрирован";
    private final String failedPasswordConfirmationErrorMessageText = "не совпадает с подтверждением";
    private final String invalidPasswordErrorMessageText = "Пароль должен быть не меньше 6 символов";
    private final String emptyInputErrorMessageText = "Поле не заполнено";

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
    public RegistrationPage assertRegistrationPageIsOpen() {
        registrationForm.shouldBe(visible);
        return this;
    }

    @Step("Проверяем заголовок страницы регистрации")
    public RegistrationPage assertRegistrationPageTitle() {
        registrationTitle.shouldHave(text(registrationTitlePage));
        return this;
    }

    @Step("Проверяем ошибку регистрации для уже зарегистрированного пользователя")
    public RegistrationPage assertUserAlreadyExistsRegistrationError() {
        errorGeneralMessage.shouldHave(text(userAlreadyExistsErrorMessageText));
        errorEmailMessage.shouldHave(text(userAlreadyExistsErrorMessageText));
        return this;
    }

    @Step("Проверяем ошибку регистрации при несовпадающих паролях")
    public RegistrationPage assertFailedConfirmationPasswordRegistrationError() {
        errorGeneralMessage.shouldHave(text(failedPasswordConfirmationErrorMessageText));
        errorPasswordMessage.shouldHave(text(failedPasswordConfirmationErrorMessageText));
        return this;
    }

    @Step("Проверяем ошибку регистрации при невалидном пароле")
    public RegistrationPage assertInvalidPasswordRegistrationError() {
        errorGeneralMessage.shouldHave(text(invalidPasswordErrorMessageText));
        errorPasswordMessage.shouldHave(text(invalidPasswordErrorMessageText));
        return this;
    }

    @Step("Проверяем ошибку регистрации при незаполненных данных ФИО, номер телефона и Email")
    public RegistrationPage assertEmptyInputsRegistrationError() {
        errorUserNameMessage.shouldHave(text(emptyInputErrorMessageText));
        errorEmailMessage.shouldHave(text(emptyInputErrorMessageText));
        errorPhoneNumberMessage.shouldHave(text(emptyInputErrorMessageText));
        return this;
    }

}
