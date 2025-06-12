package org.lucian.module2.DocumentManagementSystem;

// Factory class to create documents based on type
public class DocumentFactory {
    public static Document createDocument(String type) {
        switch (type) {
            case "PDF" -> {
                return new PDFDocument();
            }
            case "Word" -> {
                return new WordDocument();
            }
            case "Text" -> {
                return new TextDocument();
            }
            default -> throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
