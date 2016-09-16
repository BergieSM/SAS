package com.Surfmerchants.pageobjects;

import com.Surfmerchants.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Jonathan on 8/15/2016.
 */
public class MasterAdmin {
    String EXPECTED_URL = "/admin/MSAdmin.php";
    String HEADER_TEXT = "Master Admin Page";


    public static void masterAdminWait(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector(".blue16bold"));
    }

    public static WebElement getRowByDirectoryName(WebDriver driver, String dName) throws NoSuchElementException {
        masterAdminWait(driver);
        List<WebElement> allTR = WebUtil.getListOfElements(driver, By.tagName("tr"));
        int trCount = allTR.size();
        List<WebElement> allDirectoryNames = driver.findElements(By.xpath("html/body/div/table/tbody/tr[*]/td[4]"));
        System.out.print(allDirectoryNames);    //this should be the directory names for each, starting from tr[3]
        for (WebElement aTR : allTR) {
            List<WebElement> TDs = aTR.findElements(By.tagName("td"));
            for (WebElement TD : TDs) {
                if (TD.getText() == dName) {
                    return aTR;
                }
            }
        }
        throw new NoSuchElementException("Row was not found by identifier" + dName);
    }

    public static String basicGet(WebDriver driver, String identifier, int column) {
        masterAdminWait(driver);
        WebElement row = null;
        try {
            row = getRowByDirectoryName(driver, identifier);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return row.findElements(By.tagName("td")).get(column).getText();
    }

    public static String getCompanyID(WebDriver driver, String identifier) {
        return basicGet(driver, identifier, 0);
    }

    public static String getCompanyName(WebDriver driver, String identifier) {
        return basicGet(driver, identifier, 1);
    }

    public static String getContactName(WebDriver driver, String identifier) {
        return basicGet(driver, identifier, 2);
    }

    public static String getDirectoryName(WebDriver driver, String identifier) {
        return basicGet(driver, identifier, 3);
    }

    public static boolean headerShouldExist(WebDriver driver) {
        masterAdminWait(driver);
        return WebUtil.doesElementExist(driver, By.cssSelector(".blue16bold"));
    }
}