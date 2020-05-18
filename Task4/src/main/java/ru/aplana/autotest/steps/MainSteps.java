package ru.aplana.autotest.steps;


import ru.aplana.autotest.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class MainSteps {
    @Step ("Выбран пункт меню {0}")
    public void selectMainMenu (String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step ("Выбран вид страхования {0}")
    public void selectSubMenu (String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

}
