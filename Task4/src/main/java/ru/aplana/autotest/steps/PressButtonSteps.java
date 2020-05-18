package ru.aplana.autotest.steps;

import ru.aplana.autotest.pages.PressButtonPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class PressButtonSteps {
    @Step ("Нажать кнопку {0}")
    public void pressButtonOf(String nameButton) {
        new PressButtonPages().pressButtonOf(nameButton);
    }

    @Step ("Заголовок страницы равен {0}")
    public void pageTitle (String expectedTitle){
        String actualTitle = new PressButtonPages().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
