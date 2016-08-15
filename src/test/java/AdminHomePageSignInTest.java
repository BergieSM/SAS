import com.Surfmerchants.categories.Major;
import com.Surfmerchants.pageobjects.AdminHomePage;
import com.Surfmerchants.pageobjects.Superglobal;
import com.Surfmerchants.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 1/15/2016.
 */
public class AdminHomePageSignInTest {
    String pass;
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebUtil.getDriver();
        pass = WebUtil.getPass();
    }

    @Category({Major.class})
    @Test
    public void adminHomePageNavShouldBeSuccessful() {
        Superglobal superglobal = WebUtil.goToSuperglobal(driver, pass);
        AdminHomePage adminHomePage = Superglobal.goToMSPAdminHomePage(driver, "2_qa");
        Assert.assertTrue("Admin Link should exist if signed in", adminHomePage.adminLinkShouldExist(driver));
        Assert.assertTrue("Admin Link should point to correct MSP if signed in correctly", adminHomePage.adminLinkShouldBeCorrectMSP(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
