package org.lucian.module2.Cars;

import java.util.HashSet;
import java.util.Set;

public class Car {
    private String brand;
    private String model;
    private String engineType;
    private Set<String> features;

    private Car(String brand, String model, String engineType, Set<String> features) {
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.features = features;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getEngineType() { return engineType; }
    public Set<String> getFeatures() { return features; }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", features=" + features +
                '}';
    }

    public static class CarBuilder {
        private String brand;
        private String model;
        private String engineType;
        private Set<String> features = new HashSet<>();

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder addFeature(String feature) {
            this.features.add(feature);
            return this;
        }

        public Car build() {
            return new Car(brand, model, engineType, features);
        }
    }
}
