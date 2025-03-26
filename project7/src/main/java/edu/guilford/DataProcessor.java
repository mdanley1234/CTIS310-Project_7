package edu.guilford;

import java.util.ArrayList;

/**
 * The {@code DataProcessor} class processes raw string data by cleaning and analyzing it.
 * It removes punctuation, converts characters to lowercase, filters non-word elements,
 * sorts the cleaned data, and generates analytics on word frequency.
 */
public class DataProcessor {

    private ArrayList<String> rawWords; // Holds raw string data
    private ArrayList<String> cleanedWords; // Holds cleaned and filtered words
    private ArrayList<DataPoint> wordFrequencyData; // Stores word frequency analytics

    /**
     * Constructs a {@code DataProcessor} with the provided raw word list.
     *
     * @param rawWords the list of raw words to be processed
     */
    public DataProcessor(ArrayList<String> rawWords) {
        this.rawWords = rawWords;
        cleanWords();
        analyzeWordFrequency();
    }

    /**
     * Cleans the words in the raw word list by removing punctuation, filtering non-words,
     * converting to lowercase, and sorting alphabetically.
     */
    private void cleanWords() {
        cleanedWords = new ArrayList<>();

        for (String word : rawWords) {
            StringBuilder cleanedWord = new StringBuilder();
            for (char character : word.toLowerCase().toCharArray()) {
                if ((character >= 'a' && character <= 'z') ||
                    (character >= '0' && character <= '9') ||
                    (character == '-')) {
                    cleanedWord.append(character);
                }
            }

            // Ensure the cleaned word contains at least one letter before adding
            if (cleanedWord.toString().matches(".*[a-z].*")) {
                cleanedWords.add(cleanedWord.toString());
            }
        }

        // Sort words alphabetically
        cleanedWords.sort(String::compareToIgnoreCase);
    }

    /**
     * Analyzes word frequency by counting occurrences of each cleaned word.
     * Stores results in {@code wordFrequencyData} sorted by frequency.
     */
    private void analyzeWordFrequency() {
        wordFrequencyData = new ArrayList<>();

        for (String word : cleanedWords) {
            boolean found = false;
            for (DataPoint dataPoint : wordFrequencyData) {
                if (dataPoint.getStringElement().equals(word)) {
                    dataPoint.incrementQuantity();
                    found = true;
                    break;
                }
            }
            if (!found) {
                wordFrequencyData.add(new DataPoint(word));
            }
        }

        wordFrequencyData.sort(DataPoint::compareTo);
    }

    /**
     * Retrieves the cleaned words after processing.
     *
     * @return a list of cleaned words
     */
    public ArrayList<String> getCleanedWords() {
        return cleanedWords;
    }

    /**
     * Retrieves the word frequency analytics data.
     *
     * @return a list of {@code DataPoint} objects representing word frequency
     */
    public ArrayList<DataPoint> getWordFrequencyData() {
        return wordFrequencyData;
    }
}