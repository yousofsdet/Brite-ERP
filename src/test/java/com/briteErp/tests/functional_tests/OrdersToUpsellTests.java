//Created by: Mamura Rizaeva
//Description; Orders To Upsell functionality test cases
package com.briteErp.tests.functional_tests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.BrowserUtils;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OrdersToUpsellTests extends TestBase {
    @Test
    public void testPageLoadPerformance() throws InterruptedException {
        extentLogger = report.createTest("Page Load Performance");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);
    }

    @Test
    public void testPageContentsDisplay() throws InterruptedException {
        extentLogger = report.createTest("Page Contents Display");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Verify page header is displayed and is Orders to Upsell");
        BrowserUtils.verifyElementDisplayed(pages.getOrdersToUpsell().header);
        assertEquals(pages.getOrdersToUpsell().header.getText(), ApplicationConstants.ORDERS_TO_UPSELL);
    }

    @Test
    public void testBriteErpLogoDisplay() throws InterruptedException {
        extentLogger = report.createTest("BriteERP logo display");
        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));


        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);


        extentLogger.info("Locating the logo image");
        WebElement logo = driver.findElement(By.xpath("//a[@class='o_sub_menu_logo']/img"));

        extentLogger.info("Verifying logo is displayed");
        BrowserUtils.verifyElementDisplayed(logo);

        Thread.sleep(5000);
        logo.click();
    }

    @Test
    public void testListKanbanButtons() throws InterruptedException {
        extentLogger = report.createTest("List and Kanban buttons");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Clicking on Kanban button and take text on the page");
        Thread.sleep(5000);
        pages.getOrdersToUpsell().kanbanButton.click();
        Thread.sleep(5000);
        String kanbanContentText = pages.getOrdersToUpsell().textContent.getText();

        extentLogger.info("Clicking on List button and take text on the page");
        Thread.sleep(7000);
        pages.getOrdersToUpsell().listButton.click();
        String listContentText = pages.getOrdersToUpsell().textContent.getText();

        extentLogger.info("Verify both pages contain same text");
        assertEquals(listContentText, kanbanContentText);

        System.out.println(listContentText);
        System.out.println(kanbanContentText);
    }

    @Test
    public void testGraphButton() throws InterruptedException {
        extentLogger = report.createTest("Graph button functionality");
        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Locate Graph page and click on buttons");
        Thread.sleep(5000);
        pages.getOrdersToUpsell().graphButton.click();
        Thread.sleep(5000);
        for (WebElement e:pages.getOrdersToUpsell().graphOption) {
            Thread.sleep(2000);
            e.click();
        }

        extentLogger.info("Check the measures drop down click its options");
        Thread.sleep(5000);
        pages.getOrdersToUpsell().measureButton.click();
        Thread.sleep(5000);
        assertEquals(pages.getOrdersToUpsell().total.getText(), "Total");
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().untaxedAmount.getText(), "Untaxed Amount");
        pages.getOrdersToUpsell().untaxedAmount.click();
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().taxes.getText(), "Taxes");
        pages.getOrdersToUpsell().taxes.click();
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().count.getText(), "Count");
        pages.getOrdersToUpsell().count.click();
        Thread.sleep(2000);
    }

    @Test
    public void testCalendarButton() throws InterruptedException {
        extentLogger = report.createTest("Checking calendar functionality");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Find the button elements and hover over");
        Thread.sleep(5000);
        for (WebElement e:pages.getOrdersToUpsell().buttons) {
            Thread.sleep(3000);
            BrowserUtils.hover(e);
        }

        extentLogger.info("Verifying each button is displayed");
        for (WebElement e:pages.getOrdersToUpsell().buttons) {
            BrowserUtils.verifyElementDisplayed(e);
        }

        extentLogger.info("Clicking on Calendar and verify page buttons displayed");
        Thread.sleep(5000);
        pages.getOrdersToUpsell().calendarButton.click();
        Thread.sleep(5000);
        for (WebElement e:pages.getOrdersToUpsell().calendarOptions) {
            Thread.sleep(3000);
            e.click();
        }

        extentLogger.info("Clicking on side bar");
        pages.getOrdersToUpsell().calendarSidebar.click();
    }

    @Test
    public void testPageSearchFunctionality() throws InterruptedException {
        extentLogger = report.createTest("Page Search Functionality");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Clicking on search box and entering search term iMac");
        Thread.sleep(8000);
        pages.getOrdersToUpsell().searchbox.sendKeys("iMac" + Keys.ENTER);

        extentLogger.info("Verify no results displayed");
        BrowserUtils.verifyElementDisplayed(pages.getOrdersToUpsell().textContent);
        System.out.println(pages.getOrdersToUpsell().textContent.getText());
    }

    @Test
    public void testCreateFormFromCalendar() throws InterruptedException {
        extentLogger = report.createTest("Creating a summary form.");
        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(7000);

        extentLogger.info("Locating calendar page and click any cell");
        BrowserUtils.waitForVisibility(pages.getOrdersToUpsell().calendarButton, 5);
        pages.getOrdersToUpsell().calendarButton.click();
        Thread.sleep(6000);
        pages.getOrdersToUpsell().calendarCell.click();
        Thread.sleep(8000);

        extentLogger.info("Create summary and click create on pop up window.");
        pages.getOrdersToUpsell().summaryBox.sendKeys("SO123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Create']")).click();
    }

    @Test
    public void testAddNewUpsellRecord() throws InterruptedException {
        extentLogger = report.createTest("Add new record test");
        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);

        extentLogger.info("Locate a Create button and click to add new record");
        Thread.sleep(5000);
        Assert.assertTrue(false);
    }

    @Test
    public void testPivotPage() throws InterruptedException {
        extentLogger = report.createTest("Pivot page functionality");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToUpsellUsername"),
                ConfigurationReader.getProperty("ordersToUpsellPassword"));

        extentLogger.info("Clicking on Sales module and click on Orders to Upsell link");
        pages.getOrdersToUpsell().goToPage();
        Thread.sleep(5000);


        extentLogger.info("Locate Pivot page and click option buttons");
        Thread.sleep(5000);
        pages.getOrdersToUpsell().pivotButton.click();

        Thread.sleep(5000);
        for (WebElement e:pages.getOrdersToUpsell().pivotOptions) {
            Thread.sleep(2000);
            e.click();
        }

        extentLogger.info("Check the measures drop down and options are clickable");

        Thread.sleep(5000);
        pages.getOrdersToUpsell().measureButton.click();

        assertEquals(pages.getOrdersToUpsell().total.getText(), "Total");
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().untaxedAmount.getText(), "Untaxed Amount");
        pages.getOrdersToUpsell().untaxedAmount.click();
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().taxes.getText(), "Taxes");
        pages.getOrdersToUpsell().taxes.click();
        Thread.sleep(2000);

        assertEquals(pages.getOrdersToUpsell().count.getText(), "Count");
        pages.getOrdersToUpsell().count.click();
        Assert.assertTrue(pages.getOrdersToUpsell().count.isSelected());
        Thread.sleep(2000);
    }
}
