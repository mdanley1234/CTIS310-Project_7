package edu.guilford;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code DataWriter} class handles writing a list of strings to a file.
 * It ensures that the output directory exists before creating the file.
 */
public class DataWriter {
    private ArrayList<String> data; // List of strings to be written to a file

    /**
     * Constructs a {@code DataWriter} with the specified data.
     *
     * @param data the list of strings to be written to a file
     */
    public DataWriter(ArrayList<String> data) {
        this.data = data;
    }

    /**
     * Writes the stored data to a file in the specified output directory.
     *
     * @param fileName the name of the file to write to
     */
    public void writeData(String fileName) {
        // Define the output directory
        File outputDir = new File("project7/src/main/java/edu/guilford/output");
        if (!outputDir.exists()) {
            outputDir.mkdir(); // Create directory if it does not exist
        }

        // Create the file in the output directory
        File file = new File(outputDir, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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