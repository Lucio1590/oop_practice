package org.lucian.module6.exercise14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * CLI app to filter log files by date range, log level, and substring using Streams.
 */
public class LogFilterCLI {
    // Example log format: 2025-06-13 10:15:30 [INFO] Message
    private static final DateTimeFormatter LOG_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void run(String logFilePath) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter start date/time (yyyy-MM-dd HH:mm:ss) or leave blank: ");
            String startInput = scanner.nextLine().trim();
            System.out.print("Enter end date/time (yyyy-MM-dd HH:mm:ss) or leave blank: ");
            String endInput = scanner.nextLine().trim();
            System.out.print("Enter log level (INFO, WARN, ERROR) or leave blank: ");
            String levelInput = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter substring to match or leave blank: ");
            String substring = scanner.nextLine().trim();

            final LocalDateTime[] start = new LocalDateTime[1];
            final LocalDateTime[] end = new LocalDateTime[1];
            try {
                if (!startInput.isEmpty()) start[0] = LocalDateTime.parse(startInput, LOG_DATE_FORMAT);
                if (!endInput.isEmpty()) end[0] = LocalDateTime.parse(endInput, LOG_DATE_FORMAT);
            } catch (Exception e) {
                System.err.println("Invalid date format. Use yyyy-MM-dd HH:mm:ss");
                return;
            }

            Path path = Paths.get(logFilePath);
            try (Stream<String> lines = Files.lines(path)) {
                lines.filter(line -> filterByDate(line, start[0], end[0]))
                     .filter(line -> filterByLevel(line, levelInput))
                     .filter(line -> substring.isEmpty() || line.contains(substring))
                     .forEach(System.out::println);
            } catch (IOException e) {
                System.err.println("Error reading log file: " + e.getMessage());
            }
        }
    }

    private boolean filterByDate(String line, LocalDateTime start, LocalDateTime end) {
        try {
            String datePart = line.substring(0, 19);
            LocalDateTime logDate = LocalDateTime.parse(datePart, LOG_DATE_FORMAT);
            if (start != null && logDate.isBefore(start)) return false;
            return !(end != null && logDate.isAfter(end));
        } catch (Exception e) {
            return false; // skip lines with invalid date
        }
    }

    private boolean filterByLevel(String line, String level) {
        if (level == null || level.isEmpty()) return true;
        int idx1 = line.indexOf('[');
        int idx2 = line.indexOf(']');
        if (idx1 != -1 && idx2 != -1 && idx2 > idx1) {
            String logLevel = line.substring(idx1 + 1, idx2).toUpperCase();
            return logLevel.equals(level);
        }
        return false;
    }
}
