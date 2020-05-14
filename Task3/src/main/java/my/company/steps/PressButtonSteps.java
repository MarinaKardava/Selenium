package my.company.steps;

import my.company.pages.PressButtonPages;
import ru.yandex.qatools.allure.annotations.Step;

public class PressButtonSteps {
    @Step ("Нажать кнопку {0}")
    public void pressButtonOf(String nameButton) {
        new PressButtonPages().pressButtonOf(nameButton);
    }
}
