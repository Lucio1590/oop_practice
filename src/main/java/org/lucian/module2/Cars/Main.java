package org.lucian.module2.Cars;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setBrand("Toyota")
                .setModel("Camry")
                .setEngineType("Hybrid")
                .addFeature("Sunroof")
                .addFeature("GPS")
                .build();

        Car car2 = new Car.CarBuilder()
                .setBrand("BMW")
                .setModel("X5")
                .setEngineType("Diesel")
                .addFeature("Heated seats")
                .addFeature("GPS")
                .build();

        Car car3 = new Car.CarBuilder()
                .setBrand("Tesla")
                .setModel("Model S")
                .setEngineType("Electric")
                .addFeature("Autopilot")
                .addFeature("Sunroof")
                .addFeature("Heated seats")
                .build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
