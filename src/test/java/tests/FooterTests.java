package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BooksPage;
import pages.DocumentationPage;
import pages.MainPage;

import java.util.List;

@Epic("Сайт 'PostgresPro'")
@Feature("Главная страница")
public class FooterTests extends BaseTest {

    private final String booksPageHeader = "Книги",
            documentationPageHeader = "Документация";

    private final List<String> books = List.of("PostgreSQL. Профессиональный SQL", "PostgreSQL 17 изнутри",
            "Postgres: первое знакомство", "Путеводитель по базам данных", "Мониторинг PostgreSQL",
            "PostgreSQL. Основы языка SQL", "Основы технологий баз данных");

    private final List<String> sections = List.of("СУБД", "Масштабирование", "Управление и резервное копирование",
            "Миграция с Oracle");

    MainPage mainPage = new MainPage();

    @Test
    @Story("Проверка футера")
    @DisplayName("Проверка работы кнопки 'Книги'")
    public void checkBookButtonTest() {
        mainPage.openPage()
                .clickFooterBooksButton(BooksPage.class)
                .checkPageHeader(booksPageHeader)
                .checkBooksTitles(books);
    }

    @Test
    @Story("Проверка футера")
    @DisplayName("Проверка работы кнопки 'Документация'")
    public void checkDocumentationButtonTest() {
        mainPage.openPage()
                .clickFooterDocumentationButton(DocumentationPage.class)
                .checkPageHeader(documentationPageHeader)
                .checkPageSections(sections);
    }
}
