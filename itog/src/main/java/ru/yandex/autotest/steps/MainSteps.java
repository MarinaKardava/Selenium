package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.MainPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class MainSteps {
    @Step("Выбран пункт меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPages().selectMenu(menuItem);
    }
}
