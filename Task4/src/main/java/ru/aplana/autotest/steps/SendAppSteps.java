package ru.aplana.autotest.steps;

import ru.aplana.autotest.pages.SendAppPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SendAppSteps {
    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String fieldName, String value){
        new SendAppPages().fillField(fieldName,value);
    }

    @Step ("Поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
    String actual = new SendAppPages().getFillField(field);
    assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new SendAppPages().checkFieldErrorMessage(field, value);
    }
   /* @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }
    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }*/
    @Step("В заголовке имеется текст {0}")
    public void pageTitle (String expectedTitle) {
        String actualTitle = new SendAppPages().pageTitle.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
