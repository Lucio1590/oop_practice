package org.lucian.module2.ECommerce;

public class Product {
    private String code;
    private String description;
    private double price;
    private int stockQuantity;

    public Product(String code, String description, double price, int stockQuantity) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public boolean isInStock(int quantity) {
        return stockQuantity >= quantity;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
        }
    }

    public void increaseStock(int quantity) {
        stockQuantity += quantity;
    }

    @Override
    public String toString() {
        return code + ": " + description + " (" + price + "€, stock: " + stockQuantity + ")";
    }
}
