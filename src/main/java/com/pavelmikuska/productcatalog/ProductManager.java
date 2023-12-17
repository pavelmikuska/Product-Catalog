/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.productcatalog;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;
    private DatabaseManager databaseManager;

    public ProductManager() {
        products = new ArrayList<>();
        databaseManager = new DatabaseManager();
        databaseManager.getAllData(products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}