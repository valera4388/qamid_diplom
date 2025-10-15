package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;
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

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для функционального тестирования Авторизации мобильного приложения")
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

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }

    @Test
    @DisplayName("Авторизация зарегистрированного пользователя (ID - 1)")
    public void successfulAuthorization() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        mainSteps.showTitleNewsOnMain();
    }

    @Test
    @DisplayName("Авторизация с логином зарегистрированного пользователя введенным в верхнем регистре (ID - 2)")
    public void usernameUppercase() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUpLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с паролем зарегистрированного пользователя введенным в верхнем регистре (ID - 3)")
    public void passwordUppercase() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getUpPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с логином незарегистрированного пользователя и верным паролем (ID - 4)")
    public void loginUnregisteredUser() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с логином зарегистрированного пользователя и не верным паролем (ID - 5)")
    public void IncorrectUserPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getIncorrectUserPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с пустым значением поля логин (ID - 6")
    public void loginFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLoginFieldIsEmpty());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Авторизация с пустым значением поля пароль (ID - 7")
    public void passwordFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPasswordFieldIsEmpty());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Выход пользователя из приложения (ID - 8)")
    public void exitUser() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        mainSteps.showTitleNewsOnMain();
        authorizationSteps.clickButtonExit();
        authorizationSteps.clickButtonLogOut();
    }
}