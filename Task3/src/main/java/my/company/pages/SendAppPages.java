package my.company.pages;

import my.company.steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SendAppPages extends BasePages {
    @FindBy(id = "surname_vzr_ins_0")
    public WebElement Surname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement Name;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate;

    @FindBy(id = "person_lastName")
    WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy(xpath = "//*[@title = 'Пол']/div[@class='form-group form-group_label-fill']")
    WebElement sex;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;


    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    public SendAppPages() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Surname":
                fillField(Surname, value);
                break;
            case "Name":
                fillField(Name, value);
                break;
            case "birthDate":
                fillField(birthDate, value);
                driver.findElement(By.xpath("//div[contains(@class,'col-md-4')]//i[@class='tick']")).click();
                break;
            case "Фамилия":
                scrollDown(person_lastName);
                fillField(person_lastName, value);
                break;
            case "Имя":
                fillField(person_firstName, value);
                break;
            case "Отчество":
                fillField(person_middleName, value);
                break;
            case "Дата Рождения":
                fillField(person_birthDate, value);
                driver.findElement(By.xpath("//div[contains(@class,'col-md-6')]//i[@class='tick']")).click();
                break;
            case "Пол":
                sex.findElement(By.xpath(".//label[contains(text(),'" + value + "')]")).click();
                break;
            case "Серия Паспорта":
                scrollDown(passportSeries);
                fillField(passportSeries, value);
                break;
            case "Номер Паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата Выдачи":
                fillField(documentDate, value);
                driver.findElement(By.xpath("//div[contains(@class,'document')]//i[@class='tick']")).click();
                break;
            case "Кем выдано":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Surname":
                scrollDown(Surname);
                return Surname.getAttribute("value");
            case "Name":
                return Name.getAttribute("value");
            case "birthDate":
                return birthDate.getAttribute("value");
            case "Фамилия":
                scrollDown(person_lastName);
                return person_lastName.getAttribute("value");
            case "Имя":
                return person_firstName.getAttribute("value");
            case "Отчество":
                return person_middleName.getAttribute("value");
            case "Дата Рождения":
                return person_birthDate.getAttribute("value");
            case "Серия Паспорта":
                scrollDown(passportSeries);
                return passportSeries.getAttribute("value");
            case "Номер Паспорта":
                return passportNumber.getAttribute("value");
            case "Дата Выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдано":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage) {
        String xpath = "//*[@name='" + field + "']//*[contains(text(),'Поле не заполнено')]";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

}
