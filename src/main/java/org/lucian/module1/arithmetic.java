package org.lucian.module1;

public class arithmetic {
    public static void twoFloatsDemo(float x, float y){

        //NOTE:

        // float f = 1.23456789f;   // 7 decimal digits precision
        //s double d = 1.2345678901234567; // 15-16 decimal digits precision
        
        //SUM
        float sum = x + y;
        System.out.println("Sum of " + x + " and " + y + " is: " + sum);
        //NOTE: The sum of two floats may not be exact due to precision issues.
        // For example, if x = 0.1f and y = 0.2f, the sum may not be exactly 0.3f.
        // This is because floats are represented in binary, and some decimal fractions cannot be represented exactly in binary.
        //TIP: Use double for more precision if needed.
        double preciseSum = (double) x + (double) y;
        System.out.println("Precise sum of " + x + " and " + y + " is: " + preciseSum);

        //DIFFERENCE
        float difference = x - y;
        System.out.println("Difference of " + x + " and " + y + " is: " + difference);
        //NOTE: The difference of two floats may also not be exact due to precision issues.
        double preciseDifference = (double) x - (double) y;
        System.out.println("Precise difference of " + x + " and " + y + " is: " + preciseDifference);

        //PRODUCT
        float product = x * y;
        System.out.println("Product of " + x + " and " + y + " is: " + product);
        //NOTE: The product of two floats is usually more precise than the sum or difference.
        double preciseProduct = (double) x * (double) y;
        System.out.println("Precise product of " + x + " and " + y + " is: " + preciseProduct);
        //QUOTIENT
        if (y != 0) {
            float quotient = x / y;
            System.out.println("Quotient of " + x + " and " + y + " is: " + quotient);
            double preciseQuotient = (double) x / (double) y;
            System.out.println("Precise quotient of " + x + " and " + y + " is: " + preciseQuotient);
        } else {
            System.out.println("Cannot divide by zero.");
        }
        //NOTE: Division by zero is not allowed, so we check if y is not zero before performing the division.
        //TIP: Always check for division by zero to avoid runtime errors.
        //MODULUS
        if (y != 0) {
            float modulus = x % y;
            System.out.println("Modulus of " + x + " and " + y + " is: " + modulus);
            double preciseModulus = (double) x % (double) y;
            System.out.println("Precise modulus of " + x + " and " + y + " is: " + preciseModulus);
        } else {
            System.out.println("Cannot perform modulus with zero.");
        }
        //NOTE: Modulus operation is similar to division, so we also check if y is not zero before performing the modulus.
        //TIP: Use double for more precision if needed.
        //COMPARISON
        if (x > y) {
            System.out.println(x + " is greater than " + y);
        } else if (x < y) {
            System.out.println(x + " is less than " + y);
        } else {
            System.out.println(x + " is equal to " + y);
        }
        //NOTE: Comparison of floats is straightforward, but be aware of precision issues.
        //TIP: Use double for more precision if needed.
        //EQUALITY
        if (x == y) {
            System.out.println(x + " is equal to " + y);
        } else {
            System.out.println(x + " is not equal to " + y);
        }
        //NOTE: Equality check for floats can be tricky due to precision issues.
        //TIP: Use a small epsilon value to check for equality if needed.
        float epsilon = 0.00001f; // small value to check for equality
        if (Math.abs(x - y) < epsilon) {
            System.out.println(x + " is approximately equal to " + y);
        } else {
            System.out.println(x + " is not approximately equal to " + y);
        }
        //NOTE: This is a common technique to check for equality of floating-point numbers.
        //TIP: Use double for more precision if needed.
        //CONVERSION
        int xInt = (int) x;
        int yInt = (int) y;
        System.out.println("Converted " + x + " to int: " + xInt);
        System.out.println("Converted " + y + " to int: " + yInt);
        //NOTE: Converting float to int truncates the decimal part.
        //TIP: Use Math.round() to round to the nearest integer if needed.
        double xDouble = (double) x;
        double yDouble = (double) y;
        System.out.println("Converted " + x + " to double: " + xDouble);
        System.out.println("Converted " + y + " to double: " + yDouble);
        //NOTE: Converting float to double preserves the decimal part.
        //TIP: Use double for more precision if needed.
        //STRING CONVERSION
        String xString = Float.toString(x);
        String yString = Float.toString(y);
        System.out.println("Converted " + x + " to String: " + xString);
        System.out.println("Converted " + y + " to String: " + yString);
        //NOTE: Converting float to String is straightforward.
        //TIP: Use String.format() or String.valueOf() for more control over the format if needed.
        //PARSE STRING TO FLOAT
        String xStringToParse = "1.23";
        String yStringToParse = "4.56";
        try {
            float xParsed = Float.parseFloat(xStringToParse);
            float yParsed = Float.parseFloat(yStringToParse);
            System.out.println("Parsed " + xStringToParse + " to float: " + xParsed);
            System.out.println("Parsed " + yStringToParse + " to float: " + yParsed);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing string to float: " + e.getMessage());
        }
        //NOTE: Parsing a string to float can throw a NumberFormatException if the string is not a valid float.
        //TIP: Always handle exceptions when parsing strings to numbers to avoid runtime errors.
    }

    public static double largestBetweenThreeNumbers(double a, double b, double c) {
        if(a >= b && a >= c) {
            return a;
        } else if(b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void realRootsCalculator(double a, double b, double c) {
        if (a == 0) {
            System.err.println("Coefficient 'a' cannot be zero. Not a quadratic equation.");
            return;
        }
        // -b +(sqrt(b**2 (-4 * a * c)))
        double delta = (b * b) - (4 * a * c);

        if(delta < 0){
            System.err.println("no real Roots");
            return;
        }



        double root1 = (-b + Math.sqrt(delta)) / ( 2*a );
        double root2 = (-b - Math.sqrt(delta)) / ( 2*a );
        
        
        System.out.println("Roots are: " + root1 + " and " + root2);
    }

    public static double  perimeterRectangle(double length, double width){
        return 2 * (length + width);
    }


    /**
     * function that returns 0 if a number is even and 1 if it is odd
     * @returns int
     */
    public static int isOdd(int n){
        return n % 2;
    }

    public static double heronsArea(double a, double b, double c){
        // Area = √(s(s - a)(s - b)(s - c))
        double s = ( a + b + c ) / 2;
        return  Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }


    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        if (n == 0 || n == 1) {
            return 1; // Base case: 0! = 1 and 1! = 1
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // Multiply result by each number from 2 to n
        }
        return result;
    }

    public static int fib(int n){

        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        if (n <= 2) {
            return 1; // Base case: 0! = 1 and 1! = 1
        }

        return fib(n-1) + fib(n-2);

    }
}
