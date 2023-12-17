/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.productcatalog;

public class Product {
    private int id;
    private String productName;
    private String description;
    private String category;
    private double weight;
    private int price;
    private String availability;

    public Product(int id, String productName, String category, int weight, int price, String availability, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }
}