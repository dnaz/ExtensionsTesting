import com.boostr.extensions.utils.CustomerTestListener;
import com.boostr.extensions.utils.PropertyLoader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomerTestListener.class)
public class CalendarTest  extends TestBase{

    @Test(groups = "calendar")
    @Description("Verify boostr login is present")
    public void calendarExtensionExists() {
        app.getNavigationHelper().openLoginPage();
        app.getUserHelper().inputEmail(PropertyLoader.loadProperty("google.login"));
        app.getUserHelper().inputPassword(PropertyLoader.loadProperty("google.pass"));
        app.getNavigationHelper().openCalendarPage();
        app.getNavigationHelper().createNewEvent();
        Assert.assertEquals(app.getNavigationHelper().isBoostrLogoPresent(),true);
    }
}
