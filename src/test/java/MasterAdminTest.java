import com.Surfmerchants.categories.Minor;
import com.Surfmerchants.pageobjects.MasterAdmin;
import com.Surfmerchants.pageobjects.Superglobal;
import com.Surfmerchants.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/15/2016.
 */
public class MasterAdminTest {
    String PASS;
    WebDriver DRIVER;

    @Before
    public void setUp() {
        DRIVER = WebUtil.getDriver();
        PASS = WebUtil.getPass();
    }

    @Category({Minor.class})
    @Test
    public void masterAdminPageNavShouldBeSuccessful() {
        Superglobal superglobal = WebUtil.goToSuperglobal(DRIVER, PASS);
        MasterAdmin masterAdmin = Superglobal.goToMasterAdmin(DRIVER);
        Assert.assertTrue("Master Admin Header should exist if signed in", MasterAdmin.headerShouldExist(DRIVER));
    }

    @After
    public void tearDown() {
        DRIVER.quit();
    }
}
