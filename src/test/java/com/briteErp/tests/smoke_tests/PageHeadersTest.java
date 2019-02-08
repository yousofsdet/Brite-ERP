/*
Created by: Mamura Rizaeva
Description: This is the page headers smoke test
 */
package com.briteErp.tests.smoke_tests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.briteErp.utilities.BrowserUtils.waitForPageToLoad;

public class PageHeadersTest extends TestBase {
    @Test
    public void testPageHeaders() throws InterruptedException {
        extentLogger = report.createTest("Checking Page Headers");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailMan"),
                ConfigurationReader.getProperty("passwordMan"));
        waitForPageToLoad(8000);

        extentLogger.info("Clicking on Sales Module");
        pages.getSmokeTestHomePage().salesModule.click();
        Thread.sleep(8000);

        extentLogger.info("Getting all tab headers and verifying.");
        Assert.assertEquals(pages.getSmokeTestHomePage().quatationsHeader.getText(), ApplicationConstants.QUOTATIONS_HEADER);

        Thread.sleep(5000);
        pages.getSmokeTestHomePage().orders.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().ordersHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().ordersHeader.getText(), ApplicationConstants.ORDERS_HEADER);

        Thread.sleep(5000);
        pages.getSmokeTestHomePage().customers.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().customersHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().customersHeader.getText(), ApplicationConstants.CUSTOMERS_HEADER);

        Thread.sleep(5000);
        pages.getSmokeTestHomePage().orderstoInvoice.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().orderstoInvoiceHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().orderstoInvoiceHeader.getText(), ApplicationConstants.ORDERS_TO_INVOICE_HEADER);

        Thread.sleep(5000);
        pages.getSmokeTestHomePage().orderstoUpsell.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().orderstoUpsellHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().orderstoUpsellHeader.getText(), ApplicationConstants.ORDERS_TO_UPSEL_HEADER);

        waitForPageToLoad(10000);
        pages.getSmokeTestHomePage().products.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().productsHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().productsHeader.getText(), ApplicationConstants.PRODUCTS_HEADER);

        waitForPageToLoad(10000);
        pages.getSmokeTestHomePage().pricelists.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().pricelistsHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().pricelistsHeader.getText(), ApplicationConstants.PRICELISTS_HEADER);

        waitForPageToLoad(10000);
        pages.getSmokeTestHomePage().sales.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().salesHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().salesHeader.getText(), ApplicationConstants.SALES_HEADER);

        waitForPageToLoad(10000);
        pages.getSmokeTestHomePage().allChannelsSalesOrders.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().allChannelsSalesOrdersHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().allChannelsSalesOrdersHeader.getText(), ApplicationConstants.ALL_CHANNELS_SALES_ORDERS_HEADER);

        waitForPageToLoad(10000);
        pages.getSmokeTestHomePage().salesChannels.click();
        Thread.sleep(5000);
        //System.out.println(pages.getSmokeTestHomePage().salesChannelsHeader.getText());
        Assert.assertEquals(pages.getSmokeTestHomePage().salesChannelsHeader.getText(), ApplicationConstants.SALES_CHANNELS_HEADER);
    }
}
