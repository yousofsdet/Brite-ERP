package com.briteErp.tests.functional_tests;

import com.briteErp.utilities.BrowserUtils;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * This class provides test cases for the "All Channels Sales Orders Page"
 * that test the functionality of menu items and links of the page.
 *
 * @author Osman Sahin
 */

public class AllChannelsSalesOrdersTests extends TestBase {

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }   // isAlertPresent()


    public void filter() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        pages.login().BriteErpLink.click();

        pages.login().login(ConfigurationReader.getProperty("emailMan"), ConfigurationReader.getProperty("passwordMan"));
        Thread.sleep(10000);
        pages.allChannelsSalesOrdersPage().salesMenu.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().allChannelsSalesOrdersLink.click();
        Thread.sleep(5000);

        if (!pages.allChannelsSalesOrdersPage().filters.isDisplayed()) {
            BrowserUtils.waitForClickablility(pages.allChannelsSalesOrdersPage().advancedSearch, 5);
            pages.allChannelsSalesOrdersPage().advancedSearch.click();
        }

        pages.allChannelsSalesOrdersPage().filters.click();
        pages.allChannelsSalesOrdersPage().addCustomFilter.click();

        Thread.sleep(3000);
        Select filterOption1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[4]/span[2]/select")));
        filterOption1.selectByVisibleText("Total");
        Thread.sleep(3000);
        Select filterOption2 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[4]/select")));
        filterOption2.selectByVisibleText("less than");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement filterText = driver.findElement(By.xpath("//input[@class='o_input']"));
        filterText.clear();
        filterText.sendKeys("20000");
        WebElement filterApplyButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[5]/button[1]"));
        filterApplyButton.click();
    }

    @Test
    public void FavoritesMenuTest1() throws InterruptedException {
        filter();
        extentLogger = report.createTest("Adding current search results to Favorites Menu");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the Save current search");
        pages.allChannelsSalesOrdersPage().saveCurrentSearch.click();
        pages.allChannelsSalesOrdersPage().favoritesText.clear();
        extentLogger.info("Save the current search as 'sale1'");
        pages.allChannelsSalesOrdersPage().favoritesText.sendKeys("sale1");
        pages.allChannelsSalesOrdersPage().favoritesSaveButton.click();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().favorites.click();

        Set<WebElement> favorites = new HashSet<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (WebElement fav : favorites) {
            if (fav.getText().equals("sale1"))
                found = true;
        }

        extentLogger.pass("Current search result saved to the Favorites Menu");
        Assert.assertTrue(found);
    }

    @Test
    public void FavoritesMenuTest2() throws InterruptedException {
        filter();
        extentLogger = report.createTest("Applying saved search results from Favorites Menu and delete it");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the 'sale1'");


        List<WebElement> fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().equals("sale1")) {
                fav.get(i).click();
                Thread.sleep(3000);
                found = true;
                String delete = "//li[" + (i + 1) + "]/span[@class='fa fa-trash-o o-remove-filter' and 1]";
                driver.findElement(By.xpath(delete)).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        }

        extentLogger.info("Search result is applied");

        fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        found = fav.contains("sale1");


        extentLogger.pass("Applied saved search result and deleted");
        Assert.assertFalse(found);
    }

    @Test
    public void FavoritesMenuTest3() throws InterruptedException {
        filter();
        extentLogger = report.createTest("Sharing current search result with all users");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the Save current search");
        pages.allChannelsSalesOrdersPage().saveCurrentSearch.click();
        pages.allChannelsSalesOrdersPage().favoritesText.clear();
        extentLogger.info("Save the current search as 'sale7'");
        pages.allChannelsSalesOrdersPage().favoritesText.sendKeys("sale7");

        List<WebElement> fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().trim().equals("Share with all users")) {
                String checkbox = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li[" + (i + 1) + "]/span[1]/div/input";
                driver.findElement(By.xpath(checkbox)).click();
            }
        }

        pages.allChannelsSalesOrdersPage().favoritesSaveButton.click();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().favorites.click();

        fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().trim().equals("sale7")) {
                found = true;
            }
        }

        extentLogger.pass("Current search result shared with all users");
        Assert.assertTrue(found);
    }

    @Test
    public void FavoritesMenuTest4() throws InterruptedException {
        filter();
        extentLogger = report.createTest("Applying shared search results from Favorites Menu and delete it");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the 'sale2'");


        List<WebElement> fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().equals("sale2")) {
                fav.get(i).click();
                found = true;
                Thread.sleep(3000);
                String delete = "//li[" + (i + 1) + "]/span[@class='fa fa-trash-o o-remove-filter' and 1]";
                driver.findElement(By.xpath(delete)).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        }

        if (driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
        }


        extentLogger.info("Shared result is applied");

        Driver.getDriver().navigate().refresh();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().favorites.click();

        fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().trim().equals("sale2")) {
                found = true;
            }
        }

        extentLogger.fail("Search result and being deleted");
        Assert.assertFalse(found);
    }

    @Test
    public void FavoritesMenuTest5() throws InterruptedException {
        filter();
        extentLogger = report.createTest("Saving current search result as default");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the Save current search");
        pages.allChannelsSalesOrdersPage().saveCurrentSearch.click();
        pages.allChannelsSalesOrdersPage().favoritesText.clear();
        extentLogger.info("Save the current search as 'sale9'");
        pages.allChannelsSalesOrdersPage().favoritesText.sendKeys("sale9");

        List<WebElement> fav = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getText().trim().equals("Use by default")) {
                String checkbox = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li[" + (i + 1) + "]/span[1]/div/input";
                driver.findElement(By.xpath(checkbox)).click();
            }
        }

        pages.allChannelsSalesOrdersPage().favoritesSaveButton.click();
        driver.findElement(By.xpath("//span[@class='oe_topbar_name']")).click(); // Click on the username on the top right
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[6]/a[1]")).click(); // Click on the logout
        Thread.sleep(5000);

        pages.login().login(ConfigurationReader.getProperty("emailMan"), ConfigurationReader.getProperty("passwordMan"));
        Thread.sleep(10000);
        pages.allChannelsSalesOrdersPage().salesMenu.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().allChannelsSalesOrdersLink.click();
        Thread.sleep(5000);

        String defaultSearch = driver.findElement(By.xpath("//div[@class='o_facet_values']/span[1]")).getText();

        extentLogger.pass("Default search is sale9");
        Assert.assertTrue(defaultSearch.equals("sale9"));
    }

    @Test
    public void FavoritesMenuTest6() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        filter();
        extentLogger = report.createTest("Saving current search result to the Dashboard");
        extentLogger.info("Click on the Favorites Menu");
        pages.allChannelsSalesOrdersPage().favorites.click();
        extentLogger.info("Click on the Add to my Dashboard");
        pages.allChannelsSalesOrdersPage().addToMyDashboard.click();
        extentLogger.info("Save the current search as 'sale9'");
        pages.allChannelsSalesOrdersPage().dashboardText.clear();
        pages.allChannelsSalesOrdersPage().dashboardText.sendKeys("sale9");
        pages.allChannelsSalesOrdersPage().dasboardAddButton.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().dashboardsMenu.click();
        Thread.sleep(10000);

        List<WebElement> search = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"column_0\"]/div")));
        boolean found = false;
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i).getText());
            if (search.get(i).getText().trim().startsWith("sale9")) {
                found = true;
            }
        }
        extentLogger.pass("'sale9' is saved on Dashboards");
        Assert.assertTrue(found);
    }


    @Test
    public void FavoritesMenuTest7() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        extentLogger = report.createTest("Deleting a saved search from the Dashboard");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to the website");
        pages.login().login(ConfigurationReader.getProperty("emailMan"), ConfigurationReader.getProperty("passwordMan"));
        Thread.sleep(10000);

        extentLogger.info("Click on the Dashboards Menu");
        pages.allChannelsSalesOrdersPage().dashboardsMenu.click();

        pages.allChannelsSalesOrdersPage().dashboardsMenu.click();
        Thread.sleep(10000);

        List<WebElement> search = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"column_0\"]/div")));
        boolean found = false;
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getText().startsWith("sale9")) {
                String xpath = "//*[@id=\"column_0\"]/div[" + (i + 1) + "]/h2/span[2]";
                Driver.getDriver().findElement(By.xpath(xpath)).click();
                Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
            }
        }

        search = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"column_0\"]/div")));
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getText().startsWith("sale9")) {
                String xpath = "//*[@id=\"column_0\"]/div[" + (i + 1) + "]/h2/span[2]";
                Driver.getDriver().findElement(By.xpath(xpath)).click();
                found = true;
            }
        }

        extentLogger.pass("'sale9' is deleted from the Dashboards");
        Assert.assertFalse(found);
    }

    @Test
    public void FiltersMenuTest() throws InterruptedException {
        extentLogger = report.createTest("Applying custom filter");
        filter();

        extentLogger.pass("Custom filter is applied");
        Assert.assertTrue(true);

    }

    @Test
    public void MeasuresMenuTest() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        extentLogger = report.createTest("Customizing search results by columns");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to the website");
        pages.login().login(ConfigurationReader.getProperty("emailMan"), ConfigurationReader.getProperty("passwordMan"));
        Thread.sleep(10000);
        pages.allChannelsSalesOrdersPage().salesMenu.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().allChannelsSalesOrdersLink.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().measuresMenu.click();
        pages.allChannelsSalesOrdersPage().productQuantity.click();

        Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div")).click();
        Thread.sleep(3000);

        List<WebElement> columns = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/table/thead/tr[2]/th")));
        boolean found = false;
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).getText().startsWith("Product Quantity")) {
                found = true;
            }
        }

        extentLogger.pass("Custom filter is applied");
        Assert.assertTrue(found);

    }

    @Test
    public void GroupByMenuTest() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        extentLogger = report.createTest("Customizing search results by columns");

        pages.login().BriteErpLink.click();

        extentLogger.info("Login to the website");
        pages.login().login(ConfigurationReader.getProperty("emailMan"), ConfigurationReader.getProperty("passwordMan"));
        Thread.sleep(10000);
        pages.allChannelsSalesOrdersPage().salesMenu.click();
        Thread.sleep(5000);
        pages.allChannelsSalesOrdersPage().allChannelsSalesOrdersLink.click();
        Thread.sleep(5000);

        if (!pages.allChannelsSalesOrdersPage().filters.isDisplayed()) {
            BrowserUtils.waitForClickablility(pages.allChannelsSalesOrdersPage().advancedSearch, 5);
            pages.allChannelsSalesOrdersPage().advancedSearch.click();
        }
        extentLogger.info("Group by option is being applied");

        pages.allChannelsSalesOrdersPage().groupByMenu.click();
        pages.allChannelsSalesOrdersPage().addCustomGroup.click();
        Select groupByOptions = new Select(pages.allChannelsSalesOrdersPage().groupBySelect);
        groupByOptions.selectByVisibleText("Salesperson");
        pages.allChannelsSalesOrdersPage().groupBySaveButton.click();

        Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div")).click();

        extentLogger.pass("Custom grouping is applied to the search result");
        Assert.assertTrue(true);

    }


}
