package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.LoveIsAllPage;

public class LoveIsAllSteps {

    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();

    public void clickButtonLoveIsAll() {
        Allure.step(" На главной странице экрана приложения нажать на кнопку Бабочка (Тематические цитаты).");
        loveIsAllPage.getQuoteElementButtonLoveIsAll
                .perform(click());
    }

    public void checkTitleLoveIsAll() {
        Allure.step(" Отобразился заголовок Love is all на вкладке Тематические цитаты.");
        loveIsAllPage.getQuoteElementTitleLoveIsAll
                .check(matches(isDisplayed()));
    }

    public void clickButtonToExpandLoveIsAll() {
        Allure.step(" Нажать на кнопку развернуть тематическую цитату.");
        loveIsAllPage.getQuoteElementButtonToExpandLoveIsAll
                .perform(click());
    }

    public void waitingForButterflyIconDisplay() {
        Allure.step(" Ожидание отображения иконки Бабочка.");
        onView(isRoot()).perform(waitDisplayed(getMissionImageButton(), 5000));
    }

    public void showQuoteLoveIsAll() {
        Allure.step(" Отображается цитата Love is all на вкладке Тематические цитаты.");
        loveIsAllPage.getCheckDisplayOfQuoteLoveIsAll
                .check(matches(isDisplayed()));
    }

    public int getMissionImageButton() {
        return loveIsAllPage.missionImageButton;
    }
}