package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotationsPage {

    public QuotationsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Sales")
    public WebElement salesLink;

    @FindBy(linkText = "Quotations")
    public WebElement quoteLeft;

    @FindBy(linkText = "Orders")
    public WebElement ordersLeft;

    @FindBy(linkText = "Customers")
    public WebElement CustomersLeft;

    @FindBy(xpath = "//ol/li[@class='active' and 1]")
    public WebElement ActiveHeader;
}
