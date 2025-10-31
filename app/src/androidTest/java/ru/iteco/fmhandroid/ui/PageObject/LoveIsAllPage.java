package ru.iteco.fmhandroid.ui.PageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoveIsAllPage {

    public ViewInteraction getQuoteElementButtonLoveIsAll;
    public ViewInteraction getQuoteElementTitleLoveIsAll;
    public ViewInteraction getQuoteElementButtonToExpandLoveIsAll;
    public ViewInteraction getCheckDisplayOfQuoteLoveIsAll;
    public int missionImageButton;


    public LoveIsAllPage() {

        getQuoteElementButtonLoveIsAll = onView(withId(R.id.our_mission_image_button));
        getQuoteElementTitleLoveIsAll = onView(allOf(withText("Love is all"), withId(R.id.our_mission_title_text_view)));
        getQuoteElementButtonToExpandLoveIsAll = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
        getCheckDisplayOfQuoteLoveIsAll = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
        missionImageButton = R.id.our_mission_image_button;
    }
}