package com.Surfmerchants.pageobjects;

import com.Surfmerchants.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 1/15/2016.
 */
public class Superglobal {

    public static boolean doesSuperGlobalLinkExist(WebDriver driver) {
        return WebUtil.doesElementExist(driver, By.partialLinkText("SuperGlobal"));
    }
}
