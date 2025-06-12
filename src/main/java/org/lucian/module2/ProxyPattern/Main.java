package org.lucian.module2.ProxyPattern;

public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("cat.png");
        Image img2 = new ProxyImage("dog.jpg");
        Image img3 = new ProxyImage("car.bmp");

        // Images are not loaded yet
        System.out.println("First display of cat.png:");
        img1.display(); // Loads and displays
        System.out.println("Second display of cat.png:");
        img1.display(); // Only displays

        System.out.println("First display of dog.jpg:");
        img2.display(); // Loads and displays
        System.out.println("First display of car.bmp:");
        img3.display(); // Loads and displays
        System.out.println("Second display of dog.jpg:");
        img2.display(); // Only displays
    }
}
