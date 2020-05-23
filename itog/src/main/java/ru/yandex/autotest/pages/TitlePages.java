package ru.yandex.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.autotest.steps.BaseSteps;
import static org.junit.Assert.assertTrue;

public class TitlePages {
    @FindBy(xpath = "//*[contains(@class,'_3uHkOtqznG ')]")
    public WebElement pageTitleOne;
    @FindBy (xpath = "//*[contains(@class,'headline__header-title')]")
    public WebElement pageTitleTwo;

    public TitlePages(){PageFactory.initElements(BaseSteps.getDriver(),this);}

    public void titleTabList(String expectedTitle){
        String actualTitle = pageTitleOne.findElement(By.xpath(".//*[contains(text(),'"+expectedTitle+"')]")).getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));

    }
    public void titleNavigationTree (String expectedTitle){
        String actualTitle = pageTitleTwo.findElement(By.xpath(".//*[contains(text(),'"+expectedTitle+"')]")).getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
