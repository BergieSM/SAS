package com.Surfmerchants.util;

import com.Surfmerchants.pageobjects.Global;
import com.Surfmerchants.pageobjects.Superglobal;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/15/2016.
 */
public class Recalc {
    /**
     * This should navigate to the survey in question on global and run a recalc on that one survey.
     *
     * @param driver
     * @param msp
     * @param client
     * @param survey
     */
    public static void recalcOneSurvey(WebDriver driver, String msp, String client, String survey) {
        Superglobal sg = WebUtil.startFreshSuperglobal();
        //go to Global for the MSP
        Global global = Superglobal.goToMSPGlobalPage(driver, msp);
    }

    /**
     * This should navigate to the survey in question on global and run a recalc on all surveys for that client, sequentially.
     *
     * @param driver
     * @param msp
     * @param client
     */
    public static void recalcOneClient(WebDriver driver, String msp, String client) {
        Superglobal sg = WebUtil.startFreshSuperglobal();
        Global global = Superglobal.goToMSPGlobalPage(driver, msp);
    }


}
