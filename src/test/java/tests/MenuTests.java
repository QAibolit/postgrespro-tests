package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AboutCompanyPage;
import pages.BooksPage;
import pages.DocumentationPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.List;

@Epic("Сайт 'PostgresPro'")
@Feature("Главная страница")
public class MenuTests extends BaseTest {

    private final String categoryName = "Документация",
            buttonName = "СУБД",
            card = "Postgres Pro Enterprise",
            productHeader = "Postgres Pro Enterprise 17",
            consultationLink = "https://postgrespro.ru/products/postgrespro/enterprise#get-cons",
            licenseRulesLink = "https://postgrespro.ru/products/postgrespro/enterprise#license-rules",
            casesHeader = "Кейсы",
            eventsHeader = "PGConf.\nСПб 2025",
            confInfo = "PGConf.СПб 2025 — крупнейшая конференция по PostgreSQL в России, которая проходит в Санкт-Петербурге.",
            aboutCompany = "О нас",
            aboutCompanyHeader = "О компании",
            aboutCompanyInfo = "Postgres Professional — российский разработчик системы управления базами данных Postgres Pro на основе PostgreSQL.",
            educationResource = "Книги",
            careerHeader = "POSTGRES PROFESSIONAL",
            searchText = "Avito",
            testingHeader = "Закажите тестирование СУБД Postgres Pro";

    private final List<String> variants = List.of("СУБД", "Масштабирование", "Управление и резервное копирование",
            "Миграция с Oracle");

    private final List<String> sectors = List.of("Все отрасли", "Госсектор", "Банки", "Нефть и газ", "Финансы",
            "Энергетика и атомная промышленность", "Сельское хозяйство", "Рыбная промышленность", "E-commerce",
            "Транспорт и машиностроение");

    private final List<String> books = List.of("PostgreSQL. Профессиональный SQL", "PostgreSQL 17 изнутри",
            "Postgres: первое знакомство", "Путеводитель по базам данных", "Мониторинг PostgreSQL",
            "PostgreSQL. Основы языка SQL", "Основы технологий баз данных");

    private final List<String> testProducts = List.of("Postgres Pro Certified", "Postgres Pro Enterprise",
            "Postgres Pro Enterprise Certified", "Postgres Pro Standard", "Postgres Pro Shardman");

    MainPage mainPage = new MainPage();

    @Test
    @Disabled
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Продукты'")
    public void checkProductsButtonTest() {
        mainPage.openPage()
                .clickProductButton()
                .selectProductCategory(categoryName, DocumentationPage.class)
                .checkPageHeader(categoryName)
                .checkPageSections(variants);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Продукты' с выбором карточки продукта")
    public void checkProductsButtonWithProductCardSelectionTest() {
        mainPage.openPage()
                .clickProductButton()
                .selectProductCategory(buttonName)
                .selectProductCard(card, ProductPage.class)
                .checkPageHeader(productHeader)
                .checkConsultationButton(consultationLink)
                .checkLicenseRulesButton(licenseRulesLink);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Кейсы'")
    public void checkCasesButtonTest() {
        mainPage.openPage()
                .clickCasesButton()
                .checkPageHeader(casesHeader)
                .checkSearchInput()
                .checkSectors(sectors);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Мероприятия'")
    public void checkEventsButtonTest() {
        mainPage.openPage()
                .clickEventsButton()
                .checkPageHeader(eventsHeader)
                .checkRegistrationButton()
                .checkСonfInfo(confInfo);
    }

    @Test
    @Disabled
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'О компании'")
    public void checkAboutCompanyButtonTest() {
        mainPage.openPage()
                .hoverAboutCompanyButtonAndSelectByText(aboutCompany, AboutCompanyPage.class)
                .checkPageHeader(aboutCompanyHeader)
                .checkCompanyInfo(aboutCompanyInfo);
    }

    @Test
    @Disabled
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Ресурсы'")
    public void checkResourcesButtonTest() {
        mainPage.openPage()
                .hoverResourcesButtonAndSelectByText(categoryName, DocumentationPage.class)
                .checkPageHeader(categoryName)
                .checkPageSections(variants);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Образование'")
    public void checkEducationButtonTest() {
        mainPage.openPage()
                .hoverEducationButtonAndSelectByText(educationResource, BooksPage.class)
                .checkPageHeader(educationResource)
                .checkBooksTitles(books);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Меню. Проверка работы кнопки 'Карьера'")
    public void checkCareerButtonTest() {
        mainPage.openPage()
                .clickCareerButton()
                .checkPageHeader(careerHeader)
                .checkVacanciesButton()
                .checkInternshipsButton();
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Поиск'")
    public void checkSearchButtonTest() {
        mainPage.openPage()
                .searchInfoByText(searchText)
                .checkPageHeader(searchText)
                .checkSearchInputValue(searchText);
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Протестировать'")
    public void checkTestingButtonTest() {
        mainPage.openPage()
                .clickTestingButton()
                .checkPageHeader(testingHeader)
                .checkDbVariants(testProducts)
                .checkRequestButton();
    }
}
