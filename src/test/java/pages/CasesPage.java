package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CasesPage {

    private final SelenideElement header = $(".h1-tray h1"),
            searchInput = $("form input[name='search']");

    private final ElementsCollection cases = $$(".sub-menu-wrapper a");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public CasesPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что отображается поле поиска")
    public CasesPage checkSearchInput() {
        this.searchInput.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что названия отраслей соответствуют переданному списку")
    public CasesPage checkSectors(List<String> sectors) {
        this.cases.shouldHave(texts(sectors));
        return this;
    }
}
