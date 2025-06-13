package org.lucian.module4.exercise5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Qui chiamiamo processData() e gestiamo l'eccezione solo qui
        try {
            processData();
            System.out.println("File letto e processato con successo.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la lettura del file: " + e.getMessage());
        }
    }

    // Questo metodo chiama readFile() e PROPAGA l'eccezione
    public static void processData() throws IOException {
        readFile();
    }

    // Questo metodo simula la lettura di un file e può lanciare IOException
    public static void readFile() throws IOException {
        try ( // Prova a leggere un file che probabilmente non esiste per mostrare la propagazione
                BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }
}
