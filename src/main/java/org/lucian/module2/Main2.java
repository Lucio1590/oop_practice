package org.lucian.module2;

public class Main2 {
    @SuppressWarnings("unused")
    public static void main() {
        // // Create a Car object with all parameters
        // Car car1 = new Car("Toyota", "Camry", 2020);
        // System.out.println("Car 1: " + car1);

        // // Create a Car object with only brand and model, default year
        // Car car2 = new Car("Honda", "Civic");
        // System.out.println("Car 2: " + car2);

        // // Create a Car object with different parameters
        // Car car3 = new Car("Ford", "Mustang", 2021);
        // System.out.println("Car 3: " + car3);

        
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        System.out.println("Total instances created: " + Counter.count);

    }
    
}
