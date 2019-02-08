package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class SalesOrdersPage {
    public SalesOrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
