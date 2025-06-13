package org.lucian.module6.exercise13;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        System.out.println("Initial content: '" + editor.getText() + "'");

        // Step 1: Add text
        editor.setText("Hello");
        System.out.println("After setText: '" + editor.getText() + "'");

        // Step 2: Append text
        editor.appendText(", world!");
        System.out.println("After appendText: '" + editor.getText() + "'");

        // Step 3: Edit text
        editor.setText("Hello, Java world!");
        System.out.println("After setText: '" + editor.getText() + "'");

        // Step 4: Undo last change
        editor.undo();
        System.out.println("After undo: '" + editor.getText() + "'");

        // Step 5: Undo again
        editor.undo();
        System.out.println("After second undo: '" + editor.getText() + "'");

        // Step 6: Undo again
        editor.undo();
        System.out.println("After third undo: '" + editor.getText() + "'");
    }
}
