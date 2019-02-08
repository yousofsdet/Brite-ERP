package com.briteErp.tests.functional_tests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.briteErp.pages.ProductsPage.allFields;
import static com.briteErp.pages.ProductsPage.productName;
import static com.briteErp.utilities.ApplicationConstants.ACCESS_ERROR_MESSAGE;
import static com.briteErp.utilities.BrowserUtils.waitForClickablility;
import static com.briteErp.utilities.BrowserUtils.waitForPageToLoad;

public class productDataTests extends TestBase {

    //Mary

    @Test (priority = 1)
    public void exportDeleteOptions() throws InterruptedException {

        extentLogger = report.createTest("Export/Delete Options");
        extentLogger.info("Verifying export and delete options are available.");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        pages.productsPage().salesLink.click();
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        pages.productsPage().graphicsCardSalesLink.click();
        waitForPageToLoad(10000);

        extentLogger.info("Selecting first checkbox.");
        pages.productsPage().checkBoxSO007.click();
        waitForPageToLoad(10000);

        pages.productsPage().dropDown.click();

        extentLogger.info("Verifying export link is available");
        Assert.assertEquals(pages.productsPage().exportLink.getText(),"Export");
        Thread.sleep(4000);

        extentLogger.info("Verifying delete link is available");
        Assert.assertEquals(pages.productsPage().deleteLink.getText(),"Delete");
        Thread.sleep(2000);

    }

    @Test (priority = 2)
    public void productStatusTest() throws InterruptedException {

        extentLogger = report.createTest("Product status");
        extentLogger.info("Verifying that user is not able to change product status");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        waitForPageToLoad(10000);

        pages.productsPage().salesLink.click();
        extentLogger.info("Navigating to products page.");
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();
        waitForPageToLoad(10000);

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);


        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        extentLogger.info("Clicking on 'Active' link ");
        pages.productsPage().activeLink.click();
        waitForPageToLoad(10000);


        extentLogger.info("Verifying user is not able to change the product status and gets an error message");

