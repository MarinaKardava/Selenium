package ru.yandex.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.autotest.steps.BaseSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetFilterPages extends BasePages{

    @FindBy(id = "glf-pricefrom-var")
    WebElement priceFrom;
    @FindBy(id = "glf-priceto-var")
    WebElement priceTo;
    @FindBy(xpath = "//*[@data-filter-id='7893318']")
    WebElement producer;

public  void SetFilterPages() {PageFactory.initElements(BaseSteps.getDriver(),this);}
    public void selectSum(String filtrSum, String value){
        switch(filtrSum){
            case "Сумма ОТ":
                scrollDown(priceFrom);
                priceFrom.sendKeys(value);
                break;
            case "Сумма ДО":
                scrollDown(priceTo);
                priceTo.sendKeys(value);
                break;
        }

    }
    public void setProducer(String nameProducer) {
        scrollDown(producer);
        producer.findElement(By.xpath(".//*[contains(text(),'"+nameProducer+"')]")).click();
    }


}
