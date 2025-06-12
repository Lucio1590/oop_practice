package org.lucian.module2.ProxyPattern;

// RealImage simulates loading and displaying an image
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        loadFromDisk(filename);
        this.filename = filename;
    }

    private void loadFromDisk(String filename) {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
