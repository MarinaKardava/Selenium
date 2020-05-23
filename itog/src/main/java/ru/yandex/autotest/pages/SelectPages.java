package ru.yandex.autotest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.autotest.steps.BaseSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelectPages extends BasePages{
    @FindBy(xpath = "//*[contains(@class,'n-snippet-card2 i-bem ')]//h3/a[contains(@class,'link n-link_theme')]")
    List<WebElement> list;

    @FindBy(id = "header-search")
    WebElement searchLine;

    public void SelectPages(){
        PageFactory.initElements(BaseSteps.getDriver(),this);}
    public void countElements (int count){
        int actualCount = list.size();
        assertEquals("Количество элементов равно [%s]. Ожидалось - [%s]",count,actualCount);
    }
    public String getElementText(int i){
        String elementName = list.get(i-1).getAttribute("title");
        return elementName;
    }
    public void searchElement(int i){
        scrollDown(searchLine);
        fillField(searchLine,getElementText(i));
        searchLine.sendKeys(Keys.ENTER);
    }
    public String getFillField(){
        return searchLine.getAttribute("value");

    }

}
