package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class ProductsPage {
    
    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='fa fa-chevron-right btn btn-icon o_pager_next']")
    public WebElement nextPageLink;

    @FindBy(linkText = "Products")
    public WebElement productsLink;

    @FindBy(linkText = "Sales")
    public WebElement salesLink;

    @FindBy (xpath = "//img[@src='http://52.39.162.23/web/image?model=product.template&field=image_small&id=28&unique=']")
    public  WebElement graphicsCard;

    @FindBy(xpath = "//img[@src='http://52.39.162.23/web/image?model=product.template&field=image_small&id=29&unique=']")
    public WebElement laptopE5023;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[5]")
    public WebElement graphicsCardSalesLink;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody//td/div/input")
    public WebElement checkBoxSO007;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]")
    public WebElement dropDown;

    @FindBy(xpath = "//div[@class='btn-group o_dropdown open']/ul/li")
    public WebElement exportLink;

    @FindBy(xpath = "//div[@class='btn-group o_dropdown open']/ul/li[2]")
    public WebElement deleteLink;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[6]")
    public WebElement activeLink;

    @FindBy(tagName = "h4")
    public WebElement errorMessageStatus;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-link o_chatter_button_schedule_activity']")
    public WebElement scheduleLink;

    @FindBy(xpath = "//label[@class='o_form_label o_required_modifier']")
    public WebElement activityDropdown;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public WebElement firstOptionDropdown;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement scheduleButton;

    @FindBy(xpath = "(//h4)[5]")
    public WebElement errorMessageSchedule;

    @FindBy (xpath = "//span[@class='o_field_monetary o_field_number o_field_widget o_readonly_modifier']")
    public  WebElement laptopSalesPrice;

    @FindBy (xpath = "(//span[@class='o_field_monetary o_field_number o_field_widget o_readonly_modifier'])[2]")
    public WebElement lapTopSubTotal;

    @FindBy (xpath = "(//button[@class='btn btn-sm oe_stat_button'])[5]")
    public  WebElement laptopSalesLink;

    @FindBy (xpath = "//div[@class='btn-group o_dropdown open']/ul//a")
    public WebElement exportLinkSelect;

    @FindBy (xpath = "//div[@class='o_field_tree_structure']/div")
    public  WebElement fields;
    
    @FindBy (xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_field_empty']")
    public WebElement barcode;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public  WebElement createButton;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public  WebElement productNameEntry;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public  WebElement saveButton;

    @FindBy (xpath = "//div[@class='o_notification_manager']")
    public WebElement errorMessageInvalidField;


    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input']")
    public  WebElement barcodeBox;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-default']")
    public  WebElement updateQuantityButton;

    @FindBy (xpath = "//input[@class='o_field_float o_field_number o_field_widget o_input o_required_modifier']")
    public  WebElement quantityOnHandBox;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement applyButton;

    @FindBy (xpath = "(//h4)[2]")
    public  WebElement errorMessageQuantity;


 public static void productName(String productName) {

        List<WebElement> products = Driver.getDriver().findElements(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])/div[2]/strong"));

        for (WebElement product : products) {

            if(product.getText().equals(productName)){

                Assert.assertEquals(product.getText(),productName);

            }
        }
    }

   public static void allFields(){

        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='o_field_tree_structure']/div"));

        for(int i = 0; i< list.size()-1; i++){

           String first = list.get(i).getText();
           String next = list.get(i+1).getText();
            System.out.println(first+" compare to "+next);

            Assert.assertTrue(first.compareTo(next)<=0);

        }
    }

}

