package com.boostr.extensions.pages;

import com.boostr.extensions.managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends Page {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement logInField;
    @FindBy(xpath = "//*[contains(text(),'Next')]/..")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    public LogInPage(PageManager pages) {
        super(pages);
    }

    @Step("Navigate to login page")
    public void goToLoginPage() {
        driver.navigate().to("https://accounts.google.com/");
    }

    @Step("Login as {0}")
    public void loginInput(String text) {
        wait.until(ExpectedConditions.visibilityOf(logInField));
        logInField.sendKeys(text);
    }

    @Step("Entered password {0}")
    public void passwordInput(String text) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(text);
    }

    @Step("Pressing the Submit button")
    public void nextButtonPress() {
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    @Step("Waiting for successful login")
    public void waitForLogIn() {
        wait.until(ExpectedConditions.urlContains("myaccount.google.com"));
    }

}
