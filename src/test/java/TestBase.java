import com.boostr.extensions.managers.AppManager;
import com.boostr.extensions.managers.SingletonAppManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

//    @BeforeMethod
//    @Step("Go to the main page")
//    public void before() {
////        app.getNavigationHelper().goToGithubLink();
//    }
//
//    @BeforeMethod(onlyForGroups = "login")
//    @Step("Go to the log in page")
//    public void beforeLogin() {
////        app.getNavigationHelper().goToGithubLink("login/");
//    }
//
//    @AfterMethod()
//    @Step("Log the user out")
//    public void afterMethod() {
////        app.getNavigationHelper().goToGithubLink("logout/");
//
//    }

    @AfterSuite()
    public void tearDown() {
        driver.manage().deleteAllCookies();
        AppManager.getWebDriver().quit();
    }
}
