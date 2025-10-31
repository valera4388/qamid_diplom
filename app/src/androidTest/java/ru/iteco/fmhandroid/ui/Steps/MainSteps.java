package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    public void mainScreenLoad() {
        Allure.step(" Загрузка страницы");
        onView(isRoot()).perform(waitDisplayed(mainPage.allNews, 5000));
    }

    public void clickButtonAllNews() {
        Allure.step(" Нажать на кнопку ВСЕ НОВОСТИ");
        mainPage.getMainElementsButtonAllNews
                .perform(click());
    }

    public void showButtonAllNews() {
        Allure.step(" Отобразилась кнопка ВСЕ НОВОСТИ");
        mainPage.getMainElementsButtonAllNews
                .check(matches(withText("ALL NEWS")));
    }

    public void clickButtonMainMenu() {
        Allure.step(" Нажать на кнопку Главного меню");
        mainPage.getMainElementsButtonMainMenu
                .perform(click());
    }

    public void clickButtonMain() {
        Allure.step(" Нажать на кнопку Главная в Главном меню");
        mainPage.getMainElementsButtonMain
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step(" Нажать на кнопку Свернуть/развернуть ВСЕ НОВОСТИ на Главной странице");
        mainPage.getMainElementsButtonToRollUpAllNews
                .perform(click());
    }

    public void showTitleNewsOnMain() {
        Allure.step(" Отобразилась панель Новости (News) в разделе Main");
        mainPage.getMainElementsTitleNews
                .check(matches(isDisplayed()));

    }

    public void waitUntilMainMenuButtonDisplayed() {
        Allure.step(" Ожидание отображения кнопки гланого меню");
        onView(isRoot()).perform(waitDisplayed(getMainMenuButton(), 5000));
    }

    public void waitingDisplayButtonExpandNews() {
        Allure.step(" Ожидание отображения кнопки кнопки для раскрытия новостей");
        onView(isRoot()).perform(waitDisplayed(getButtonToExpandNews(), 5000));
    }

    public int getMainMenuButton() {
        return mainPage.mainMenuButton;
    }

    public int getButtonToExpandNews() {
        return mainPage.buttonToExpandNews;
    }
}