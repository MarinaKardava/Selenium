import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InsurenceTest {
    private WebDriver driver;
    private String baseUrl;

    @Before //выполняется перед каждым тестом
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe"); // переменная с инфой где лежит драйвер

        driver = new ChromeDriver(); // экземпляр класса
        baseUrl = "http://www.sberbank.ru/ru/person"; // путь к сайту
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // развернуть на весь экран
    }
    @Test
    public void testInsurence() throws Exception {
        driver.get(baseUrl); // переход по ссылке
       driver.findElement(By.xpath("//ul//li[contains(@class,'lg-menu__')]/button/*[contains(text(),'Страхование')]")).click();
       driver.findElement(By.xpath("//li[contains(@class,'lg-menu')]/a[contains(text(),'Страхование путешественников')]")).click();
       Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
       WebElement send = driver.findElement(By.xpath("//div[contains(@class,'kit-col_lg-top_40')]/h2[contains(text(),'Страхование путешественников')]"));
       wait.until(ExpectedConditions.visibilityOf(send));
       assertEquals("Страхование путешественников", send.getText());

       scrollDown("//b[contains(text(),'Оформить онлайн')]");
       driver.findElement(By.xpath("//b[contains(text(),'Оформить онлайн')]")).click();
       WebElement sendtitle = driver.findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]"));

       //Выбор полиса
       wait.until(ExpectedConditions.visibilityOf(sendtitle));
        scrollDown("//*[contains(text(),'Минимальная')]");
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//div[contains (@class,'selected')]/div/div[@class='selected-icon']"));
        scrollDown("//*[contains(text(),'Оформить')]");
        driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();

        //Заполнение формы "застрахованные"
        fillField(By.xpath("//*[@placeholder='Surname']"),"Ivanov");
        fillField(By.xpath("//*[@placeholder='Name']"),"Ivan");
        fillField(By.id("birthDate_vzr_ins_0"),"16101996");
        driver.findElement(By.xpath("//div[contains(@class,'col-md-4')]//i[@class='tick']")).click();

        //Заполнение формы "Страхователь"
        scrollDown("//*[@id='person_lastName']");
        fillField(By.id("person_lastName"),"Иванов");
        fillField(By.id("person_firstName"),"Иван");
        fillField(By.id("person_middleName"),"Иванович");
        scrollDown("//*[@id='person_birthDate']");
        fillField(By.id("person_birthDate"),"16101996");
        driver.findElement(By.xpath("//div[contains(@class,'col-md-6')]//i[@class='tick']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Женский')]")).click();

        //Заполнение формы "Паспортные данные"
        scrollDown("//*[@id='passportSeries']");
        fillField(By.id("passportSeries"),"1111");
        fillField(By.id("passportNumber"),"111111");
        fillField(By.id("documentDate"),"25102018");
        driver.findElement(By.xpath("//div[contains(@class,'document')]//i[@class='tick']")).click();
        fillField(By.id("documentIssue"),"оларовлпровапо");

        //Проверки заполнения полей
        scrollDown("//*[@placeholder='Surname']");
        assertEquals("Ivanov",driver.findElement(By.xpath("//*[@placeholder='Surname']")).getAttribute("value"));
        assertEquals("Ivan",driver.findElement(By.xpath("//*[@placeholder='Name']")).getAttribute("value"));
        assertEquals("16.10.1996",driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        scrollDown("//*[@id='person_lastName']");
        assertEquals("Иванов",driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Иван",driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович",driver.findElement(By.id("person_middleName")).getAttribute("value"));
        scrollDown("//*[@id='person_birthDate']");
        assertEquals("16.10.1996",driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        scrollDown("//*[@id='passportSeries']");
        assertEquals("1111",driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("111111",driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("25.10.2018",driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("оларовлпровапо",driver.findElement(By.id("documentIssue")).getAttribute("value"));

        //Проверка наличия сообщений
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
        assertEquals("При заполнении данных произошла ошибка",driver.findElement(By.xpath("//div[@role='alert-form']")).getText());
        assertEquals("Поле не заполнено.",driver.findElement(By.xpath("//input-phone2//*[contains(text(),'Поле не заполнено')]")).getText());
        assertEquals("Поле не заполнено.",driver.findElement(By.xpath("//input-email[@name='email']//*[contains(text(),'Поле не заполнено')]")).getText());
        assertEquals("Поле не заполнено.",driver.findElement(By.xpath("//input-email[@name='repeatEmail']//*[contains(text(),'Поле не заполнено')]")).getText());

    }
    @After // выполняется после каждого теста
    public void tearDown() throws Exception {
        driver.quit(); //закрыть браузер
    }


    //метод заполнения полей
    private void fillField(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    //скролинг к необходимому элементу
    public void scrollDown(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);

    }

}
