package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DocumentationPage {

    private final SelenideElement header = $(".h1-tray h1");

    private final ElementsCollection sectionHeaders = $$("h3");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public DocumentationPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что страница содержит переданные разделы")
    public DocumentationPage checkPageSections(List<String> subTitles) {
        this.sectionHeaders.shouldHave(texts(subTitles));
        return this;
    }
}
