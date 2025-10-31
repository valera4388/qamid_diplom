package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPassword;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;
import ru.iteco.fmhandroid.ui.Steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic(" Тест-кейсы для функционального тестирования вкладки News")
public class NewsTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

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
    @DisplayName(" Переход в раздел News из бургер-меню (ID - 13)")
    public void goNewsSection() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.newsSectionHasBeenDisplayed();
    }
}