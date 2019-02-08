//Created by: Mamura Rizaeva
//Description: Orders To Upsell functionality page factory class
package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OrdersToUpsellPage {
    public OrdersToUpsellPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sales")
    public WebElement sales;

    @FindBy(linkText = "Orders to Upsell")
    public WebElement ordersToUpsell;

    @FindBy(xpath = "//li[.='Orders to Upsell']")
    public WebElement header;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button[2]")
    public WebElement calendarButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button[3]")
    public WebElement graphButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button[4]")
    public WebElement pivotButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button[5]")
    public WebElement kanbanButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button[1]")
    public WebElement listButton;

    @FindBy(xpath = "//div[@class='oe_view_nocontent']//p[2]")
    public WebElement textContent;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[3]/button" )
    public List<WebElement> buttons;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//button")
    public List<WebElement> calendarOptions;

    @FindBy(xpath = "//i[@title='Close Sidebar']" )
    public WebElement calendarSidebar;

    @FindBy(xpath = "//table//tbody[@class='fc-body']//tr[5]/td[2]")
    public WebElement calendarCell;

    @FindBy(xpath = "//div[@class='form-group']//input" )
    public WebElement summaryBox;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//button")
    public  List<WebElement> graphOption;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement measureButton;

    @FindBy(xpath = "//a[.='Total']")
    public WebElement total;

    @FindBy(xpath = "//a[.='Untaxed Amount']")
    public WebElement untaxedAmount;

    @FindBy(xpath = "//a[.='Taxes']")
    public WebElement taxes;

    @FindBy(xpath = "//a[.='Count']")
    public WebElement count;

    @FindBy(className = "o_searchview_input")
    public WebElement searchbox;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//button")
    public List<WebElement> pivotOptions;

    public void goToPage() throws InterruptedException {
        Thread.sleep(5000);
        sales.click();
        ordersToUpsell.click();
    }
}


