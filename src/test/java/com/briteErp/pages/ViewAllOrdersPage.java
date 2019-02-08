package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage extends Menu {
    public ViewAllOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
