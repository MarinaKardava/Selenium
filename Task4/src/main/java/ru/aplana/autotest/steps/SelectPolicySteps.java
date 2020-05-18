package ru.aplana.autotest.steps;

import ru.aplana.autotest.pages.SelectPolicyPages;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SelectPolicySteps {
    @Step("Выбрать полис {0}")
    public void selectPolicy (String policyItem){
        new SelectPolicyPages().selectPolicy(policyItem);
    }

    @Step("В заголовке имеется текст {0}")
    public void pageTitle (String expectedTitle) {
        String actualTitle = new SelectPolicyPages().pageTitle.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
