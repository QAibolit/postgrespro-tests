package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final SelenideElement header = $("h1"),
            searchInput = $("input#qid");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public SearchResultsPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что поле поиска содержит значение '{searchText}'")
    public SearchResultsPage checkSearchInputValue(String searchText) {
        this.searchInput.shouldBe(visible).shouldHave(value(searchText));
        return this;
    }

}
