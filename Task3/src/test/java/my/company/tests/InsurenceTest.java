package my.company.tests;

import my.company.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;


public class InsurenceTest extends BaseSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    PressButtonSteps pressButtonSteps = new PressButtonSteps();
    SelectPolicySteps selectPolicySteps = new SelectPolicySteps();
    SendAppSteps sendAppSteps = new SendAppSteps();
    HashMap<String, String> testData = new HashMap<>();
    HashMap<String, String> forSex = new HashMap<>();
    @Title("Страхование путешественников")
    @Test
    public void testInsurence() throws Exception {

        testData.put("Surname", "Ivanov");
        testData.put("Name", "Ivan");
        testData.put("birthDate", "16.10.1996");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата Рождения", "16.10.1996");
        forSex.put("Пол", "Мужской");
        testData.put("Серия Паспорта", "1111");
        testData.put("Номер Паспорта", "111111");
        testData.put("Дата Выдачи", "25.10.2016");
        testData.put("Кем выдано", "поврдлрплв");

        mainPageSteps.selectMainMenu("Страхование");
        mainPageSteps.selectSubMenu("Страхование путешественников");
        pressButtonSteps.pressButtonOf("Оформить онлайн");
        selectPolicySteps.selectPolicy("Минимальная");
        pressButtonSteps.pressButtonOf("Оформить");
        sendAppSteps.fillFields(testData);
        sendAppSteps.fillFields(forSex);



        sendAppSteps.checkFillFields(testData);

        pressButtonSteps.pressButtonOf("Продолжить");


        sendAppSteps.checkErrorMessageField("phone", "Поле не заполнено");
        sendAppSteps.checkErrorMessageField("email", "Поле не заполнено");
        sendAppSteps.checkErrorMessageField("repeatEmail", "Поле не заполнено");

    }

}
