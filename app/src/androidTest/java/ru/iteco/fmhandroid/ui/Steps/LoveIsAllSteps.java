package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.LoveIsAllPage;

public class LoveIsAllSteps {

    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();

    public void clickButtonLoveIsAll() {
        Allure.step("На главной странице экрана приложения нажать на кнопку Бабочка (Тематические цитаты).");
        loveIsAllPage.getQuoteElementButtonLoveIsAll
                .perform(click());
    }

    public void checkTitleLoveIsAll() {
        Allure.step("Проверить заголовок Love is all на вкладке Тематические цитаты.");
        loveIsAllPage.getQuoteElementTitleLoveIsAll
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public void clickButtonToExpandLoveIsAll() {
        Allure.step("Нажать на кнопку развернуть тематическую цитату.");
        loveIsAllPage.getQuoteElementButtonToExpandLoveIsAll
                .perform(click());
    }

    public int getMissionImageButton() {
        return loveIsAllPage.missionImageButton;
    }
}