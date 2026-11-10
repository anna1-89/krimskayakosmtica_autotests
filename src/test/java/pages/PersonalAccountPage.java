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

    //Actions
    @Step("Нажимаем на кнопку перехода в Контактные данные пользователя")
    public PersonalAccountPage clickUserContactDataButton() {
        userContactDataMenuButton.click();
        return this;
    }

    //Asserts
    @Step("Проверяем заголовок страницы авторизации")
    public PersonalAccountPage checkPersonalAccountPageTitle(String expectedPageTitle) {
        personalAccountTitle.shouldHave(text(expectedPageTitle));
        return this;
    }

    @Step("Проверяем, что доступна кнопка выхода из личного кабинета")
    public PersonalAccountPage checkPersonalAccountExistButtonIsAvailable() {
        exitMenuButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что доступна кнопка перехода к Истории заказов")
    public PersonalAccountPage checkPersonalAccountOrdersButtonIsAvailable() {
        ordersMenuButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что данные пользователя в Личном кабинете соответствуют зарегистрированным данным")
    public PersonalAccountPage checkPersonalAccountUserDataIsCorrect(String userName, String userPhoneNumber, String userEmail) {
        clickUserContactDataButton();
        String actualFIO = personalAccountUserFIO.getValue();
        String actualPhoneNumber = personalAccountUserPhoneNumber.getValue().replaceAll("[()-]", "");
        String actualEmail = personalAccountUserEmail.getValue();
        assertThat(actualFIO).isEqualTo(userName);
        assertThat(actualPhoneNumber).isEqualTo("+" + userPhoneNumber);
        assertThat(actualEmail).isEqualTo(userEmail);
        return this;
    }

}
