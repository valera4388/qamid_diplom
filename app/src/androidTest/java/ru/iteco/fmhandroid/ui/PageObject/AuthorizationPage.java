package ru.iteco.fmhandroid.ui.PageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class AuthorizationPage {
    public ViewInteraction getAuthorizationElementsButton;
    public ViewInteraction getAuthorizationElementsLoginField;
    public ViewInteraction getAuthorizationElementsPasswordField;
    public ViewInteraction getAuthorizationElementsButtonExit;
    public ViewInteraction getAuthorizationElementsButtonLogOut;
    public ViewInteraction getAuthorizationElementsTextAuthorization;
    public int loginField;
    public static String rightLogin;
    public static String rightPassword;
    public static String usernameUppercase;
    public static String passwordUppercase;
    public static String unregisteredLogin;
    public static String incorrectUserPassword;
    public static String loginFieldIsEmpty;
    public static String passwordFieldIsEmpty;
    public int loginLayout;
    public int enterButton;

    public AuthorizationPage() {


        getAuthorizationElementsButton = onView(withId(R.id.enter_button));
        getAuthorizationElementsLoginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        getAuthorizationElementsPasswordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
        getAuthorizationElementsButtonExit = onView(withId(R.id.authorization_image_button));
        getAuthorizationElementsButtonLogOut = onView(allOf(withId(android.R.id.title), withText("Log out")));
        getAuthorizationElementsTextAuthorization = onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
        loginField = R.id.login_text_input_layout;
        rightLogin = "login2";
        rightPassword = "password2";
        usernameUppercase = "LOGIN2";
        passwordUppercase = "PASSWORD2";
        unregisteredLogin = "login12";
        incorrectUserPassword = "password12";
        loginFieldIsEmpty = "";
        passwordFieldIsEmpty = "";
        loginLayout = R.id.login_text_input_layout;
        enterButton = R.id.enter_button;
    }
}