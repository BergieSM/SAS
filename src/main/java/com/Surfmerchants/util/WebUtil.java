package com.Surfmerchants.util;

import com.Surfmerchants.pageobjects.Superglobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

/**
 * Created by Bergie on 1/15/2016.
 */
public class WebUtil {
    private static final long WAIT_TIME_OUT = 30;

    public static Superglobal goToSuperglobal(WebDriver driver, String pass) {
        String domain;
        String boxSet = System.getenv("boxset");
        String SBUsername = System.getenv("SBUsername");
        if (boxSet != null && (boxSet.equalsIgnoreCase("Prod") || boxSet.equalsIgnoreCase("Production"))) {
            domain = "www.sassieshop.com";
        } else if (boxSet != null && boxSet.equalsIgnoreCase("Stage")) {
            domain = "stage.sassieshop.com";
        } else if (boxSet != null && boxSet.equalsIgnoreCase("UAT")) {
            domain = "uat.sassieshop.com";
        } else if (boxSet != null && SBUsername != null && (boxSet.equalsIgnoreCase("SB") || boxSet.equalsIgnoreCase("Sandbox"))) {
            domain = SBUsername + ".sassiedev.com";
        } else {  //default to DEV
            domain = "www.sassiedev.com";
        }
        String address = "http://sql:" + pass + "@" + domain + "/admin/SuperGlobalAdmin.php/";
        driver.get(address);
        return PageFactory.initElements(driver, Superglobal.class);
    }

    public static void click(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    public static boolean doesElementExist(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getSize().getWidth() > 0;
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void clearAndSendKeys(WebDriver driver, By by, String s) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(s);    //apparently, "!" doesn't work with sendkeys very well.  See https://code.google.com/p/selenium/issues/detail?id=6411 for updated info.
    }

    public static String getElementText(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        return element.getText();
    }

    /**
     * Chromedriver os check based off of https://technicaltesting.wordpress.com/2012/12/07/bundling-chrome-driver-with-your-test-code/
     */
    public static WebDriver getDriver() {
        String browserName = System.getenv("browser");
        WebDriver driver;
        if (browserName != null && browserName.equalsIgnoreCase("Chrome")) {
            if (System.getProperty("os.name").contains("Mac")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver\\mac\\chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver\\windows\\chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static String getPass() {
        String p;
        if (System.getenv("SQLpass") != null) {
            p = System.getenv("SQLpass");
        } else {
            p = JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Enter the sql password", null, JOptionPane.PLAIN_MESSAGE);
        }
        return p;
    }
}
