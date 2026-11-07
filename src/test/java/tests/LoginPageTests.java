package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.testData.*;

@Story("Функционал авторизации")
public class LoginPageTests extends TestBase{

    @Test
    @DisplayName("Проверка успешной авторизации на сайте")
    void loginShouldBeSuccessful() {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
        });
        step("Ввести данные и нажать на кнопку \"Войти\"", () -> {
            loginPage.enterUserEmailOrPhoneNumber(userEmail);
            loginPage.enterUserPassword(userPassword);
            loginPage.clickEnterButton();
        });
        step("Проверить успешность авторизации", () -> {
            personalAccountPage.assertPersonalAccountPageTitle();
            personalAccountPage.assertPersonalAccountOrdersButtonIsAvailable();
            personalAccountPage.assertPersonalAccountExistButtonIsAvailable();
        });
    }

    @CsvFileSource(resources = "/test_data/loginShouldNotBeSuccessful.csv")
    @ParameterizedTest
    @DisplayName("Проверка не успешной авторизации на сайте при невалидных входных данных для {0} {1} {2}")
    void loginShouldNotBeSuccessfulForUnregisteredLoginData(String userEmailOrPhoneNumberFromFile, String userPasswordFromFile) {
        step("Перейти на главную страницу и нажать на кнопку перехода на страницу авторизации", () -> {
            mainPage.openPage();
            headerComponent.clickLoginButton();
        });
        step("Ввести данные и нажать на кнопку \"Войти\"", () -> {
            loginPage.enterUserEmailOrPhoneNumber(userEmailOrPhoneNumberFromFile);
            loginPage.enterUserPassword(userPasswordFromFile);
            loginPage.clickEnterButton();
        });
        step("Проверить не успешность авторизации и отображение сообщения об ошибке", () -> {
            loginPage.assertLoginErrorMessage();
        });
    }

}
