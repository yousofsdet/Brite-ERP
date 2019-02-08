package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
