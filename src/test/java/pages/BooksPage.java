package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {

    private final SelenideElement header = $(".h1-tray h1");

    private final ElementsCollection books = $$(".content h3");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public BooksPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что на странице отображаются все переданные книги")
    public BooksPage checkBooksTitles(List<String> books) {
        this.books.shouldHave(texts(books));
        return this;
    }
}
