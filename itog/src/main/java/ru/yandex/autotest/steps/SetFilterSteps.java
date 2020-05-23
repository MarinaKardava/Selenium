package ru.yandex.autotest.steps;

import ru.yandex.autotest.pages.SetFilterPages;
import ru.yandex.qatools.allure.annotations.Step;

public class SetFilterSteps {

    @Step("В поле {0} ввести {1}")
    public void selectSum(String filtrSum, String value){
        new SetFilterPages().selectSum(filtrSum, value);
    }
    @Step ("Выбрать производителя: {0} ")
    public void setProducer(String nameProducer) {
        new SetFilterPages().setProducer(nameProducer);
    }



}
