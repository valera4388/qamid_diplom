package ru.iteco.fmhandroid.ui.PageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public ViewInteraction getAboutElementButtonAbout;
    public ViewInteraction getAboutElementButtonPrivacyPolicy;
    public ViewInteraction getAboutElementButtonTermsOfUse;
    public ViewInteraction getCheckDisplayOEmployeesCompanyLabel;
    public ViewInteraction getPressBackButton;

    public AboutPage() {
        getAboutElementButtonAbout = onView(allOf(withId(android.R.id.title), withText("About")));
        getAboutElementButtonPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        getAboutElementButtonTermsOfUse = onView(withId(R.id.about_terms_of_use_value_text_view));
        getPressBackButton = onView(withId(R.id.about_back_image_button));
        getCheckDisplayOEmployeesCompanyLabel = onView(allOf(withId(R.id.about_company_info_label_text_view), withText("© I-Teco, 2022")));
    }
}