package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.NewsPage;

public class NewsSteps {

    NewsPage newsPage = new NewsPage();

    public void clickButtonNews() {
        Allure.step(" Нажать на кнопку Новости в Главном меню");
        newsPage.getNewsButton
                .perform(click());
    }

    public void newsSectionHasBeenDisplayed() {
        Allure.step(" Отобразился раздел Новости (News)");
        newsPage.getMainElementsOfNewsSection
                .check(matches(isDisplayed()));
    }
}