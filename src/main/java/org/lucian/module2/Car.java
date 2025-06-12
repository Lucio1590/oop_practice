package org.lucian.module2;

public class Car {
    private String brand;
    private String model;
    private int year;

    // constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car(String brand, String model) {
        this(brand, model, 2025); // Default year to 2025
    }
}
