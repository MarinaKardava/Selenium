package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PressButton extends BasePages {
    @FindBy(xpath = "//b[contains(text(),'Оформить онлайн')]")
    public WebElement buttonOfOn;

    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement buttonOf;
     //  driver.findElement(By.xpath("//b[contains(text(),'Оформить онлайн')]")).click();
     @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
     public WebElement buttonContin;

    public PressButton(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }
    public void pressButtonOf(String nameButton){
        switch (nameButton){
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
    /*public void pressButtonOf () {
        scrollDown(buttonOf);
        buttonOf.click();
    }
    public void pressButtonOfOn () {
        scrollDown(buttonOfOn);
        buttonOfOn.click();
    }
    public void pressButtonContin () {
        scrollDown(buttonContin);
        buttonContin.click();
    }*/



}
