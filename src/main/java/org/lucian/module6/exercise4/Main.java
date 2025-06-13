package org.lucian.module6.exercise4;

public class Main {
    public static void main(String[] args) {
        // Example usage: copy image.jpg from resources to a new file in resources
        String sourcePath = "src/main/resources/module6/exercise4/image.jpg";
        String destPath = "src/main/resources/module6/exercise4/image_copy.jpg";
        BinaryFileCopier copier = new BinaryFileCopier();
        copier.copyFile(sourcePath, destPath);
    }
}
