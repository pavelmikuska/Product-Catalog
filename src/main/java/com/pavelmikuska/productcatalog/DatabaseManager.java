/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.productcatalog;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    public void getAllData(ArrayList<Product> products) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/company_catalog?user=root&password=");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
             ResultSet results = preparedStatement.executeQuery();
             ) {
            while (results.next()) {
                products.add(new Product(
                        results.getInt(1),
                        results.getString("product"),
                        results.getString("category"),
                        results.getInt("weight"),
                        results.getInt("price"),
                        results.getString("available"),
                        results.getString("description")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}