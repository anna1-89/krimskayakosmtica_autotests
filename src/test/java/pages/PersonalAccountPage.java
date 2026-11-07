package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonalAccountPage {
    //Elements
    private final SelenideElement personalAccountTitle = $("[class*='co-checkout-title']");
    private final SelenideElement ordersMenuButton = $x("//a[contains(text(),'История заказов')]");
    private final SelenideElement userContactDataMenuButton = $x("//a[contains(text(),'Контактные данные')]");
    private final SelenideElement exitMenuButton = $x("//a[contains(text(),'Выход')]");
    private final SelenideElement personalAccountUserFIO = $("#client_name");
    private final SelenideElement personalAccountUserPhoneNumber = $("#client_phone");
    private final SelenideElement personalAccountUserEmail = $("#client_email");

    private final String personalAccountPageTitle = "История заказов";

    //Actions
    @Step("Нажимаем на кнопку перехода в Контактные данные пользователя")
    public PersonalAccountPage clickUserContactDataButton() {
        userContactDataMenuButton.click();
        return this;
    }

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
        ordersMenuButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что данные пользователя в Личном кабинете соответствуют зарегистрированным данным")
    public PersonalAccountPage assertPersonalAccountUserDataIsCorrect(String userName, String userPhoneNumber, String userEmail) {
        assertThat(personalAccountUserFIO.getValue()).isEqualTo(userName);
        assertThat(personalAccountUserPhoneNumber.getValue()).isEqualTo("+" + userPhoneNumber);
        assertThat(personalAccountUserEmail.getValue()).isEqualTo(userEmail);
        return this;
    }

}
