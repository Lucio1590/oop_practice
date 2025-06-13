package org.lucian.module6.exercise1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Load the file as a resource from src/main/resources/module6/exercise1/example.txt
        String fileName = "/module6/exercise1/example.txt";
        try (InputStream is = Main.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Error reading resource file: " + e.getMessage());
        }
    }
}
