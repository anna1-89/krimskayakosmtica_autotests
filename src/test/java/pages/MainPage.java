package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final String pageAddress = "/";

    //Actions
    @Step("Открываем главную страницу сайта")
    public MainPage openPage() {
        open(pageAddress);
        return this;
    }
}
