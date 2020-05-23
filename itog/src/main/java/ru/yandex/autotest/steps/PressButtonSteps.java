package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.PressButtonPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class PressButtonSteps {
    @Step ("Нажать кнопку {0}")
    public void pressButtonOf(String nameButton) {
        new PressButtonPages().pressButtonOf(nameButton);

    }

}
