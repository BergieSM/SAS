package com.Surfmerchants.pageobjects;

import com.Surfmerchants.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Jonathan on 1/15/2016.
 */
public class Superglobal {

    /**
     * This test returns whether the browser navigated to the super global page correctly by testing for the presence of the SuperGlobal hyperlink.
     *
     * @param driver The currently active WebDriver
     * @return boolean using WebUtil's .doesElementExist method
     */
    public static boolean doesSuperGlobalLinkExist(WebDriver driver) {
        superglobalWait(driver);
        return WebUtil.doesElementExist(driver, By.partialLinkText("SuperGlobal"));
    }

    public static AdminHomePage goToMSPAdminHomePage(WebDriver driver, String mspDirectoryName) {
        superglobalWait(driver);
        WebElement mspRow = getMSPRow(driver, mspDirectoryName);
        WebUtil.click(driver, By.cssSelector("a[href*='expressadminlogin.php?dirname=" + mspDirectoryName + "']"));
        return PageFactory.initElements(driver, AdminHomePage.class);
    }

    public static Global goToMSPGlobalPage(WebDriver driver, String mspDirectoryName) {
        superglobalWait(driver);
        WebElement mspRow = getMSPRow(driver, mspDirectoryName);
        WebUtil.click(driver, By.linkText("Global"));
        return PageFactory.initElements(driver, Global.class);
    }

    /*public static MSAdmin goToMSPMSAdminPage(WebDriver driver, String mspDirectoryName){
        superglobalWait(driver);
        WebElement mspRow = getMSPRow(driver, mspDirectoryName);
        WebUtil.click(driver, By.partialLinkText("MSAdmin"));
        return PageFactory.initElements(driver,MSAdmin.class);
    }*/ // TODO: 8/15/2016 Make MSAdmin Pageobject

    public static List<WebElement> getAllMSPRows(WebDriver driver) {
        superglobalWait(driver);
        List<WebElement> MSPList = WebUtil.getListOfElements(driver, By.tagName("tr"));
        return MSPList;
    }

    /**
     * Retrieving the WebElement of the row of links for a given MSP.
     *
     * @param driver           The currently active WebDriver
     * @param mspDirectoryName The MSP Directory Name (Ex: 2_qa)
     * @return WebElement containing all of the MSP's links from superglobal.
     */
    public static WebElement getMSPRow(WebDriver driver, String mspDirectoryName) throws IndexOutOfBoundsException {
        superglobalWait(driver);
        List<WebElement> MSPRows = getAllMSPRows(driver);
        for (WebElement MSPRow : MSPRows) {
            List<WebElement> TDs = MSPRow.findElements(By.tagName("td"));
            for (WebElement TD : TDs) {
                if (TD.getText().contains(mspDirectoryName)) {
                    return MSPRow;
                }
            }
        }
        throw new NoSuchElementException("Row was not found by identifier" + mspDirectoryName);
    }

    public static MasterAdmin goToMasterAdmin(WebDriver driver) {
        superglobalWait(driver);
        WebUtil.click(driver, By.linkText("Master Admin"));
        return PageFactory.initElements(driver, MasterAdmin.class);
    }

    public static void superglobalWait(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.partialLinkText("SuperGlobal"));
    }
}
