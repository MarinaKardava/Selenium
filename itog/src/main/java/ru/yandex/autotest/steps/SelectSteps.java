package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.SelectPages;
import ru.yandex.autotest.pages.SetFilterPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SelectSteps {
    @Step("Количество элементов на странице равно {0}")
    public void countElements(int count){new SelectPages().countElements(count);}
    @Step("Запомнить текст {0} элемента")
    public String getElementText(int i) {return new SelectPages().getElementText(i);}
    @Step ("Заполнить строку поиска значением элемента {0}")
    public void searchElement(int i) {new SelectPages().searchElement(i);}
    @Step("Проверить, что значение в строке поиска равно значению элемента {0}")
    public void getFillField(int i){
        String value = new SelectPages().getElementText(i);
        String actual = new SelectPages().getFillField();
        assertTrue(String.format("Значение поля равно [%s]. Ожидалось - [%s]", actual, value),
                actual.equals(value));
    }
}
