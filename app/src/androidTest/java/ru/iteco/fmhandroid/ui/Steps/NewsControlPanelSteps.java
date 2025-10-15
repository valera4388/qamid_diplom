package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.categoryAdvertisement;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.customCategory;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.descriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.fieldEmpty;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.numbersCategory;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.specialSymbol;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.titleAdvertisement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage;

public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();

    public void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonControlPanel
                .perform(click());
    }

    public void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        newsControlPanelPage.getNewsControlPanelElementsAddNews
                .perform(click());
    }

    public void fillTitleCreatingNews(String text) {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        newsControlPanelPage.getNewsControlPanelElementsButtonTitleCreatingNews
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        newsControlPanelPage.getNewsControlPanelElementsButtonTimeCreatingNews
                .perform(click());
    }

    public void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkTimeCreatingNews
                .perform(click());
    }

    public void fillDescriptionCreatingNews(String text) {
        Allure.step("Ввести в поле Описание описание новости");
        newsControlPanelPage.getNewsControlPanelElementsDescriptionCreatingNews
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        newsControlPanelPage.getNewsControlPanelElementsButtonSaveCreatingNews
                .perform(scrollTo(), click());
    }

    public void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        newsControlPanelPage.getNewsControlPanelElementsCategoryText.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "15.12.2026";

    public void clickButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextYear));
    }

    static String startDate = "15.12.2026";

    public void clickDateButtonToCreateStartingDate() {
        Allure.step("В поле Дата выбрать начальную дату диапазона поиска");
        newsControlPanelPage.getNewsControlPanelElementsClickDateButtonToCreateStartingDate
                .perform(replaceText(startDate));
    }

    static String endDate = "15.12.2026";

    public void clickDateButtonToCreateEndDate() {
        Allure.step("В поле Дата выбрать конечную дату диапазона поиска");
        newsControlPanelPage.getNewsControlPanelElementsClickDateButtonToCreateEndDate
                .perform(replaceText(endDate));
    }

    public void manualInputTime() {
        Allure.step("Вручную ввести время публикации новости");
        newsControlPanelPage.getNewsControlPanelElementsInputTime
                .perform(click());
    }

    public void clickButtonSortingNews() {
        Allure.step("Нажать кнопку Сортировать новости в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonSortingControlPanel
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать кнопку Развернуть новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToExpandNews
                .perform(click());
    }

    public void clickButtonToDeleteNews() {
        Allure.step("Нажать кнопку Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToDeleteNews
                .perform(click());
    }

    public void clickButtonToOkDeleteNews() {
        Allure.step("Нажать кнопку ОК Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToOkDeleteNews
                .perform(click());
    }

    public void clickButtonToEditNews() {
        Allure.step("Нажать кнопку Редактировать новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToEditNews
                .perform(click());
    }

    public void clickButtonToSwitchStatusNews() {
        Allure.step("Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .perform(click());
    }

    public void clickButtonToSetUpNewsFilter() {
        Allure.step("Нажать кнопку настройка Фильтра новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonToFilterNews
                .perform(click());
    }
    public void clickButtonNewsFilter() {
        Allure.step("Нажать кнопку Фильтра новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonNewsFilter
                .perform(click());
    }
    public void clickButtonActiveNewsFilter() {
        Allure.step("Нажать/снять галочку Фильтра Активных новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonActiveNewsFilter
                .perform(click());
    }
    public void clickButtonNotActiveNewsFilter() {
        Allure.step("Нажать/снять галочку Фильтра Неактивных новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonNotActiveNewsFilter
                .perform(click());
    }

    public static String getCategoryAdvertisement() {
        return categoryAdvertisement;
    }

    public static String getTitleAdvertisement() {
        return titleAdvertisement;
    }

    public static String getDescriptionAdvertisement() {
        return descriptionAdvertisement;
    }

    public static String getCustomCategory() {
        return customCategory;
    }

    public static String getNumbersCategory() {
        return numbersCategory;
    }

    public static String getSpecialSymbol() {
        return specialSymbol;
    }

    public static String getFieldEmpty(){
        return fieldEmpty;
    }
}