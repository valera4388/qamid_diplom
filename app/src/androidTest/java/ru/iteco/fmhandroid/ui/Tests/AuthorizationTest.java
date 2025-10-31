package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getIncorrectUserPassword;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLoginFieldIsEmpty;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPasswordFieldIsEmpty;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getUnregisteredLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getUpLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getUpPassword;

import android.view.View;

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

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic(" Тест-кейсы для функционального тестирования Авторизации мобильного приложения")
public class AuthorizationTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.loadAuthorizationPage();
        } catch (
                Exception e) {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
            authorizationSteps.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @DisplayName(" Авторизация зарегистрированного пользователя (ID - 1)")
    public void successfulAuthorization() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.waitingForUserIconDisplayed();
        mainSteps.showTitleNewsOnMain();
    }

    @Test
    @DisplayName(" Авторизация с логином зарегистрированного пользователя введенным в верхнем регистре (ID - 2)")
    public void usernameUppercase() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUpLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textAuthorizationError();
    }

    @Test
    @DisplayName(" Авторизация с паролем зарегистрированного пользователя введенным в верхнем регистре (ID - 3)")
    public void passwordUppercase() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getUpPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textAuthorizationError();
    }

    @Test
    @DisplayName(" Авторизация с логином незарегистрированного пользователя и верным паролем (ID - 4)")
    public void loginUnregisteredUser() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textAuthorizationError();
    }

    @Test
    @DisplayName(" Авторизация с логином зарегистрированного пользователя и не верным паролем (ID - 5)")
    public void IncorrectUserPassword() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getIncorrectUserPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textAuthorizationError();
    }

    @Test
    @DisplayName(" Авторизация с пустым значением поля логин (ID - 6)")
    public void loginFieldIsEmpty() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLoginFieldIsEmpty());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textEmptyAuthorizationFieldError();
    }

    @Test
    @DisplayName(" Авторизация с пустым значением поля пароль (ID - 7)")
    public void passwordFieldIsEmpty() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPasswordFieldIsEmpty());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.textEmptyAuthorizationFieldError();
    }

    @Test
    @DisplayName(" Выход пользователя из приложения (ID - 8)")
    public void exitUser() {
        authorizationSteps.waitingForLoginInputFieldDisplay();
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.waitingForUserIconDisplayed();
        mainSteps.showTitleNewsOnMain();
        authorizationSteps.clickButtonExit();
        authorizationSteps.clickButtonLogOut();
    }
}