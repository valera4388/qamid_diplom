package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPassword;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Steps.AboutSteps;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic(" Тест-кейсы для функционального тестирования вкладки About")
public class AboutTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutSteps aboutSteps = new AboutSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            mainSteps.mainScreenLoad();
        }
    }

    @Test
    @DisplayName(" Переход в раздел О приложении из бургер-меню (ID - 55)")
    public void watchingAbout() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.displaysInformationAboutCompanyLabel();
    }

    @Test
    @DisplayName(" Переход по ссылке Политика конфиденциальности (ID - 56)")
    public void watchingPrivacyPolicy() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonPrivacyPolicy();
        aboutSteps.verifyIntent(AboutSteps.urlPrivacyPolicy);
    }

    @Test
    @DisplayName(" Переход по ссылке Пользовательское соглашение (ID - 57)")
    public void watchingTermsOfUse() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonTermsOfUse();
        aboutSteps.verifyIntent(AboutSteps.urlTermsOfUse);
    }

    @Test
    @DisplayName(" Возвращение к предыдущей странице нажав кнопку назад из раздел О приложении (ID - 58)")
    public void returnToPreviousPage() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonPressBack();
        mainSteps.showTitleNewsOnMain();
    }
}