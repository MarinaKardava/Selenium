package ru.yandex.autotest.steps;

import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class ScenarioSteps {
    MainSteps selectMenu = new MainSteps();
    SectionSteps setTabList = new SectionSteps();
    SetFilterSteps setFilter = new SetFilterSteps();
    PressButtonSteps pressButtonSteps = new PressButtonSteps();
    TitleSteps pageTitle = new TitleSteps();
    SelectSteps selectItem = new SelectSteps();

    @Когда("^выбран пункт меню \"(.+)\"$")
    public void setSelectMenu (String menuName){
        selectMenu.selectMenuItem(menuName);
    }

    @Когда("^выбран раздел \"(.+)\"$")
    public void selectTabList(String tabListName){
        setTabList.setTabList(tabListName);
    }
    @Когда("^выбран раздел 2\"(.+)\"$")
    public void setNavigationTree(String tabListName){setTabList.setNavigationTree(tabListName);}
    @Тогда("^заголовок страницы имеет текст \"(.+)\"$")
    public void titleTabList(String pageTit){
        pageTitle.titleTabList(pageTit);
    }
    @Тогда("^заголовок страницы 2 имеет текст \"(.+)\"$")
    public void titleNavigationTree(String pageTit){
        pageTitle.titleNavigationTree(pageTit);
    }
    @Когда("^Нажата кнопка \"(.+)\"$")
    public void pressButtonOf (String buttonName){
        pressButtonSteps.pressButtonOf(buttonName);
    }
    @Когда ("^заполнено поле\"(.+)\" значением \"(.+)\"$")
    public void selectSum(String filtrSum, String value){
        setFilter.selectSum(filtrSum,value);
    }
    @Когда ("^Выбран производитель \"(.+)\"$")
    public void setProducer(String nameProducer){
        setFilter.setProducer(nameProducer);
    }
    @Тогда ("^Количество элементов на странице равно \"(.+)\"$")
    public void countElements(int count) {selectItem.countElements(count);}
    @Когда("^Запомнен текст элемента \"(.+)\"$")
    public String getElementText(int i) { return selectItem.getElementText(i);}
    @Когда("^Строка поиска заполнена запомненым текстом элемента \"(.+)\"$")
    public void searchElement(int i) {selectItem.searchElement(i);}
    @Тогда("^Проверить, что строка поиска заполнена текстом элемента \"(.+)\"$")
    public void getFillField(int i){selectItem.getFillField(i);}


}
