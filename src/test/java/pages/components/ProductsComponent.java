package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class ProductsComponent {

    private final SelenideElement root = $("[class*='Header_headerProductMenu']");

    private final ElementsCollection sideMenuButtons = $$("[class*='Header_headerProductMenu'] li"),
            contentCards = $$("[class*='Header_headerProductMenu'] .contents a");

    public void shouldBeVisible() {
        this.root.shouldBe(visible);
    }

    public void clickSideMenuButtonWithName(String buttonName) {
        this.sideMenuButtons.find(text(buttonName)).click();
    }

    public <NextPage> NextPage clickSideMenuButtonWithName(String buttonName, Class<NextPage> pageClass) {
        this.sideMenuButtons.find(text(buttonName)).click();
        return page(pageClass);
    }

    public <NextPage> NextPage clickContentCardWithText(String cardText, Class<NextPage> pageClass) {
        this.contentCards.find(text(cardText)).click();
        return page(pageClass);
    }
}
