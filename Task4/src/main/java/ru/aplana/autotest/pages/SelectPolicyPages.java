package ru.aplana.autotest.pages;

import ru.aplana.autotest.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPolicyPages extends BasePages {
    @FindBy(xpath = "//fieldset[@class = 'no-offset non-border']")
    WebElement viewPolicy;

    @FindBy(xpath = "//*[contains(text(),'Регион действия полиса')]")
    public WebElement pageTitle;

    public SelectPolicyPages() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }
    public void selectPolicy (String policyItem) {
        scrollDown(viewPolicy);
        viewPolicy.findElement(By.xpath(".//h3[contains(text(),'"+policyItem+"')]")).click();
        viewPolicy.findElement(By.xpath("//div[contains (@class,'selected')]/div/div[@class='selected-icon']"));

    }

}
