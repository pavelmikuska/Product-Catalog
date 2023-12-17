/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.productcatalog;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    private ProductManager productManager;

    @FXML
    private TableView<Product> productsTableView;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label availabilityLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private TableColumn<Product, String> columnId;
    @FXML
    private TableColumn<Product, String> columnProduct;
    @FXML
    private TableColumn<Product, String> columnCategory;
    @FXML
    private TableColumn<Product, String> columnAvailability;
    @FXML
    private TableColumn<Product, Integer> columnPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productManager = new ProductManager();

        productsTableView.getItems().setAll(productManager.getProducts());

        columnId.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        columnProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        columnCategory.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        columnAvailability.setCellValueFactory(new PropertyValueFactory<Product, String>("availability"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));

        // vyber productu a zobrazenie detailu produktu
        if (!productManager.getProducts().isEmpty()) {
            productsTableView.getSelectionModel().select(0);
        }

        productsTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> ov, Product oldValue, Product newValue) {
                String productName = "?", price = "?", id = "?", category = "?", weight = "?", availability = "?",
                        description = "?";
                if (newValue != null) {
                    productName = newValue.getProductName();
                    price = String.valueOf(newValue.getPrice()) + " EUR";
                    id = String.valueOf(newValue.getId());
                    category = newValue.getCategory();
                    weight = String.valueOf(newValue.getWeight() / 1000) + " kg";
                    availability = newValue.getAvailability();
                    description = newValue.getDescription();
                }
                productNameLabel.setText(productName);
                priceLabel.setText(price);
                idLabel.setText(id);
                categoryLabel.setText(category);
                weightLabel.setText(weight);
                availabilityLabel.setText(availability);
                descriptionLabel.setText(description);
            }
        });
    }
}
