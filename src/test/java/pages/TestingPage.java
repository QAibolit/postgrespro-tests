package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestingPage {

    private final SelenideElement header = $("h2"),
            requestButton = $("#btnStepOne");

    private final ElementsCollection dbVariants = $$("#stepOne label");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public TestingPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что кнопка 'Запросить ПО на тестирование' отображается на странице и неактивна")
    public TestingPage checkRequestButton() {
        this.requestButton.shouldBe(visible).shouldBe(disabled);
        return this;
    }

    @Step("Проверить, что представленные для тестирования продукты соответствуют переданному списку")
    public TestingPage checkDbVariants(List<String> variants) {
        this.dbVariants.shouldHave(texts(variants));
        return this;
    }
}
