package com.weborders.tests.smoke_tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.pages.ViewAllProductsPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PageHeadersTests extends TestBase {

    @Test
    public void pageHeadersTest(){

        //add reporting
        extentLogger = report.createTest("Page Headers Test");

        //logger to log steps
        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));

        extentLogger.info("Verifying header for all orders page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_ORDERS);

        extentLogger.info("Clicking on view all products link");
        pages.viewAllOrders().viewAllProductsLink.click();

        extentLogger.info("Verifying header for all orders page");
        assertEquals(pages.viewAllProducts().header.getText(), ApplicationConstants.LIST_OF_ALL_PRODUCTS);

        extentLogger.info("Clicking on the order link");
        pages.viewAllProducts().orderLink.click();

        extentLogger.info("Verifying header for order page");
        assertEquals(pages.order().header.getText(), ApplicationConstants.ORDER);

        extentLogger.pass("Page Headers Test");

    }

}
