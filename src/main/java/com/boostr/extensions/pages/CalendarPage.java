package com.boostr.extensions.pages;

import com.boostr.extensions.managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends Page {

    @FindBy(xpath = "//div[contains(text(),'Create')]/..")
    private WebElement createEventButton;
    @FindBy(xpath = "//div[contains(text(),'Event')]/..")
    private WebElement eventMenuItem;
    @FindBy(xpath = "//*[contains(text(),'More options')]/..")
    private WebElement moreOptionsButton;
    @FindBy(xpath = "//div[@class='boostr-logo']")
    private WebElement boostrLogo;

    public CalendarPage(PageManager pages) {
        super(pages);
    }

    @Step("Navigate to calendar page")
    public void goToCalendarPage() {
        driver.navigate().to("https://calendar.google.com/calendar?authuser=0");
    }

    @Step("Pressing the Create event button")
    public void createEventButtonPress() {
        wait.until(ExpectedConditions.visibilityOf(createEventButton));
        createEventButton.click();
    }

    @Step("Clicking on Event menu item")
    public void eventMenuClick() {
        wait.until(ExpectedConditions.visibilityOf(eventMenuItem));
        eventMenuItem.click();
    }

    @Step("Pressing the More options  button")
    public void moreOptionsButtonPress() {
        wait.until(ExpectedConditions.visibilityOf(moreOptionsButton));
        moreOptionsButton.click();
    }

    @Step("Verify Boostr Logo presence")
    public boolean isBoostrLogoPresent() {
        wait.until(ExpectedConditions.visibilityOf(moreOptionsButton));
      return  moreOptionsButton.isDisplayed();
    }

}
