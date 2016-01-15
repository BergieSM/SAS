import com.Surfmerchants.categories.Critical;
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
public class SuperglobalSignInTest {
    String pass;
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebUtil.getDriver();
        pass = WebUtil.getPass();
    }

    @Category({Critical.class})
    @Test
    public void superglobalLoginShouldBeSuccessful() {
        Superglobal superglobal = WebUtil.goToSuperglobal(driver, pass);
        Assert.assertTrue("SuperGlobal link should exist if signed in", Superglobal.doesSuperGlobalLinkExist(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
