package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AboutCompanyPage;
import pages.MainPage;
import pages.ProductPage;

@Epic("Сайт 'PostgresPro'")
@Feature("Главная страница")
public class BaseContentTests extends BaseTest {

    private final String aboutCompanyHeader = "О компании",
            aboutCompanyInfo = "Postgres Professional — российский разработчик системы управления базами данных Postgres Pro на основе PostgreSQL.",
            productHeader = "Postgres Pro Enterprise 17",
            consultationLink = "https://postgrespro.ru/products/postgrespro/enterprise#get-cons",
            licenseRulesLink = "https://postgrespro.ru/products/postgrespro/enterprise#license-rules";

    MainPage mainPage = new MainPage();

    @Test
    @Story("Проверка контента главной страницы")
    @DisplayName("Проверка работы кнопки 'О компании'")
    public void checkAboutCompanyButtonTest() {
        mainPage.openPage()
                .clickAboutCompanyButton()
                .checkPageHeader(aboutCompanyHeader)
                .checkCompanyInfo(aboutCompanyInfo);
    }

    @Test
    @Story("Проверка контента главной страницы")
    @DisplayName("Проверка работы кнопки 'Узнать о продукте'")
    public void checkProductsButtonTest() {
        mainPage.openPage()
                .clickProductButton()
                .checkPageHeader(productHeader)
                .checkConsultationButton(consultationLink)
                .checkLicenseRulesButton(licenseRulesLink);
    }
}
