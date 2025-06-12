package org.lucian.module1;

import java.util.List;

public class strings {
    public static void threeStringsConcat(String a, String b, String c){
        List<String> strings = List.of(a, b, c);
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(" ");
        }
        String result = sb.toString().trim();
        System.out.println("Concatenated String: " + result);
         
        // revverse order: 

        StringBuilder reversed = new StringBuilder();

        for (int i = strings.size() - 1; i >= 0; i--) {
            reversed.append(strings.get(i)).append(" ");
        }
        // Remove the trailing space
        reversed.setLength(reversed.length() - 1); // Remove the last space

        String reversedResult = reversed.toString();
        System.out.println("Reversed String: " + reversedResult);
    }

    public static int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0; // Return 0 for null or empty strings
        }
        String[] words = str.trim().split(" "); // Split by whitespace
        return words.length; // Return the number of words
    }

    public static void extractSubstring(String str, int start) {
        if (str == null || start < 0 || start >= str.length()) {
            System.out.println("Invalid input for substring extraction.");
            return;
        }
        String substring = str.substring(start);
        System.out.println("Extracted Substring: " + substring);
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false; // Return false for null or empty strings
        }

        String cleanedStr = str.toLowerCase();

        StringBuilder reversedStr = new StringBuilder(cleanedStr).reverse();
        
        return cleanedStr.equals(reversedStr.toString());
    }

    public static int countOccurences(String str, char  c) {
        if (str == null || str.isEmpty()) {
            return 0; // Return 0 for null or empty strings
        }
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count; // Return the number of occurrences
    }

}