        Assert.assertEquals(pages.productsPage().errorMessageStatus.getText(),ACCESS_ERROR_MESSAGE);
        Thread.sleep(2000);


    }

    @Test (priority = 3)
    public void schedulingActivityTest() throws InterruptedException {

        extentLogger = report.createTest("Scheduling Activity");
        extentLogger.info("Verifying user is not able to schedule any activity.");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        pages.productsPage().salesLink.click();
        extentLogger.info("Navigating to products page.");
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();
        waitForPageToLoad(10000);

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        pages.productsPage().scheduleLink.click();
        waitForPageToLoad(10000);

        pages.productsPage().activityDropdown.click();

        extentLogger.info("Selecting option from dropdown");
        pages.productsPage().firstOptionDropdown.click();
        Thread.sleep(1000);

        extentLogger.info("Clicking on the schedule button.");
        pages.productsPage().scheduleButton.click();

        extentLogger.info("Verifying user is not able to schedule any activity and gets an error message.");
        Assert.assertEquals(pages.productsPage().errorMessageSchedule.getText(),ACCESS_ERROR_MESSAGE);

        Thread.sleep(2000);


    }

    @Test (priority = 4)
    public void subtotalIsCorrectTest() throws InterruptedException {

        extentLogger = report.createTest("Displayed product subtotal");
        extentLogger.info("Verifying product subtotal is displayed correctly.");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        Thread.sleep(4000);
        pages.productsPage().salesLink.click();
        extentLogger.info("Navigating to products page.");

        Thread.sleep(4000);
        pages.productsPage().productsLink.click();

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Selecting the product.");
        pages.productsPage().laptopE5023.click();
        Thread.sleep(4000);

        // String salesPrice = pages.productsPage().laptopSalesPrice.getText();
        // int salesPriceInt = Integer.ParseInt(salesPrice.substring(1));
        // System.out.println("Sales Price: "+salesPrice);

        // Thread.sleep(4000);
        pages.productsPage().laptopSalesLink.click();
        Thread.sleep(4000);

        String subtotal = pages.productsPage().lapTopSubTotal.getText();
        //int subtotalInt = Integer.parseInt(subtotal.substring(0,6));
        System.out.println("Subtotal: "+subtotal);

        // String quantity = pages.productsPage().quantity.getText();
        // int quantityInt = Integer.parseInt(quantity.substring(0,1));
        // System.out.println("Quantity of laptop: "+quantity);

        Thread.sleep(5000);

        extentLogger.info("Verifying product subtotal is displayed correctly.");
        // int subtotalActual = quantityInt*salesPriceInt;
        // System.out.println("Subtotal Actual: "+subtotalActual);
        Assert.assertEquals(subtotal,"11,800.00");

    }

    @Test (priority = 5)
    public void exportDataFieldsTest() throws InterruptedException {

        extentLogger = report.createTest("Data Fields are in ascending order");
        extentLogger.info("Verifying export data fields are in ascending order.");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        pages.productsPage().salesLink.click();
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        pages.productsPage().graphicsCardSalesLink.click();
        waitForPageToLoad(10000);

        extentLogger.info("Selecting first checkbox.");
        pages.productsPage().checkBoxSO007.click();
        waitForPageToLoad(10000);

        pages.productsPage().dropDown.click();
        Thread.sleep(4000);

        extentLogger.info("Clicking on export link");
        pages.productsPage().exportLinkSelect.click();
        Thread.sleep(4000);

        extentLogger.info("Verifying export data fields are in ascending order.");
        allFields();

    }

    @Test (priority = 6)
    public void barcodeTest() throws InterruptedException {

        extentLogger = report.createTest("Products' barcode is displayed");
        extentLogger.info("Verifying the products' barcode is displayed");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        pages.productsPage().salesLink.click();
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        String barcode = pages.productsPage().barcode.getText();
        Thread.sleep(4000);

        extentLogger.info("Verifying the products' barcode is displayed");
        Assert.assertEquals(barcode," ");


    }

    @Test (priority = 7)
    public void createdProductDisplayedTest() throws InterruptedException {

        extentLogger = report.createTest("Creating product");
        extentLogger.info("Verifying created product is displayed in the product page. ");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("SMUser1"),ConfigurationReader.getProperty("SMPass1"));

        pages.productsPage().salesLink.click();

        Thread.sleep(4000);
        extentLogger.info("Clicking on sales link");
        pages.productsPage().productsLink.click();
        Thread.sleep(4000);

        extentLogger.info("Clicking on create button");
        pages.productsPage().createButton.click();
        Thread.sleep(4000);

        extentLogger.info("Entering product name");
        pages.productsPage().productNameEntry.sendKeys("Zucchini");
        pages.productsPage().saveButton.click();
        Thread.sleep(4000);

        pages.productsPage().productsLink.click();
        Thread.sleep(4000);

        extentLogger.info("Verifying after creating the product, system displays it on the product page.");
        productName("Zucchini");


    }

    @Test (priority = 8)
    public void blankNameProductCreationTest() throws InterruptedException {

        extentLogger = report.createTest("Creating product with blank name");
        extentLogger.info("Verifying when the product is created with blank name, system gives an error message.");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("SMUser1"),ConfigurationReader.getProperty("SMPass1"));

        pages.productsPage().salesLink.click();

        Thread.sleep(4000);
        pages.productsPage().productsLink.click();
        Thread.sleep(4000);

        extentLogger.info("Clicking product create button");
        pages.productsPage().createButton.click();
        Thread.sleep(4000);

        extentLogger.info("Leaving product name blank");
        pages.productsPage().productNameEntry.sendKeys("");

        extentLogger.info("Clicking save button");
        pages.productsPage().saveButton.click();

        extentLogger.info("Verifying when the product is created with blank name, system gives an error message.");
        String errorMessageActual = pages.productsPage().errorMessageInvalidField.getText();
        Assert.assertTrue(errorMessageActual.contains("invalid"));
        Thread.sleep(4000);


    }

    @Test (priority = 9)
    public void creatingProduct() throws InterruptedException {

        extentLogger = report.createTest("Creating product");
        extentLogger.info("Verifying sales manager can create a product. ");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("SMUser1"),ConfigurationReader.getProperty("SMPass1"));

        Thread.sleep(4000);
        pages.productsPage().salesLink.click();

        Thread.sleep(4000);

        pages.productsPage().productsLink.click();
        Thread.sleep(4000);

        extentLogger.info("Clicking on create button");
        pages.productsPage().createButton.click();

        Thread.sleep(4000);
        extentLogger.info("Entering the product name");
        pages.productsPage().productNameEntry.sendKeys("Yogurt");

        extentLogger.info("Entering barcode");
        pages.productsPage().barcodeBox.sendKeys("36354434232");

        extentLogger.info("Clicking on save button");
        pages.productsPage().saveButton.click();
        Thread.sleep(4000);

        pages.productsPage().productsLink.click();
        Thread.sleep(4000);

        extentLogger.info("Verifying sales manager is able to create a product with valid credentials.");
        productName("Yogurt");


    }

    @Test (priority = 10)
    public void updatingProductQuantityTest() throws InterruptedException {

        extentLogger = report.createTest("Updating product quantity");
        extentLogger.info("Verifying sales manager is not able to change the product quantity");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("emailUser"),ConfigurationReader.getProperty("passwordUser"));

        pages.productsPage().salesLink.click();
        waitForPageToLoad(10000);

        pages.productsPage().productsLink.click();

        Thread.sleep(4000);

        waitForClickablility(pages.productsPage().nextPageLink,10000);
        pages.productsPage().nextPageLink.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the product");
        pages.productsPage().graphicsCard.click();

        pages.productsPage().updateQuantityButton.click();
        Thread.sleep(4000);

        extentLogger.info("Entering the product quantity");
        pages.productsPage().quantityOnHandBox.clear();
        pages.productsPage().quantityOnHandBox.sendKeys("10.000");

        extentLogger.info("Clicking on apply button");
        Thread.sleep(3000);
        pages.productsPage().applyButton.click();

        extentLogger.info("Verifying sales manager is not able to change the product quantity");
        String errorMessageActual = pages.productsPage().errorMessageQuantity.getText();
        Assert.assertEquals(errorMessageActual,ACCESS_ERROR_MESSAGE);


    }

}






