package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AboutCompanyPage {

    private final SelenideElement header = $(".h1-tray h1"),
            infoSection = $("section .container .static");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public AboutCompanyPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить отображение информации о компании")
    public AboutCompanyPage checkCompanyInfo(String companyInfo) {
        this.infoSection.shouldBe(visible).shouldHave(text(companyInfo));
        return this;
    }
}
