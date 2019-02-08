package com.briteErp.tests.functional_tests;

import com.briteErp.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.briteErp.utilities.ApplicationConstants.ACCESS_ERROR_MESSAGE;
import static com.briteErp.utilities.BrowserUtils.waitForPageToLoad;
import static org.testng.Assert.assertEquals;


public class OrdersQuotations extends TestBase{ //Avsar

    @Test
    public void sortHeader1() throws InterruptedException {
        extentLogger = report.createTest("Home Page");
        pages.login().BriteErpLink.click();

        extentLogger.info("Main Login");
        pages.login().login(ConfigurationReader.getProperty("SMUser1"),
                ConfigurationReader.getProperty("SMPass1"));

        extentLogger.info("Go to Sales");
        pages.quotationsPage().salesLink.click();
        Thread.sleep(5000);

        extentLogger.info("Active Header Match");
        BrowserUtils.verifyElementDisplayed(pages.quotationsPage().ActiveHeader);
        assertEquals(pages.quotationsPage().ActiveHeader.getText(), ApplicationConstants.ACTIVE_HEADER_ORDERS_QUOTATIONS);
    }

}
