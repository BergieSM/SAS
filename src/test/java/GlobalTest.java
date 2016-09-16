import com.Surfmerchants.categories.Minor;
import com.Surfmerchants.pageobjects.Global;
import com.Surfmerchants.pageobjects.Superglobal;
import com.Surfmerchants.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jonathan on 8/15/2016.
 */
public class GlobalTest {
    String pass;
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebUtil.getDriver();
        pass = WebUtil.getPass();
    }

    @Category({Minor.class})
    @Test
    public void globalPageNavShouldBeSuccessful() {
        Superglobal superglobal = WebUtil.goToSuperglobal(driver, pass);
        Global global = Superglobal.goToMSPGlobalPage(driver, "2_qa");
        Assert.assertTrue("Global Header should exist if signed in", Global.headerShouldExist(driver));
    }

    @Test
    public void selectClientTestShouldBeSuccessful() {
        Superglobal superglobal = WebUtil.goToSuperglobal(driver, pass);
        Global global = Superglobal.goToMSPGlobalPage(driver, "2_qa");
        WebElement select = driver.findElement(By.id("GAH_ClientID"));
        select.click();
        WebUtil.selectOptionByText(driver, By.id("GAH_ClientID"), "Bergie");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
