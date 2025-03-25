package edu.guilford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {
    private String fileName;

    // Constructor that requests a file name
    public FileParser(String fileName) {
        this.fileName = fileName;
    }

    // Method to parse the file and return an ArrayList of words
    public ArrayList<String> parseFile() {
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println("File not found: " + fileName);
            System.exit(1);
        }
        return words;
    }
}
