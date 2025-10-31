package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.incorrectUserPassword;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.loginFieldIsEmpty;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.passwordFieldIsEmpty;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.passwordUppercase;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.rightLogin;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.rightPassword;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.unregisteredLogin;
import static ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage.usernameUppercase;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    public void loadAuthorizationPage() {
        Allure.step(" Загрузка страницы авторизации");
        onView(isRoot()).perform(waitDisplayed((authorizationPage.enterButton), 5000));
    }

    public void clickButtonSignIn() {
        Allure.step(" Нажать на кнопку Войти");
        authorizationPage.getAuthorizationElementsButton
                .perform(click());
    }

    public void clickButtonExit() {
        Allure.step(" Нажать на кнопку Выход");
        authorizationPage.getAuthorizationElementsButtonExit
                .perform(click());
    }

    public void clickButtonLogOut() {
        Allure.step(" Нажать на кнопку для выхода из приложения");
        authorizationPage.getAuthorizationElementsButtonLogOut
                .perform(click());
    }

    public void textAuthorization() {
        Allure.step(" Отобразилаcь страница Авторизации");
        authorizationPage.getAuthorizationElementsTextAuthorization
                .check(matches(isDisplayed()));
    }

    public void fillLoginField(String text) {
        Allure.step(" Поле Логин - ввод данных" + text);
        authorizationPage.getAuthorizationElementsLoginField.perform(replaceText(text));
    }

    public void fillPasswordField(String text) {
        Allure.step(" Поле Пароль - ввод данных" + text);
        authorizationPage.getAuthorizationElementsPasswordField.perform(replaceText(text));
    }
    public void waitingForLoginInputFieldDisplay() {
        Allure.step(" Ожидание отображения поля ввода данных Логин");
        onView(isRoot()).perform(waitDisplayed(getLoginLayout(), 5000));
    }

    public void waitingForUserIconDisplayed() {
        Allure.step(" Ожидание отображения иконки Пользователь");
        onView(isRoot()).perform(waitDisplayed(getUserIcon(), 3000));
    }

    public void textAuthorizationError() {
        Allure.step(" Ошибка Авторизации");
        authorizationPage.getTextAuthorizationError
                .check(matches(isDisplayed()));
    }

    public void textEmptyAuthorizationFieldError() {
        Allure.step(" Ошибка пустого поля Авторизации");
        authorizationPage.getTextEmptyAuthorizationFieldError
                .check(matches(isDisplayed()));
    }

    public static String getLogin() {
        return rightLogin;
    }

    public static String getPassword() {
        return rightPassword;
    }

    public static String getUpLogin() {
        return usernameUppercase;
    }

    public static String getUpPassword() {
        return passwordUppercase;
    }

    public static String getUnregisteredLogin() {
        return unregisteredLogin;
    }

    public static String getIncorrectUserPassword() {
        return incorrectUserPassword;
    }
    public static String getLoginFieldIsEmpty() {
        return loginFieldIsEmpty;
    }
    public static String getPasswordFieldIsEmpty() {
        return passwordFieldIsEmpty;
    }
    public int getLoginLayout() {
        return authorizationPage.loginLayout;
    }
    public int getUserIcon() {
        return authorizationPage.userIcon;
    }
}