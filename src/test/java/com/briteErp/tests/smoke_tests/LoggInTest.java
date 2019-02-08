/*
Created by: Mamura Rizaeva
Description: This is login smoke test
 */
package com.briteErp.tests.smoke_tests;


import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;
import static com.briteErp.utilities.BrowserUtils.waitForPageToLoad;

public class LoggInTest extends TestBase {

    @Test
    public void testLoggin() throws InterruptedException {

        extentLogger = report.createTest("Sales manager Log In Performance");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailMan"),
                ConfigurationReader.getProperty("passwordMan"));
        waitForPageToLoad(8000);

        extentLogger.info("Clicking on Sales Module");
        pages.getSmokeTestHomePage().salesModule.click();
        waitForPageToLoad(8000);

        extentLogger.info("Logging out");
        pages.getSmokeTestHomePage().salesManager.click();
        waitForPageToLoad(5000);
        pages.getSmokeTestHomePage().logout.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));
        waitForPageToLoad(8000);

        extentLogger.info("Clicking on Sales Module");
        pages.getSmokeTestHomePage().salesModule.click();
        Thread.sleep(5000);
    }
}
