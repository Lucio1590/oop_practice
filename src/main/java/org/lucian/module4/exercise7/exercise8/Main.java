package org.lucian.module4.exercise7.exercise8;

public class Main {
    public static void main(String[] args) {
        try {
            // This code is intentionally designed to throw a NullPointerException
            String s = null;
            System.out.println(s.length());
        } catch (Exception e) {
            // logs the exception message to the console
            // This is a simple way to log the exception, but in a real application,
            // you would typically use a logging framework like Log4j or SLF4J.
            // Here we just print the exception message to the console
            // to simulate logging.
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}
// Safe code here:
// public class Main {
//     public static void main(String[] args) {
//         try {
//             String s = null;
//             System.out.println(s.length());
//         } catch (NullPointerException e) {
//              // Log the exception message
//             System.err.println("NullPointerException: variabile non inizializzata.");
//         } catch (Exception e) {
//             // Loggs the exception stack trace 
//             e.printStackTrace();
//         }
//     }
// }