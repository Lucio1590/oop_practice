package org.lucian.module4.exercise3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Setup logger to log to a file
        try {
            FileHandler fh = new FileHandler("parse.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            System.out.println("Could not set up file logging: " + e.getMessage());
        }

        // Example input list
        String[] input = {"42", "abc", "100", "-7", "3.14", "200"};
        List<Integer> numbers = parseNumbers(input);
        System.out.println("Valid integers: " + numbers);
    }

    // Method to parse a list of numbers from strings
    public static List<Integer> parseNumbers(String[] input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            try {
                int num = Integer.parseInt(s);
                result.add(num);
            } catch (NumberFormatException e) {
                logger.warning("Could not parse '" + s + "' as integer. Skipping.");
            }
        }
        return result;
    }
}
