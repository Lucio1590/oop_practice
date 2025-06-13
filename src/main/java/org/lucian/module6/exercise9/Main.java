package org.lucian.module6.exercise9;

public class Main {
    public static void main(String[] args) {
        // Directory path in resources
        String dirPath = "src/main/resources/module6";
        TxtFileLister lister = new TxtFileLister();
        System.out.println(".txt files in directory '" + dirPath + "':");
        lister.printTxtFiles(dirPath);
    }
}
