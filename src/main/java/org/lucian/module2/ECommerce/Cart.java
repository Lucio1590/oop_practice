package org.lucian.module2.ECommerce;

public class Cart {
    private Customer customer;
    private Product[] products;
    private int[] quantities;
    private int productCount;
    private double totalCost;

    public Cart(Customer customer) {
        this.customer = customer;
        this.products = new Product[10]; // max 10 products for simplicity
        this.quantities = new int[10];
        this.productCount = 0;
        this.totalCost = 0.0;
    }

    public boolean addProduct(Product product, int quantity) {
        if (!product.isInStock(quantity)) {
            System.out.println("Not enough stock for product: " + product.getDescription());
            return false;
        }
        // Check if product already in cart
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCode().equals(product.getCode())) {
                if (product.isInStock(quantities[i] + quantity)) {
                    quantities[i] += quantity;
                    product.reduceStock(quantity);
                    recalculateTotal();
                    return true;
                } else {
                    System.out.println("Not enough stock to add more of this product.");
                    return false;
                }
            }
        }
        // Add new product
        if (productCount < products.length) {
            products[productCount] = product;
            quantities[productCount] = quantity;
            product.reduceStock(quantity);
            productCount++;
            recalculateTotal();
            return true;
        } else {
            System.out.println("Cart is full.");
            return false;
        }
    }

    public boolean removeProduct(String productCode) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCode().equals(productCode)) {
                // Restore stock
                products[i].increaseStock(quantities[i]);
                // Shift left
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[productCount - 1] = null;
                quantities[productCount - 1] = 0;
                productCount--;
                recalculateTotal();
                return true;
            }
        }
        System.out.println("Product not found in cart.");
        return false;
    }

    private void recalculateTotal() {
        totalCost = 0.0;
        for (int i = 0; i < productCount; i++) {
            totalCost += products[i].getPrice() * quantities[i];
        }
    }

    public void printCartDetails() {
        System.out.println(customer);
        System.out.println("Cart contents:");
        for (int i = 0; i < productCount; i++) {
            System.out.println("  " + products[i] + ", Quantity: " + quantities[i]);
        }
        System.out.println("Total cost: " + totalCost + " €");
    }
}
