package ru.iteco.fmhandroid.ui.PageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class NewsPage {

    public ViewInteraction getNewsButton;
    public ViewInteraction getMainElementsOfNewsSection;

    public NewsPage() {
        getNewsButton = onView(allOf(withId(android.R.id.title), withText("News")));
        getMainElementsOfNewsSection = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include)))));
     }
}