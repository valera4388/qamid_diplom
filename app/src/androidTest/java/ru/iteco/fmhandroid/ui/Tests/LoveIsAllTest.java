package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPassword;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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
import ru.iteco.fmhandroid.ui.Steps.LoveIsAllSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic(" Тест-кейсы проведения функционального тестирования вкладки Love is All")
public class LoveIsAllTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    LoveIsAllSteps loveIsAllSteps = new LoveIsAllSteps();
    MainSteps mainSteps = new MainSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

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
    @DisplayName(" Переход в раздел Главное - жить любя нажав кнопку Бабочка (ID - 59)")
    public void transitionToloveIsAll() {
        loveIsAllSteps.waitingForButterflyIconDisplay();
        loveIsAllSteps.clickButtonLoveIsAll();
        loveIsAllSteps.checkTitleLoveIsAll();
    }

    @Test
    @DisplayName(" Свернуть/развернуть цитату кликнув на нее (ID - 60)")
    public void expandLoveIsAll() {
        loveIsAllSteps.waitingForButterflyIconDisplay();
        loveIsAllSteps.clickButtonLoveIsAll();
        loveIsAllSteps.checkTitleLoveIsAll();
        loveIsAllSteps.clickButtonToExpandLoveIsAll();
        loveIsAllSteps.showQuoteLoveIsAll();
    }
}