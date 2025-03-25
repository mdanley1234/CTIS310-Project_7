package edu.guilford;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriter {
    private ArrayList<String> data;

    // Constructor that takes an ArrayList of Strings
    public FileWriter(ArrayList<String> data) {
        this.data = data;
    }

    // Method to write data to a file
    public void writeData(String fileName) {
        // Create the output directory if it doesn't exist
        File outputDir = new File("project7/src/main/java/edu/guilford/output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        // Create the file in the output directory
        File file = new File(outputDir, fileName);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data successfully written to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
