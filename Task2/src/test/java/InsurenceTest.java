import org.junit.*;
import static org.junit.Assert.*;
import pages.MainPage;
import pages.SelectPolicy;
import pages.PressButton;
import pages.SendAppPage;


public class InsurenceTest extends BaseTest {

    @Test
    public void testInsurence() throws Exception {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Страхование путешественников");
        PressButton pressButton = new PressButton(driver);
        pressButton.pressButtonOfOn();
        new SelectPolicy(driver).selectPolicy("Минимальная");
        pressButton.pressButtonOf();
        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Surname", "Ivanov");
        sendAppPage.fillField("Name", "Ivan");
        sendAppPage.fillField("birthDate", "16.10.1996");
        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Дата Рождения", "16.10.1996");
        sendAppPage.fillField("Пол", "Мужской");
        sendAppPage.fillField("Серия Паспорта", "1111");
        sendAppPage.fillField("Номер Паспорта", "111111");
        sendAppPage.fillField("Дата Выдачи", "25.10.2016");
        sendAppPage.fillField("Кем выдано", "поврдлрплв");

        assertEquals("Ivanov",sendAppPage.getFillField("Surname"));
        assertEquals("Ivan",sendAppPage.getFillField("Name"));
        assertEquals("16.10.1996",sendAppPage.getFillField("birthDate"));
        assertEquals("Иванов",sendAppPage.getFillField("Фамилия"));
        assertEquals("Иван",sendAppPage.getFillField("Имя"));
        assertEquals("Иванович",sendAppPage.getFillField("Отчество"));
        assertEquals("16.10.1996",sendAppPage.getFillField("Дата Рождения"));
        assertEquals("1111",sendAppPage.getFillField("Серия Паспорта"));
        assertEquals("111111",sendAppPage.getFillField("Номер Паспорта"));
        assertEquals("25.10.2016",sendAppPage.getFillField("Дата Выдачи"));
        assertEquals("поврдлрплв",sendAppPage.getFillField("Кем выдано"));

        pressButton.pressButtonContin();

        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", sendAppPage.checkFieldErrorMessage("email"), "Поле не заполнено"),
                sendAppPage.checkFieldErrorMessage("email").contains("Поле не заполнено"));
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", sendAppPage.checkFieldErrorMessage("email"), "Поле не заполнено"),
                sendAppPage.checkFieldErrorMessage("email").contains("Поле не заполнено"));
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", sendAppPage.checkFieldErrorMessage("repeatEmail"), "Поле не заполнено"),
                sendAppPage.checkFieldErrorMessage("repeatEmail").contains("Поле не заполнено"));

    }

}
