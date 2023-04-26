package com.boostr.extensions.managers;

import com.boostr.extensions.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class PageManager {

        public static WebDriver driver;

        public LogInPage logInPage;
        public CalendarPage calendarPage;

        public PageManager(WebDriver webDriver) {
                driver = webDriver;
                logInPage = initElements(new LogInPage(this));
                calendarPage = initElements(new CalendarPage(this));  }

        private <T extends Page> T initElements(T page) {
                PageFactory.initElements(driver, page);
                return page;
        }

        public static WebDriver getDriver() {
                return driver;
        }
}
