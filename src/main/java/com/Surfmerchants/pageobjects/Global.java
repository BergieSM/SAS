package com.Surfmerchants.pageobjects;

import com.Surfmerchants.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jonathan on 8/15/2016.
 */
public class Global {

    public static void globalWait(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector(".blue16bold"));
    }

    public static void selectClient(WebDriver driver, String clientIdentifier) {
        WebUtil.waitForElementVisible(driver, By.id("GAH_ClientID"));
        WebElement select = driver.findElement(By.id("GAH_ClientID"));
        //WebUtil.click(driver, By.id("GAH_ClientID"));

    }

    public static Boolean headerShouldExist(WebDriver driver) {
        globalWait(driver);
        return WebUtil.doesElementExist(driver, By.cssSelector(".blue16bold"));
    }
}
