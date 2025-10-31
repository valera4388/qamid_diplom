package ru.iteco.fmhandroid.ui.PageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;


public class NewsControlPanelPage {

    public ViewInteraction getNewsControlPanelElementsButtonControlPanel;
    public ViewInteraction getNewsControlPanelElementsAddNews;
    public ViewInteraction getNewsControlPanelElementsButtonTitleCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonDateCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonOkDateCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonTimeCreatingNews;
    public ViewInteraction getNewsControlPanelElementsDescriptionCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonOkTimeCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonSaveCreatingNews;
    public ViewInteraction getNewsControlPanelElementsCategoryText;
    public ViewInteraction getNewsControlPanelElementsInputTime;
    public ViewInteraction getNewsControlPanelElementsButtonSortingControlPanel;
    public ViewInteraction getNewsControlPanelElementsButtonToExpandNews;
    public ViewInteraction getNewsControlPanelElementsButtonToDeleteNews;
    public ViewInteraction getNewsControlPanelElementsButtonToOkDeleteNews;
    public ViewInteraction getNewsControlPanelElementsButtonToEditNews;
    public ViewInteraction getNewsControlPanelElementsButtonToSwitchStatusNews;
    public ViewInteraction getNewsControlPanelElementsButtonToFilterNews;
    public ViewInteraction getNewsControlPanelElementsButtonNewsFilter;
    public ViewInteraction getNewsControlPanelElementsButtonActiveNewsFilter;
    public ViewInteraction getNewsControlPanelElementsButtonNotActiveNewsFilter;
    public ViewInteraction getNewsControlPanelElementsClickDateButtonToCreateStartingDate;
    public ViewInteraction getNewsControlPanelElementsClickDateButtonToCreateEndDate;
    public ViewInteraction getNewsFromPanelCheckVisibilityOfNewsDescription;
    public ViewInteraction getNewsControlPanelElementsEmptyFieldErrorCheck;
    public ViewInteraction getNewsControlPanelElementsCheckingErrorFailedSave;
    public ViewInteraction getNewsControlPanelElementsCheckingErrorWrongPeriod;
    public ViewInteraction getNewsControlPanelElementsCheckingCreationDateOfNews;
    public ViewInteraction getNewsControlPanelElementsFillingInDateField;
    public ViewInteraction getNewsFromPanelCheckVisibilityOfNewsTitle;
    public ViewInteraction getCheckingDeleteNews;
    public ViewInteraction getNewsFromPanelCheckNewsStatus;

    private View decorView;

    public static String categoryAdvertisement;
    public static String titleAdvertisement;
    public static String descriptionAdvertisement;
    public static String customCategory;
    public static String fieldEmpty;
    public static String specialSymbol;
    public static String numbersCategory;
    public static String createDate;
    public static String verificationDate;
    public static String statusActive;
    public static String statusNotActive;
    public static String switcherStatusNotActive;

       public NewsControlPanelPage() {

        getNewsControlPanelElementsButtonControlPanel = onView(withId(R.id.edit_news_material_button));
        getNewsControlPanelElementsAddNews = onView(withId(R.id.add_news_image_view));
        getNewsControlPanelElementsButtonTitleCreatingNews = onView(withId(R.id.news_item_title_text_input_edit_text));
        getNewsControlPanelElementsButtonDateCreatingNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        getNewsControlPanelElementsButtonOkDateCreatingNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonTimeCreatingNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        getNewsControlPanelElementsDescriptionCreatingNews = onView(withId(R.id.news_item_description_text_input_edit_text));
        getNewsControlPanelElementsButtonOkTimeCreatingNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonSaveCreatingNews = onView(withId(R.id.save_button));
        getNewsControlPanelElementsCategoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        getNewsControlPanelElementsInputTime = onView(allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input.")));
        getNewsControlPanelElementsButtonSortingControlPanel = onView(withId(R.id.sort_news_material_button));
        getNewsControlPanelElementsButtonToExpandNews = onView(withIndex(withId(R.id.news_item_material_card_view), 0));
        getNewsControlPanelElementsButtonToDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
        getNewsControlPanelElementsButtonToOkDeleteNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonToEditNews = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
        getNewsControlPanelElementsButtonToSwitchStatusNews = onView(withId(R.id.switcher));
        getNewsControlPanelElementsButtonToFilterNews = onView(withIndex(withId(R.id.filter_news_material_button), 0));
        getNewsControlPanelElementsButtonNewsFilter = onView(withIndex(withId(R.id.filter_button), 0));
        getNewsControlPanelElementsButtonActiveNewsFilter = onView(withIndex(withId(R.id.filter_news_active_material_check_box), 0));
        getNewsControlPanelElementsButtonNotActiveNewsFilter = onView(withIndex(withId(R.id.filter_news_inactive_material_check_box), 0));
        getNewsControlPanelElementsClickDateButtonToCreateStartingDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        getNewsControlPanelElementsClickDateButtonToCreateEndDate = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        getNewsFromPanelCheckVisibilityOfNewsDescription = onView(withIndex(withId(R.id.news_item_description_text_view), 0));
        getNewsControlPanelElementsEmptyFieldErrorCheck = onView(withText("Fill empty fields")).inRoot(withDecorView(Matchers.not(decorView)));
        getNewsControlPanelElementsCheckingErrorFailedSave = onView(withText("Saving failed. Try again later.")).inRoot(withDecorView(Matchers.not(decorView)));
        getNewsControlPanelElementsCheckingErrorWrongPeriod = onView(withText("Wrong period")).inRoot(withDecorView(Matchers.not(decorView)));
        getNewsControlPanelElementsCheckingCreationDateOfNews = onView(withIndex(withId(R.id.news_item_create_date_text_view),0));
        getNewsControlPanelElementsFillingInDateField = onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0));
        getNewsFromPanelCheckVisibilityOfNewsTitle = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
        getCheckingDeleteNews = onView(allOf(withId(R.id.news_item_title_text_view), withText(descriptionAdvertisement)));
        getNewsFromPanelCheckNewsStatus = onView(withIndex(withId(R.id.news_item_published_text_view), 0));

        categoryAdvertisement = "Объявление";
        titleAdvertisement = "Дом";
        descriptionAdvertisement = "Описания нет";
        customCategory = "Продажа";
        fieldEmpty = "";
        specialSymbol = "@}$#!";
        numbersCategory = "12345";
        createDate = "15.04.2026";
        verificationDate = "15.12.2026";
        statusActive = "ACTIVE";
        statusNotActive = "NOT ACTIVE";
        switcherStatusNotActive = "Not active";
    }
}