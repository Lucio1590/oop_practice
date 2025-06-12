package org.lucian.module2.DocumentManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Use the factory to create different document types
        Document pdf = DocumentFactory.createDocument("PDF");
        Document word = DocumentFactory.createDocument("Word");
        Document text = DocumentFactory.createDocument("Text");

        // Simulate document generation
        pdf.generate();
        word.generate();
        text.generate();


        // check if the documents are instances of their respective classes
        System.out.println("Is pdf a PDFDocument? " + (pdf instanceof PDFDocument));
        System.out.println("Is word a WordDocument? " + (word instanceof WordDocument));
        System.out.println("Is text a TextDocument? " + (text instanceof TextDocument));
        // check if the documents are instances of the Document class
        System.out.println("Is pdf a Document? " + (pdf instanceof Document));
        System.out.println("Is word a Document? " + (word instanceof Document));
        System.out.println("Is text a Document? " + (text instanceof Document));
        // check if the documents are instances of the DocumentFactory class
        System.out.println("Is DocumentFactory a Document? " + (DocumentFactory.createDocument("PDF") instanceof Document));
        System.out.println("Is DocumentFactory a PDFDocument? " + (DocumentFactory.createDocument("PDF") instanceof PDFDocument));
        System.out.println("Is DocumentFactory a WordDocument? " + (DocumentFactory.createDocument("Word") instanceof WordDocument));
        System.out.println("Is DocumentFactory a TextDocument? " + (DocumentFactory.createDocument("Text") instanceof TextDocument));
    }
}
