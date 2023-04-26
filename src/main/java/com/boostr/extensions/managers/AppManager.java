package com.boostr.extensions.managers;

import com.boostr.extensions.helpers.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AppManager {
    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private static WebDriver driver;

    AppManager() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions()
//                .addArguments("--headless")
                .addArguments("start-maximized")
                .addArguments("--disable-cache")
                .addArguments("--lang=en")
                .addExtensions(new File("src/test/resources/extensions/calendar.crx"))
                .addArguments("--user-data-dir=c:\\Users\\dmytr\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\Default");
//                .setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        userHelper = new UserHelper();
        navigationHelper = new NavigationHelper();
    }


    public static WebDriver getWebDriver() {
        return driver;
    }

    //
    public UserHelper getUserHelper() {
        return userHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
