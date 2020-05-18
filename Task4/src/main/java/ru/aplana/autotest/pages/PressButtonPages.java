package ru.aplana.autotest.pages;

import ru.aplana.autotest.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PressButtonPages extends BasePages {
    @FindBy(xpath = "//b[contains(text(),'Оформить онлайн')]")
    public WebElement buttonOfOn;

    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement buttonOf;
     //  driver.findElement(By.xpath("//b[contains(text(),'Оформить онлайн')]")).click();
     @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
     public WebElement buttonContin;
    @FindBy(xpath = "//div[contains(@class,'kit-col_lg-top_40')]/h2[contains(text(),'Страхование путешественников')]")
    public WebElement title;



    public PressButtonPages() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }
    public void pressButtonOf(String nameButton) {
        switch (nameButton) {
            case "Оформить":
                scrollDown(buttonOf);
                buttonOf.click();
                break;
            case "Оформить онлайн":
                scrollDown(buttonOfOn);
                buttonOfOn.click();
                break;
            case "Продолжить":
                scrollDown(buttonContin);
                buttonContin.click();
                break;
        }

    }

}
