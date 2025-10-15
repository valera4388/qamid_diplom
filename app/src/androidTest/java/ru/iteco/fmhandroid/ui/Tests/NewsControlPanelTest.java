package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getCategoryAdvertisement;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getCustomCategory;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getDescriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getFieldEmpty;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getNumbersCategory;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getSpecialSymbol;
import static ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps.getTitleAdvertisement;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
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
import ru.iteco.fmhandroid.ui.Steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.Steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для функционального тестирования Панели управления новостей")
public class NewsControlPanelTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();

    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
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
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }


    @Test
    @DisplayName("Создание новости на странице Панель управления с категорей новости Объявление (ID - 18")
    public void creationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Описания нет")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Проверка даты создания новости (ID - 19")
    public void checkingCreationDateNews() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_create_date_text_view),0)).check(matches(withText("15.04.2026")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Создание новости, поле категория оставлено пустым при создании новости (ID - 20)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле категория заполнено собственным названием (ID - 21)")
    public void creationNewsEmptyCategoryFieldInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCustomCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле категория заполнено спец символами (ID - 22)")
    public void fieldCategoryConsistsOfSpecialSymbol() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getSpecialSymbol());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле категория заполнено цифрами (ID - 23)")
    public void fieldCategoryConsistsOfNumbers() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getNumbersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле заголовок оставлено пустым при создании новости (ID - 24)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getFieldEmpty());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле заголовок заполнено спецсимволами (ID - 25)")
    public void fieldTitleConsistsOfSpecialSymbol() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getSpecialSymbol());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Описания нет")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Создание новости, поле заголовок заполнено цифрами (ID - 26)")
    public void fieldTitleConsistsOfNumbers() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getNumbersCategory());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Описания нет")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Создание новости, поле дата оставлено пустым при создании новости (ID - 27)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле время оставлено пустым при создании новости (ID - 28)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Создание новости, поле время заполняется ручным вводом валидными данными (ID - 29")
    public void manualTimeInputInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.manualInputTime();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Описания нет")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Создание новости, поле описание оставлено пустым при создании новости (ID - 31)")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getFieldEmpty());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Нажать кнопку сортировки новостей в панели управления новостей (ID - 32)")
    public void sortingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonSortingNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.12.2026")));
    }

    @Test
    @DisplayName("Удалить новость (ID - 33)")
    public void deletingNews() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Описания нет")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
        onView(allOf(withId(R.id.news_item_title_text_view), withText("Описания нет"))).check(doesNotExist());
    }

    @Test
    @DisplayName("Смена статуса новости с актиной на не активную (ID - 34)")
    public void changingStatusNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.clickButtonToSwitchStatusNews();
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    @Test
    @DisplayName("Фильтрация не активных новостей (ID - 36)")
    public void filterNewsNotActiveInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToSetUpNewsFilter();
        newsControlPanelSteps.clickButtonActiveNewsFilter();
        newsControlPanelSteps.clickButtonNewsFilter();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
    }

    @Test
    @DisplayName("Фильтрация активных новостей (ID - 37)")
    public void filterNewsActiveInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToSetUpNewsFilter();
        newsControlPanelSteps.clickButtonNotActiveNewsFilter();
        newsControlPanelSteps.clickButtonNewsFilter();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("ACTIVE")));
    }

    @Test
    @DisplayName("Фильтрация по дате публикации (фильтрация по выбранному диапазону) (ID - 38)")
    public void filterNewsByDateInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToSetUpNewsFilter();
        newsControlPanelSteps.clickDateButtonToCreateStartingDate();
        newsControlPanelSteps.clickDateButtonToCreateEndDate();
        newsControlPanelSteps.clickButtonNewsFilter();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.12.2026")));
    }

    @Test
    @DisplayName("Фильтрация по дате публикации (фильтрация по начальной дате) (ID - 39)")
    public void filterNewsByStartDateInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToSetUpNewsFilter();
        newsControlPanelSteps.clickDateButtonToCreateStartingDate();
        newsControlPanelSteps.clickButtonNewsFilter();
        onView(withText("Wrong period"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Фильтрация по дате публикации (фильтрация по конечной дате) (ID - 40)")
    public void filterNewsByEndDateInNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToSetUpNewsFilter();
        newsControlPanelSteps.clickDateButtonToCreateEndDate();
        newsControlPanelSteps.clickButtonNewsFilter();
        onView(withText("Wrong period"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле категория оставлено пустым при редактировании новости (ID - 41)")
    public void editingNewsCategoryFieldEmpty() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getFieldEmpty());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле категория заполненяем произвольным названием (ID - 42)")
    public void editingNewsCustomCategoryFieldInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCustomCategory());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле категория заполняем спец символами (ID - 43)")
    public void editingNewsSpecialSymbolCategoryFieldInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getSpecialSymbol());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле категория заполняем цифрами (ID - 44)")
    public void editingNewsNumbersCategoryFieldInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getNumbersCategory());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле заголовок оставляем пустым при редактировании новости (ID - 45)")
    public void editingNewsTitleFieldEmptyInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getFieldEmpty());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле заголовок заполненяем спец символами (ID - 46)")
    public void editingNewsTitleFieldSpecialSymbolInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillTitleCreatingNews(getSpecialSymbol());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(withText("@}$#!")));
    }

    @Test
    @DisplayName("Редактирование новости, поле заголовок заполненяем цифрами (ID - 47)")
    public void editingNewsTitleFieldNumbersInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillTitleCreatingNews(getNumbersCategory());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(withText("12345")));
    }

    @Test
    @DisplayName("Редактирование новости, изменяем значение в поле дата (ID - 48)")
    public void editingNewsDateInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.12.2026")));
    }

    @Test
    @DisplayName("Редактирование новости, поле описание оставляем пустым при редактировании новости (ID - 52)")
    public void editingNewsDescriptionFieldEmptyInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getFieldEmpty());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости, поле описание заполненяем спец символами (ID - 53)")
    public void editingNewsDescriptionFieldSpecialSymbolInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getSpecialSymbol());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("@}$#!")));
    }

    @Test
    @DisplayName("Редактирование новости, поле описание заполненяем цифрами (ID - 54)")
    public void editingNewsDescriptionFieldNumberInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 3000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getNumbersCategory());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("12345")));
    }
}