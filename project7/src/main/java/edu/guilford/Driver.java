package edu.guilford;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Project 7 - Text Analysis");
        System.out.println("-------------------------");
        System.out.println("Example 1: Bee Movie Script\n");
        System.out.println("Hit Enter to Read Data: ");

        // Example 1: Bee Movie Script

        // Create a data parser object for "bee_movie_script.txt" file located in resources
        DataParser parser = new DataParser("bee_movie_script.txt");

        // Pass ArrayList containing parsed words from parser into a DataProcessor object
        DataProcessor processor = new DataProcessor(parser.parseFile());

        // User Stop
        scanner.nextLine();

        // Print Cleaned Data
        for (String word : processor.getCleanedWords()) {
            System.out.println(word);
        }

        // Create DataWriter object and store data in output
        DataWriter dataWriter1 = new DataWriter(processor.getCleanedWords());
        dataWriter1.writeData("CLEANED_Bee_Movie_Script.txt");
        System.out.println("");
        System.out.println("Hit Enter to Read Analytics: ");

        // User Stop
        scanner.nextLine();

        // Print Analytics Data
        for (DataPoint analytic : processor.getWordFrequencyData()) {
            System.out.println(analytic);
        }
        System.out.println("");

        // Create a fileWriter using toString data of the DataPoint list
        DataWriter dataWriter2 = new DataWriter(
            processor.getWordFrequencyData().stream()
            .map(DataPoint::toString)
            .collect(Collectors.toCollection(ArrayList::new))
        );

        // Write data
        dataWriter2.writeData("ANALYZED_Bee_Movie_Script.txt");

        // Example 2: A thesis I found online on someone's Github
        System.out.println("-------------------------");
        System.out.println("Example 2: A Thesis I think?\n");
        System.out.println("Hit Enter to Read Data: ");

        // Create a data parser object for "sm_thesis.txt" file located in resources
        DataParser parserB = new DataParser("sm_thesis.txt");

        // Pass ArrayList containing parsed words from parser into a DataProcessor object
        DataProcessor processorB = new DataProcessor(parserB.parseFile());

        // User Stop
        scanner.nextLine();

        // Print Cleaned Data
        for (String word : processorB.getCleanedWords()) {
            System.out.println(word);
        }

        // Create DataWriter object and store data in output
        DataWriter dataWriter1B = new DataWriter(processorB.getCleanedWords());
        dataWriter1B.writeData("CLEANED_sm_thesis.txt");
        System.out.println("");
        System.out.println("Hit Enter to Read Analytics: ");

        // User Stop
        scanner.nextLine();

        // Print Analytics Data
        for (DataPoint analytic : processorB.getWordFrequencyData()) {
            System.out.println(analytic);
        }
        System.out.println("");

        // Create a fileWriter using toString data of the DataPoint list
        DataWriter dataWriter2B = new DataWriter(
            processorB.getWordFrequencyData().stream()
            .map(DataPoint::toString)
            .collect(Collectors.toCollection(ArrayList::new))
        );

        // Write data
        dataWriter2B.writeData("ANALYZED_sm_thesis.txt");
        System.out.println("");
    }
}