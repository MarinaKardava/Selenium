package ru.yandex.autotest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.autotest.steps.BaseSteps;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SectionPages extends BasePages{
    @FindBy(xpath = "//div[@role ='tablist']")
    WebElement tabList;
    @FindBy (xpath = "//*[@class='sxrttPxJA0 a6VijDBKnU']")
    WebElement navigationTree;


    public void SectionPages(){
        PageFactory.initElements(BaseSteps.getDriver(),this);

    }
    public void setTabList(String tabListItem){
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);}
        WebElement
                selectItem = tabList.findElement(By.xpath(".//*[contains(text(),'"+tabListItem+"')]"));
        scrollDown(selectItem);
        selectItem.click();

    }
    public void setNavigationTree (String navigationTreeItem){
        WebElement
                selectItem = navigationTree.findElement(By.xpath(".//*[contains(text(),'"+navigationTreeItem+"')]"));
        scrollDown(selectItem);
        selectItem.click();
    }


}
