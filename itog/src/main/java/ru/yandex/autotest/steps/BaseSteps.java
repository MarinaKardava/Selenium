package ru.yandex.autotest.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    //protected static String baseUrl;
    //public static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriver getDriver(){
        return driver;
    }


    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver .get("https://yandex.ru/");
        driver .manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }


    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
