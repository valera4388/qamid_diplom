package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.AboutPage;

public class AboutSteps {
    AboutPage aboutPage = new AboutPage();

    public static final String urlPrivacyPolicy = "https://vhospice.org/#/privacy-policy/";
    public static final String urlTermsOfUse = "https://vhospice.org/#/terms-of-use";

    public void clickButtonAboutMainMenu() {
        Allure.step(" Нажать кнопку О приложении (About) в Главном меню");
        aboutPage.getAboutElementButtonAbout
                .perform(click());
    }

    public void clickButtonPrivacyPolicy() {
        Allure.step(" Нажать на ссылку Политика конфиденциальности (Privacy policy).");
        aboutPage.getAboutElementButtonPrivacyPolicy
                .perform(click());
    }

    public void clickButtonTermsOfUse() {
        Allure.step(" Нажать на ссылку Пользовательское соглашение (Terms of use).");
        aboutPage.getAboutElementButtonTermsOfUse
                .perform(click());
    }

    public void clickButtonPressBack() {
        Allure.step(" Нажать на кнопку назад из раздела О приложении");
        aboutPage.getPressBackButton.
                perform(click());
    }

    public void displaysInformationAboutCompanyLabel() {
        Allure.step(" Отображается информация/этикетка компании разработчика");
        aboutPage.getCheckDisplayOEmployeesCompanyLabel
                .check(matches(isDisplayed()));
    }

    public void verifyIntent(String expectedUrl) {
        Allure.step(" Проверка, что инициирован Intent с действием VIEW и правильным URL");
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(expectedUrl)
        ));
    }
}