package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EventsPage {

    private final SelenideElement header = $("a h1"),
            registrationButton = $(".hero__content a[href='/account/participation/pgconfspb2025']"),
            confInfo = $(".hero__description");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public EventsPage checkPageHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что кнопка регистрации отображается на странице")
    public EventsPage checkRegistrationButton() {
        this.registrationButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что информация о мероприятии содержит переданный текст")
    public EventsPage checkСonfInfo(String confInfo) {
        this.confInfo.shouldBe(visible).shouldHave(text(confInfo));
        return this;
    }
}
