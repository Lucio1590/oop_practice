package org.lucian.module2.DocumentManagementSystem;

// Concrete class for Text documents
public class TextDocument extends Document {
    @Override
    public void generate() {
        System.out.println("Generating a Text document...");
    }
}
