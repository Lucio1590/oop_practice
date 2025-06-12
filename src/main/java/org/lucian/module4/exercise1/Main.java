package org.lucian.module4.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        divide100ByUserInput();
    }

    public static void divide100ByUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            int result = 100 / number;
            System.out.println("100 divided by " + number + " is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Oops! You can't divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer number.");
        }
    }
}
