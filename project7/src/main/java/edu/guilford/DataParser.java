package edu.guilford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code DataParser} class is responsible for reading a file and extracting words from it.
 */
public class DataParser {
    private String fileName;

    /**
     * Constructs a {@code DataParser} with the specified file name.
     *
     * @param fileName the name of the file to be parsed
     */
    public DataParser(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Parses the file and returns an {@code ArrayList} of words found in the file.
     *
     * @return an {@code ArrayList} containing words from the file
     */
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