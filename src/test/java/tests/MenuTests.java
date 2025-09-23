package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.List;

@Epic("Сайт 'PostgresPro'")
@Feature("Главная страница")
public class MenuTests extends BaseTest {

    private final String casesHeader = "Кейсы",
            eventsHeader = "PGConf.\nСПб 2025",
            confInfo = "PGConf.СПб 2025 — крупнейшая конференция по PostgreSQL в России, которая проходит в Санкт-Петербурге.",
            careerHeader = "POSTGRES PROFESSIONAL",
            searchText = "Avito",
            testingHeader = "Закажите тестирование СУБД Postgres Pro";

    private final List<String> sectors = List.of("Все отрасли", "Госсектор", "Банки", "Нефть и газ", "Финансы",
            "Энергетика и атомная промышленность", "Сельское хозяйство", "Рыбная промышленность", "E-commerce",
            "Транспорт и машиностроение");

    private final List<String> testProducts = List.of("Postgres Pro Certified", "Postgres Pro Enterprise",
            "Postgres Pro Enterprise Certified", "Postgres Pro Standard", "Postgres Pro Shardman");

    MainPage mainPage = new MainPage();

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
                .checkConfInfo(confInfo);
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
