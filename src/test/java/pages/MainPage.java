package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ProductsComponent;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private final SelenideElement header = $("h1"),
            navBar = $(".header-desktop-wrapper"),
            productButton = $("header").$(byText("Продукты")),
            casesButton = $("header a[href='/cases']"),
            eventsButton = $("header").$(byText("Мероприятия")),
            aboutCompanyButton = $("header").$(byText("О компании")),
            resourcesButton = $("header").$(byText("Ресурсы")),
            educationButton = $("header").$(byText("Образование")),
            careerButton = $("header").$(byText("Карьера")),
            searchButton = $("button[aria-label='Открыть поиск']").parent(),
            testingButton = $("header").$(byText("Протестировать")),
            searchInput = $("input[placeholder='Поиск']"),
            shadowMenu = $(".group  div[data-radix-popper-content-wrapper]");

    private final ElementsCollection shadowMenuLinks = $$(".group  div[data-radix-popper-content-wrapper] a");

    private final ProductsComponent productsComponent = new ProductsComponent();

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        this.navBar.shouldBe(visible);
        this.header.shouldHave(text("СУБД для высоких нагрузок и эффективной работы бизнеса"));
        return this;
    }

    @Step("Нажать на кнопку 'Продукты' в меню")
    public MainPage clickProductButton() {
        this.productButton.shouldBe(visible).click();
        this.productsComponent.shouldBeVisible();
        return this;
    }

    @Step("Выбрать категорию с названием '{categoryName}'")
    public MainPage selectProductCategory(String categoryName) {
        this.productsComponent.clickSideMenuButtonWithName(categoryName);
        return this;
    }

    @Step("Выбрать категорию с названием '{categoryName}'")
    public <NextPage> NextPage selectProductCategory(String categoryName, Class<NextPage> pageClass) {
        return this.productsComponent.clickSideMenuButtonWithName(categoryName, pageClass);
    }

    @Step("Выбрать в категорию карточку продукта с текстом '{cardText}'")
    public <NextPage> NextPage selectProductCard(String cardText, Class<NextPage> pageClass) {
        return this.productsComponent.clickContentCardWithText(cardText, pageClass);
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

    @Step("Навести курсор на кнопку 'О компании' и в выпадающем меню выбрать '{linkText}'")
    public <NextPage> NextPage hoverAboutCompanyButtonAndSelectByText(String linkText, Class<NextPage> pageClass) {
        this.aboutCompanyButton.hover();
        this.shadowMenuLinks.shouldBe(sizeGreaterThan(0)).find(text(linkText)).shouldBe(visible).click();
        return page(pageClass);
    }

    @Step("Навести курсор на кнопку 'Ресурсы' и в выпадающем меню выбрать '{linkText}'")
    public <NextPage> NextPage hoverResourcesButtonAndSelectByText(String linkText, Class<NextPage> pageClass) {
        this.resourcesButton.hover();
        this.shadowMenuLinks.shouldBe(sizeGreaterThan(0)).find(text(linkText)).shouldBe(visible).click();
        return page(pageClass);
    }

    @Step("Навести курсор на кнопку 'Образование' и в выпадающем меню выбрать '{linkText}'")
    public <NextPage> NextPage hoverEducationButtonAndSelectByText(String linkText, Class<NextPage> pageClass) {
        this.educationButton.hover();
        this.shadowMenuLinks.shouldBe(sizeGreaterThan(0)).find(text(linkText)).shouldBe(visible).click();
        return page(pageClass);
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

}
