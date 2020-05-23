package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.SectionPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SectionSteps {
   @Step("Выбран пункт меню {0}")
    public void setTabList(String sectionName) {
        new SectionPages().setTabList(sectionName);
    }
    @Step("Выбран раздел {0}")
    public void setNavigationTree(String sectionName) {
        new SectionPages().setNavigationTree(sectionName);
    }

}
