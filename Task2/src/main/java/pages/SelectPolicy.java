package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPolicy extends BasePages {
    @FindBy(xpath = "//fieldset[@class = 'no-offset non-border']")
    WebElement viewPolicy;

    public SelectPolicy(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void selectPolicy (String policyItem) {
        scrollDown(viewPolicy);
        viewPolicy.findElement(By.xpath(".//h3[contains(text(),'"+policyItem+"')]")).click();
        viewPolicy.findElement(By.xpath("//div[contains (@class,'selected')]/div/div[@class='selected-icon']"));

    }

}
