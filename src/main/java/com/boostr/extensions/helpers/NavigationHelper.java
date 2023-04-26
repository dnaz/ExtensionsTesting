package com.boostr.extensions.helpers;

import com.boostr.extensions.managers.AppManager;
import com.boostr.extensions.managers.PageManager;
import io.qameta.allure.Step;

public class NavigationHelper extends PageManager {
    public NavigationHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Open /login page")
    public void openLoginPage() {
        logInPage.goToLoginPage();
    }

    @Step("Open /calendar page")
    public void openCalendarPage() {
        calendarPage.goToCalendarPage();
    }

    @Step("Create a new Event")
    public void createNewEvent() {
        calendarPage.createEventButtonPress();
        calendarPage.eventMenuClick();
        calendarPage.moreOptionsButtonPress();
    }

    @Step("Create a new Event")
    public boolean isBoostrLogoPresent() {
        return calendarPage.isBoostrLogoPresent();
    }

}
