package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CareerPage {

    private final SelenideElement header = $("h1.MuiTypography-h1"),
            vacanciesButton = $("main a[href='#jobs']"),
            internshipsButton = $("main a[href='#internships']");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public CareerPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что на странице отобраджается кнопка 'Смотреть вакансии'")
    public CareerPage checkVacanciesButton() {
        this.vacanciesButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что на странице отобраджается кнопка 'Стажировки'")
    public CareerPage checkInternshipsButton() {
        this.vacanciesButton.shouldBe(visible);
        return this;
    }
}
