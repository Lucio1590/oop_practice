package org.lucian.module1;

public class variables {
    public static void variablesDemo(){
        String name = "Lucian";
        int age = 24;
        double height = 1.87;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "m");

        // experimenting type conversion
        // 1
        int ageInMonths = age * 12;
        System.out.println("Age in months: " + ageInMonths);
        // 2 double to int conversion
        int heightInCm = (int) (height * 100);
        System.out.println("Height in cm: " + heightInCm);
        // 3 int to double conversion
        double ageInYears = (double) age;
        System.out.println("Age in years (as double): " + ageInYears);
        // string to int conversion
        String ageString = "24";
        int ageFromString = Integer.parseInt(ageString);
        System.out.println("Age from string: " + ageFromString);
    }
}
