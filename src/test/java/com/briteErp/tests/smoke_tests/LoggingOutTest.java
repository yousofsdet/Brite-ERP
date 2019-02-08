/*
Created by: Mamura Rizaeva
Description: This is log out smoke test
 */
package com.briteErp.tests.smoke_tests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.briteErp.utilities.BrowserUtils.waitForPageToLoad;

public class LoggingOutTest extends TestBase {
    @Test
    public void testLoggingOutFunctionality() throws InterruptedException {
        extentLogger = report.createTest("Sales manager log out");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),
                ConfigurationReader.getProperty("passwordUser"));
        waitForPageToLoad(8000);

        extentLogger.info("Clicking on Sales Module");
        pages.getSmokeTestHomePage().salesModule.click();
        waitForPageToLoad(8000);

        extentLogger.info("Logging out");
        pages.getSmokeTestHomePage().salesUser4.click();
        waitForPageToLoad(5000);
        pages.getSmokeTestHomePage().logout.click();

        extentLogger.info("Verifying Login | Website localhost page loaded");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.LOGIN_PAGE_TITLE);

    }
}
