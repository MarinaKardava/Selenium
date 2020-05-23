package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.TitlePages;
import ru.yandex.qatools.allure.annotations.Step;

public class TitleSteps {
    @Step("Заголовок страницы равен {0}")
    public void titleTabList (String expectedTitle) {
        new TitlePages().titleTabList(expectedTitle);
    }
    @Step("Заголовок страницы 2 равен {0}")
    public void titleNavigationTree (String expectedTitle) {
        new TitlePages().titleNavigationTree(expectedTitle);
    }
}
