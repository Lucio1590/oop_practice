package org.lucian.module2.ProxyPattern;

// ProxyImage controls access to RealImage and simulates lazy loading
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Loads only on first display
        }
        realImage.display();
    }
}
