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

@Epic(" Тест-кейсы для функционального тестирования вкладки Main")
public class MainTest {

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
    @DisplayName(" Переход в раздел Main из бургер-меню из раздела News (ID - 9)")
    public void Main() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.newsSectionHasBeenDisplayed();
        mainSteps.clickButtonMainMenu();
        mainSteps.clickButtonMain();
        mainSteps.showTitleNewsOnMain();
    }

    @Test
    @DisplayName(" Свернуть/развернуть выпадающий список News из раздела Main (ID - 10)")
    public void extendNews() {
        mainSteps.waitingDisplayButtonExpandNews();
        mainSteps.clickButtonToExpandNews();
        mainSteps.clickButtonToExpandNews();
        mainSteps.showButtonAllNews();
    }

    @Test
    @DisplayName(" Перейти в раздел News нажав кнопку ALL News (ID - 11)")
    public void allNews() {
        mainSteps.waitUntilMainMenuButtonDisplayed();
        mainSteps.clickButtonAllNews();
        newsSteps.newsSectionHasBeenDisplayed();
    }
}