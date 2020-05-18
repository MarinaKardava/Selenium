package ru.aplana.autotest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;

public class ScenarioSteps {
    MainSteps mainPageSteps = new MainSteps();
    PressButtonSteps pressButtonSteps = new PressButtonSteps();
    SelectPolicySteps selectPolicySteps = new SelectPolicySteps();
    SendAppSteps sendAppSteps = new SendAppSteps();
    HashMap<String, String> testData = new HashMap<>();
    HashMap<String, String> forSex = new HashMap<>();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem (String menuName){
        mainPageSteps.selectMainMenu(menuName);
    }
    @When("^выбран вид страхования \"(.+)\"$")
    public void selectSubMenuItem (String subMenuName){
        mainPageSteps.selectSubMenu(subMenuName);
    }
    @Then("^заголовок страницы - страхования равен \"(.+)\"$")
    public void checkTitleDMSPage(String title){
        pressButtonSteps.pageTitle(title);
    }

    @When("выполнено нажатие кнопки \"(.+)\"$")
    public void pressButtonOfOn (String buttonName){
        pressButtonSteps.pressButtonOf(buttonName);
    }
    @Then("^В заголовке страницы имеется текст \"(.+)\"$")
    public void checkTitlePolicy(String title){
        selectPolicySteps.pageTitle(title);
    }
    @When("Выбран вид полиса - \"(.+)\"$")
    public void selectPolicy (String viewPolicy){
        selectPolicySteps.selectPolicy(viewPolicy);
    }
    @When("Нажата кнопка \"(.+)\"$")
    public void pressButtonOf (String buttonName){
        pressButtonSteps.pressButtonOf(buttonName);
    }
    @Then("^В заголовке имеется текст \"(.+)\"$")
    public void chekTitleAppPage(String title){
        sendAppSteps.pageTitle(title);
    }
    @When ("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.fillField(field, value));
    }
    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.checkFillField(field, value));
    }

    @When ("Выполнено нажатие кнопки \"(.+)\"$")
    public void pressButtonContin (String buttonName){
        pressButtonSteps.pressButtonOf(buttonName);
    }
    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void errorMessage (String field, String value){
        sendAppSteps.checkErrorMessageField(field,value);
    }


}
