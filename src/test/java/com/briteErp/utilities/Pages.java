package com.weborders.utilities;

import com.weborders.pages.*;

public class Pages {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ViewAllProductsPage viewAllProductsPage;
    private OrderPage orderPage;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

      public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public ViewAllProductsPage viewAllProducts() {
        if (viewAllProductsPage == null) {
            viewAllProductsPage = new ViewAllProductsPage();
        }
        return viewAllProductsPage;
    }

    public OrderPage order() {
        if (orderPage == null) {
            orderPage = new OrderPage();
        }
        return orderPage;
    }
}
