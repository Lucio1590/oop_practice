package org.lucian.module5.exercise9;

public class Product {
    private final String name;
    private final String category;
    private final double price;
    private final int sales;

    public Product(String name, String category, double price, int sales) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.sales = sales;
    }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getSales() { return sales; }
    @Override
    public String toString() {
        return String.format("Product{name='%s', category='%s', price=%.2f, sales=%d}", name, category, price, sales);
    }
}
