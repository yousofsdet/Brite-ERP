package com.briteErp.tests.functional_tests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrdersToInvoice extends TestBase {

    @Test
    public void login() throws InterruptedException {
        extentLogger = report.createTest("Order Number Checkbox");

        pages.login().BriteErpLink.click();
        driver.manage().window().fullscreen();
        extentLogger.info("Login to application");
        pages.login().login(ConfigurationReader.getProperty("ordersToinvoiceEmail"),
                ConfigurationReader.getProperty("ordersToinvoicePassword"));
        extentLogger.info("Clicking on Sales module and click on Orders to Invoice link");

        pages.invoicingPage().logIN();
        Thread.sleep(4000);


    }


    @Test
    public void orderNumberCheckbox() throws InterruptedException {

        login();

        Thread.sleep(1000);
        if (!pages.invoicingPage().orderNumberCheckboxHeader.isSelected())
            pages.invoicingPage().orderNumberCheckboxHeader.click();
        Assert.assertTrue(pages.invoicingPage().orderNumberCheckboxHeader.isSelected());
    }

    private void singleNumberCheckboxClick() {
        pages.invoicingPage().singleNumberCheckbox.click();
    }

    //    2. When a single checkbox is selected verify that only that checkbox is selected and not any other checkboxes get selected.
    @Test
    public void singleNumberCheckbox() throws InterruptedException {
        login();

        Thread.sleep(3000);
        if (!pages.invoicingPage().singleNumberCheckbox.isSelected())
            singleNumberCheckboxClick();
        Assert.assertTrue(pages.invoicingPage().singleNumberCheckbox.isSelected());
        int count = 0;
        List<WebElement> listCheckbox = pages.invoicingPage().checkboxList;
        for (WebElement el : listCheckbox) {

            if (!el.isSelected()) {
                count++;
            }
        }
        System.out.println(count);

    }

//3. When at least one checkbox is selected, verify that "Print" and "Action" menu tabs appear at the top middle of the table.

    @Test
    public void printNaction() throws InterruptedException {
        login();
        Thread.sleep(3000);
        singleNumberCheckboxClick();
        Assert.assertTrue(pages.invoicingPage().printMenu.isDisplayed());

    }


    //    4. When an "Action" tab is clicked verify that drop - down menu appears.
    @Test
    public void actionMenu() throws InterruptedException {
        login();
        Thread.sleep(3000);
        singleNumberCheckboxClick();
        pages.invoicingPage().actionMenu.click();
        List<WebElement> actionOptions = pages.invoicingPage().dropDownOptionsActions;

        for (WebElement option : actionOptions) {
            System.out.println(option.getText());
        }
        Assert.assertTrue(pages.invoicingPage().actionMenu.isDisplayed());
    }

//    5. Verify that each field of the "Action" drop-down menu functions properly.

    @Test
    public void actonFunctionsProperly() throws InterruptedException {
        login();
        Thread.sleep(4000);
        singleNumberCheckboxClick();
        pages.invoicingPage().actionMenu.click();
        Thread.sleep(4000);
        List<WebElement> actionOptions = pages.invoicingPage().dropDownOptionsActions;
        Thread.sleep(4000);
        actionOptions.get(0).click();
        Thread.sleep(4000);
        Assert.assertTrue(pages.invoicingPage().exportData.isDisplayed());
        pages.invoicingPage().exportDataClose.click();
        pages.invoicingPage().actionMenu.click();
        Thread.sleep(4000);
        actionOptions.get(1).click();
        Thread.sleep(4000);
        Assert.assertTrue(pages.invoicingPage().invoceOrder.isDisplayed());
        pages.invoicingPage().invoceOrderClose.click();
        Thread.sleep(5000);
        pages.invoicingPage().actionMenu.click();
        Thread.sleep(4000);
        actionOptions.get(2).click();
        Thread.sleep(4000);
        Assert.assertTrue(pages.invoicingPage().thirdDropdownOdoo.isDisplayed());
        pages.invoicingPage().thirdDropdownOdooClose.click();

    }

//   6.  When a "Print" menu tab is clicked, verify Quotation/Order dropdown option appears.

    @Test
    public void print() throws InterruptedException {

        login();
        Thread.sleep(4000);
        singleNumberCheckboxClick();
        pages.invoicingPage().printMenuTab.click();
        Assert.assertTrue(pages.invoicingPage().printMenuTabAppeareance.isDisplayed());

    }


//    7. When user clicks "Orders to Invoice" link on the side panel, verify that "List"
//    button at the top right of the page is displayed by default.

    @Test
    public void listButton() throws InterruptedException {
        login();
        Thread.sleep(4000);
        Assert.assertTrue(pages.invoicingPage().searchBox.isDisplayed());
    }

//    8. When user clicks Calendar, Graph, Pivot, Kanban buttons verify that they are clickable.

    @Test
    public void calendarGraphPivotKanban() throws InterruptedException {
        login();
        Thread.sleep(3000);
        pages.invoicingPage().calendar.click();
        Assert.assertTrue(pages.invoicingPage().calendarPageVerify.isDisplayed());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(4000);
        pages.invoicingPage().graph.click();
        Assert.assertTrue(pages.invoicingPage().graphPageVerify.isDisplayed());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(4000);
        pages.invoicingPage().pivot.click();
        Assert.assertTrue(pages.invoicingPage().pivotPageVerify.isDisplayed());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(4000);
        pages.invoicingPage().kanban.click();
        Assert.assertTrue(pages.invoicingPage().kanbanPageVerify.isDisplayed());

    }

//    9.Any of the Calendar, Graph, Pivot, Kanban buttons should function properly by displaying related tables.

    @Test
    public void calGraphPivotKanbonCheck() throws InterruptedException {
        login();
        Thread.sleep(5000);
        pages.invoicingPage().calendar.click();
        pages.invoicingPage().calendarMonthButtonClick.click();
        pages.invoicingPage().graph.click();
        pages.invoicingPage().barChartClick.click();
        pages.invoicingPage().pivot.click();
        Thread.sleep(5000);
        pages.invoicingPage().flipAxis.click();
        pages.invoicingPage().kanban.click();
        Thread.sleep(5000);
        pages.invoicingPage().kanbanValue.click();

    }



    //    10.  When user search from the search box verify that drop - down list appears and shows the user searching result
    @Test
    public void searchBoxDropDown() throws InterruptedException {
        login();
        Thread.sleep(3000);
        pages.invoicingPage().searchBox.sendKeys("sales");
        Assert.assertTrue(pages.invoicingPage().checkboxDropDownList.isDisplayed());



    }

}