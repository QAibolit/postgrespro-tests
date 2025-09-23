package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final SelenideElement header = $("section h1"),
            consultationButton = $(byText("Получить консультацию")),
            licenseRulesButton = $(byText("Лицензионная политика"));

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public ProductPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что кнопка 'Получить консультацию' содержит ссылку '{consultationLink}'")
    public ProductPage checkConsultationButton(String consultationLink) {
        this.consultationButton.shouldBe(visible).shouldHave(attribute("href", consultationLink));
        return this;
    }

    @Step("Проверить, что кнопка 'Лицензионная политика' содержит ссылку '{consultationLink}'")
    public ProductPage checkLicenseRulesButton(String licenseRulesLink) {
        this.licenseRulesButton.shouldBe(visible).shouldHave(attribute("href", licenseRulesLink));
        return this;
    }

}
