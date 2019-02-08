package com.briteErp.pages;
/*
Created by: Mamura Rizaeva
Description: This is the page object class for smoke tests
 */

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmokeTestHomePage {
    public SmokeTestHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sales")
    public WebElement salesModule;

    @FindBy(linkText = "SalesUser4")
    public WebElement salesUser4;

    @FindBy(linkText = "SalesManager")
    public WebElement salesManager;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement logout;

    //menu tabs from here
    @FindBy(linkText = "Orders")
    public WebElement orders;

    @FindBy(linkText = "Customers")
    public WebElement customers;

    @FindBy(linkText = "Orders to Invoice")
    public WebElement orderstoInvoice;

    @FindBy(linkText = "Orders to Upsell")
    public WebElement orderstoUpsell;

    @FindBy(linkText = "Products")
    public WebElement products;

    @FindBy(linkText = "Pricelists")
    public WebElement pricelists;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[6]/ul[4]/li[1]/a/span")
    public WebElement sales;

    @FindBy(linkText = "Sales Channels")
    public WebElement salesChannels;

    @FindBy(linkText = "All Channels Sales Orders")
    public WebElement allChannelsSalesOrders;

    //headers from here
    @FindBy(xpath = "//li[.='Quotations']")
    public WebElement quatationsHeader;

    @FindBy(xpath = "//li[.='Sales Orders']")
    public WebElement ordersHeader;

    @FindBy(xpath = "//li[.='Customers']")
    public WebElement customersHeader;

    @FindBy(xpath = "//li[.='Orders to Invoice']")
    public WebElement orderstoInvoiceHeader;

    @FindBy(xpath = "//li[.='Orders to Upsell']")
    public WebElement orderstoUpsellHeader;

    @FindBy(xpath = "//li[.='Products']")
    public WebElement productsHeader;

    @FindBy(xpath = "//li[.='Pricelists']")
    public WebElement pricelistsHeader;

    @FindBy(xpath = "//li[.='Sales Analysis']")
    public WebElement salesHeader;

    @FindBy(xpath = "//li[.='All Channels Sales Orders']")
    public WebElement allChannelsSalesOrdersHeader;

    @FindBy(xpath = "//li[.='Sales Channels']")
    public WebElement salesChannelsHeader;


}
