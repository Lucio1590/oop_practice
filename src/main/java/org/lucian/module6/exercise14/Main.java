package org.lucian.module6.exercise14;

public class Main {
    public static void main(String[] args) {
        // Example usage: filter a log file in resources/module6
        String logFilePath = "src/main/resources/module6/errors.log"; // Change to your log file path
        LogFilterCLI cli = new LogFilterCLI();
        cli.run(logFilePath);
    }
}
