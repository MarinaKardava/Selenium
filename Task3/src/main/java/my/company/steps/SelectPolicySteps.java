package my.company.steps;

import my.company.pages.SelectPolicyPages;
import ru.yandex.qatools.allure.annotations.Step;

public class SelectPolicySteps {
    @Step("Выбрать полис {0}")
    public void selectPolicy (String policyItem){
        new SelectPolicyPages().selectPolicy(policyItem);
    }
}
