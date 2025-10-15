package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.NewsPage;

public class NewsSteps {

    NewsPage newsPage = new NewsPage();

    public void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости в Главном меню");
        newsPage.getNewsButton
                .perform(click());
    }
}