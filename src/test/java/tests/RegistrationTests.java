package tests;

import io.qameta.allure.Story;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.testData.userEmail;

@Story("Функционал регистрации нового пользователя")
public class RegistrationTests extends TestBase{

    String fakerUsername;
    String fakerPhoneNumber;
    String fakerUserEmail;
    String fakerUserPassword;
    String fakerUserInvalidPassword;
    String fakerUserConfirmationPassword;

    @BeforeEach
    public void prepareTestData(){
        Faker fakerRu = new Faker(new Locale("ru"));
        Faker fakerEn = new Faker(new Locale("en-US"));
        fakerUsername = fakerRu.name().nameWithMiddle();
        fakerPhoneNumber = String.valueOf(fakerRu.number().randomNumber(11));
        fakerUserEmail = fakerEn.internet().emailAddress();
        fakerUserPassword = fakerEn.name().femaleFirstName() + "1234";
        fakerUserInvalidPassword = String.valueOf(fakerRu.number().randomNumber(4));
        fakerUserConfirmationPassword = fakerEn.name().maleFirstName() + "1234";
    }

    @Test
    @DisplayName("Проверка успешного открытия страницы регистрации")
    void registrationPageShouldBeOpened() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
        });
        step("Нажать на кнопку перехода на страницу регистрации  \"Зарегистрироваться\"", () ->
            loginPage.clickRegistrationButton()
        );
        step("Проверить успешность открытия страницы регистрации", () -> {
            registrationPage.assertRegistrationPageTitle();
            registrationPage.assertRegistrationPageIsOpen();
        });
    }

    @Disabled
    @Test
    @DisplayName("Проверка успешной регистрации на сайте")
    void registrationShouldBeSuccessful() {
        step("Перейти на страницу регистрации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
            loginPage.clickRegistrationButton();
        });
        step("Ввести данные и нажать на кнопку \"Зарегистрироваться\"", () -> {
            registrationPage.enterUserFIOData(fakerUsername);
            registrationPage.enterUserPhoneNumber(fakerPhoneNumber);
            registrationPage.enterUserEmail(fakerUserEmail);
            registrationPage.enterUserPassword(fakerUserPassword);
            registrationPage.enterUserConfirmationPassword(fakerUserPassword);
            registrationPage.clickRegistrationButton();
        });
        step("Проверить успешность регистрации", () -> {
            personalAccountPage.assertPersonalAccountPageTitle();
            personalAccountPage.assertPersonalAccountExistButtonIsAvailable();
            personalAccountPage.assertPersonalAccountUserDataIsCorrect(fakerUsername, fakerPhoneNumber, fakerUserEmail);
        });
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации для случая уже зарегистрированного пользователя с таким email")
    void registrationShouldNotBeSuccessfulForExistingUser() {
        step("Перейти на страницу регистрации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
            loginPage.clickRegistrationButton();
        });
        step("Ввести данные и нажать на кнопку \"Зарегистрироваться\"", () -> {
            registrationPage.enterUserFIOData(fakerUsername);
            registrationPage.enterUserPhoneNumber(fakerPhoneNumber);
            registrationPage.enterUserEmail(userEmail);
            registrationPage.enterUserPassword(fakerUserPassword);
            registrationPage.enterUserConfirmationPassword(fakerUserPassword);
            registrationPage.clickRegistrationButton();
        });
        step("Проверить не успешность регистрации и отображение сообщения об ошибке", () -> {
            registrationPage.assertRegistrationPageIsOpen();
            registrationPage.assertUserAlreadyExistsRegistrationError();
        });
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации для случая не совпадения паролей")
    void registrationShouldNotBeSuccessfulForInvalidConfirmationPassword() {
        step("Перейти на страницу регистрации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
            loginPage.clickRegistrationButton();
        });
        step("Ввести данные и нажать на кнопку \"Зарегистрироваться\"", () -> {
            registrationPage.enterUserFIOData(fakerUsername);
            registrationPage.enterUserPhoneNumber(fakerPhoneNumber);
            registrationPage.enterUserEmail(fakerUserEmail);
            registrationPage.enterUserPassword(fakerUserPassword);
            registrationPage.enterUserConfirmationPassword(fakerUserConfirmationPassword);
            registrationPage.clickRegistrationButton();
        });
        step("Проверить не успешность регистрации и отображение сообщения об ошибке", () -> {
            registrationPage.assertRegistrationPageIsOpen();
            registrationPage.assertFailedConfirmationPasswordRegistrationError();
        });
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации для случая невалидного пароля - меньше 6 символов")
    void registrationShouldNotBeSuccessfulForInvalidPassword() {
        step("Перейти на страницу регистрации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
            loginPage.clickRegistrationButton();
        });
        step("Ввести данные и нажать на кнопку \"Зарегистрироваться\"", () -> {
            registrationPage.enterUserFIOData(fakerUsername);
            registrationPage.enterUserPhoneNumber(fakerPhoneNumber);
            registrationPage.enterUserEmail(fakerUserEmail);
            registrationPage.enterUserPassword(fakerUserInvalidPassword);
            registrationPage.enterUserConfirmationPassword(fakerUserInvalidPassword);
            registrationPage.clickRegistrationButton();
        });
        step("Проверить не успешность регистрации и отображение сообщения об ошибке", () -> {
            registrationPage.assertRegistrationPageIsOpen();
            registrationPage.assertInvalidPasswordRegistrationError();
        });
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации для случая попытки регистрации при незаполненных данных")
    void registrationShouldNotBeSuccessfulForEmptyInputs() {
        step("Перейти на страницу регистрации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
            loginPage.clickRegistrationButton();
        });
        step("Ввести данные и нажать на кнопку \"Зарегистрироваться\"", () -> {
            registrationPage.enterUserFIOData("");
            registrationPage.enterUserPhoneNumber("");
            registrationPage.enterUserEmail("");
            registrationPage.enterUserPassword(fakerUserPassword);
            registrationPage.enterUserConfirmationPassword(fakerUserPassword);
            registrationPage.clickRegistrationButton();
        });
        step("Проверить не успешность регистрации и отображение сообщения об ошибке", () -> {
            registrationPage.assertRegistrationPageIsOpen();
            registrationPage.assertEmptyInputsRegistrationError();
        });
    }


}
