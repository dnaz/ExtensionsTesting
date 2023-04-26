package com.boostr.extensions.helpers;

import com.boostr.extensions.managers.AppManager;
import com.boostr.extensions.managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserHelper extends PageManager {
    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Input the test user's email {0}")
    public void inputEmail(String login) {
        logInPage.loginInput(login);
        logInPage.nextButtonPress();
    }

    @Step("Input the password")
    public void inputPassword(String pass) {
        logInPage.passwordInput(pass);
        logInPage.nextButtonPress();
        logInPage.waitForLogIn();
    }


}