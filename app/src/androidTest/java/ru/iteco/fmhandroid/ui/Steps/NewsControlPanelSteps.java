package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.categoryAdvertisement;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.customCategory;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.descriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.fieldEmpty;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.numbersCategory;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.specialSymbol;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.titleAdvertisement;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.createDate;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.verificationDate;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.statusActive;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.statusNotActive;
import static ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage.switcherStatusNotActive;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.PageObject.NewsControlPanelPage;

public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();

    public void clickButtonControlPanel() {
        Allure.step(" Нажать на кнопку Панель управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonControlPanel
                .perform(click());
    }

    public void clickAddNews() {
        Allure.step(" Нажать на кнопку Добавить новость");
        newsControlPanelPage.getNewsControlPanelElementsAddNews
                .perform(click());
    }

    public void fillTitleCreatingNews(String text) {
        Allure.step(" Ввести в поле Заголовок заголовок новости");
        newsControlPanelPage.getNewsControlPanelElementsButtonTitleCreatingNews
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonTimeCreatingNews() {
        Allure.step(" В поле Время выбрать время");
        newsControlPanelPage.getNewsControlPanelElementsButtonTimeCreatingNews
                .perform(click());
    }

    public void clickButtonOkTimeCreatingNews() {
        Allure.step(" Нажать кнопку ОК Время");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkTimeCreatingNews
                .perform(click());
    }

    public void fillDescriptionCreatingNews(String text) {
        Allure.step(" Ввести в поле Описание описание новости");
        newsControlPanelPage.getNewsControlPanelElementsDescriptionCreatingNews
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonSaveCreatingNews() {
        Allure.step(" Нажать на кнопку Сохранить новость");
        newsControlPanelPage.getNewsControlPanelElementsButtonSaveCreatingNews
                .perform(scrollTo(), click());
    }

    public void fillInNewsCategoryField(String text) {
        Allure.step(" Поле категория - ввод данных");
        newsControlPanelPage.getNewsControlPanelElementsCategoryText.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "15.12.2026";

    public void clickButtonDateCreatingNextDate() {
        Allure.step(" В поле Дата публикации выбрать дату будущего года");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextYear));
    }

    static String startDate = "15.12.2026";

    public void clickDateButtonToCreateStartingDate() {
        Allure.step(" В поле Дата выбрать начальную дату диапазона поиска");
        newsControlPanelPage.getNewsControlPanelElementsClickDateButtonToCreateStartingDate
                .perform(replaceText(startDate));
    }

    static String endDate = "15.12.2026";

    public void clickDateButtonToCreateEndDate() {
        Allure.step(" В поле Дата выбрать конечную дату диапазона поиска");
        newsControlPanelPage.getNewsControlPanelElementsClickDateButtonToCreateEndDate
                .perform(replaceText(endDate));
    }

    public void manualInputTime() {
        Allure.step(" Вручную ввести время публикации новости");
        newsControlPanelPage.getNewsControlPanelElementsInputTime
                .perform(click());
    }

    public void clickButtonSortingNews() {
        Allure.step(" Нажать кнопку Сортировать новости в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonSortingControlPanel
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step(" Нажать кнопку Развернуть новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToExpandNews
                .perform(click());
    }

    public void clickButtonToDeleteNews() {
        Allure.step(" Нажать кнопку Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToDeleteNews
                .perform(click());
    }

    public void clickButtonToOkDeleteNews() {
        Allure.step(" Нажать кнопку ОК Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToOkDeleteNews
                .perform(click());
    }

    public void clickButtonToEditNews() {
        Allure.step(" Нажать кнопку Редактировать новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToEditNews
                .perform(click());
    }

    public void clickButtonToSwitchStatusNews() {
        Allure.step(" Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .perform(click());
    }

    public void clickButtonToSetUpNewsFilter() {
        Allure.step(" Нажать кнопку настройка Фильтра новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonToFilterNews
                .perform(click());
    }
    public void clickButtonNewsFilter() {
        Allure.step(" Нажать кнопку Фильтра новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonNewsFilter
                .perform(click());
    }
    public void clickButtonActiveNewsFilter() {
        Allure.step(" Нажать/снять галочку Фильтра Активных новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonActiveNewsFilter
                .perform(click());
    }
    public void clickButtonNotActiveNewsFilter() {
        Allure.step(" Нажать/снять галочку Фильтра Неактивных новостей в Панели управления.");
        newsControlPanelPage.getNewsControlPanelElementsButtonNotActiveNewsFilter
                .perform(click());
    }
    public void checkVisibilityOfCreatedNewsItem() {
        Allure.step(" Проверить созание новости/элемент созданной новости на видимость.");
        newsControlPanelPage.getNewsFromPanelCheckVisibilityOfNewsDescription
                .check(matches(withText(descriptionAdvertisement)));
    }
    public void emptyFieldErrorCheck() {
        Allure.step(" Проверить ошибку пустого поля.");
        newsControlPanelPage.getNewsControlPanelElementsEmptyFieldErrorCheck
                .check(matches(isDisplayed()));
        pressBack();
    }
    public void checkingErrorFailedSave() {
        Allure.step(" Проверить ошибку неудачного сохранения.");
        newsControlPanelPage.getNewsControlPanelElementsCheckingErrorFailedSave
                .check(matches(isDisplayed()));
        pressBack();
    }

    public void checkingErrorWrongPeriod() {
        Allure.step(" Проверить ошибку неправильно заданного периода дат фильтрации новостей.");
        newsControlPanelPage.getNewsControlPanelElementsCheckingErrorWrongPeriod
                .check(matches(isDisplayed()));
        pressBack();
    }
    public void checkingCreationDateOfNews() {
        Allure.step(" Проверить дату созданной новости.");
        newsControlPanelPage.getNewsControlPanelElementsCheckingCreationDateOfNews
                .check(matches(withText(createDate)));
    }
    public void checkingSortingDateOfNews() {
        Allure.step(" Проверить сортировку новостей по дате.");
        newsControlPanelPage.getNewsControlPanelElementsFillingInDateField
                .check(matches(withText(verificationDate)));
    }
    public void checkingFilterDateOfNews() {
        Allure.step(" Проверить фильтрацию новостей по дате.");
        newsControlPanelPage.getNewsControlPanelElementsFillingInDateField
                .check(matches(withText(verificationDate)));
    }
    public void checkingCreatedNewsDescriptionFilledWithNumbers() {
        Allure.step(" Проверить созание новости описание заполнено цифрами.");
        newsControlPanelPage.getNewsFromPanelCheckVisibilityOfNewsDescription
                .check(matches(withText(numbersCategory)));
    }
    public void checkingCreatedNewsDescriptionFilledWithSpecialSymbol() {
        Allure.step(" Проверить созание новости описание заполнено спец символами.");
        newsControlPanelPage.getNewsFromPanelCheckVisibilityOfNewsDescription
                .check(matches(withText(specialSymbol)));
    }
    public void checkingEditingDateOfNews() {
        Allure.step(" Проверить фильтрацию новостей по дате.");
        newsControlPanelPage.getNewsControlPanelElementsFillingInDateField
                .check(matches(withText(verificationDate)));
    }
    public void checkingCreatedNewsTitleFilledWithSpecialSymbol() {
        Allure.step(" Проверить созание новости заголовок заполнен спец символами.");
        newsControlPanelPage.getNewsFromPanelCheckVisibilityOfNewsTitle
                .check(matches(withText(specialSymbol)));
    }
    public void checkingCreatedNewsTitleFilledWithNumbers() {
        Allure.step(" Проверить созание новости заголовок заполнен спец символами.");
        newsControlPanelPage.getNewsFromPanelCheckVisibilityOfNewsTitle
                .check(matches(withText(numbersCategory)));
    }
    public void checkingDeleteNews() {
        Allure.step(" Проверить уаление новости.");
        newsControlPanelPage.getCheckingDeleteNews
                .check(doesNotExist());
    }
    public void checkingNewsStatusActive() {
        Allure.step(" Проверить статус новости активной новости.");
        newsControlPanelPage.getNewsFromPanelCheckNewsStatus
                .check(matches(withText(statusActive)));
    }
    public void checkingNewsStatusNotActive() {
        Allure.step(" Проверить статус новости не активной новости.");
        newsControlPanelPage.getNewsFromPanelCheckNewsStatus
                .check(matches(withText(statusNotActive)));
    }
    public void checkingStatusChangeOfNews() {
        Allure.step(" Проверить смену статуса новости (передвинутый рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .check(matches(withText(switcherStatusNotActive)))
                .check(matches(isDisplayed()));
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