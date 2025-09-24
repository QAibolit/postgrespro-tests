package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement header = $("h1"),
            navBar = $(".header-desktop-wrapper"),
            casesButton = $("header a[href='/cases']"),
            eventsButton = $("header").$(byText("Мероприятия")),
            careerButton = $("header").$(byText("Карьера")),
            searchButton = $("button[aria-label='Открыть поиск']").parent(),
            testingButton = $("header").$(byText("Протестировать")),
            searchInput = $("input[placeholder='Поиск']"),
            aboutCompanyButton = $("a[href='/about']"),
            aboutProductButton = $(byText("Узнать о продукте")).parent().parent();

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        this.navBar.shouldBe(visible);
        this.header.shouldHave(text("СУБД для высоких нагрузок и эффективной работы бизнеса"));
        return this;
    }

    @Step("Нажать на кнопку 'Кейсы' в меню")
    public CasesPage clickCasesButton() {
        this.casesButton.shouldBe(visible).click();
        return new CasesPage();
    }

    @Step("Нажать на кнопку 'Мероприятия' в меню")
    public EventsPage clickEventsButton() {
        this.eventsButton.shouldBe(visible).click();
        return new EventsPage();
    }

    @Step("Нажать на кнопку 'Карьера' в меню")
    public CareerPage clickCareerButton() {
        this.careerButton.click();
        Selenide.switchTo().window(1);
        return new CareerPage();
    }

    @Step("Найти текст '{searchText}' через кнопку 'Поиск' в меню")
    public SearchResultsPage searchInfoByText(String searchText) {
        this.searchButton.click();
        this.searchInput.shouldBe(visible).setValue(searchText).pressEnter();
        return new SearchResultsPage();
    }

    @Step("Нажать на кнопку 'Протестировать' в меню")
    public TestingPage clickTestingButton() {
        this.testingButton.click();
        return new TestingPage();
    }

    @Step("Нажать на кнопку 'Узнать о продукте'")
    public ProductPage clickProductButton() {
        this.aboutProductButton.shouldBe(visible).scrollTo().click();
        return new ProductPage();
    }

    @Step("Нажать на кнопку 'О компании'")
    public AboutCompanyPage clickAboutCompanyButton() {
        this.aboutCompanyButton.shouldBe(visible).scrollTo().click();
        return new AboutCompanyPage();
    }

}
