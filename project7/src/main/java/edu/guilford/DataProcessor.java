package edu.guilford;

import java.util.ArrayList;

public class DataProcessor {

    // Holds raw string data from parser
    ArrayList<String> rawData;

    // Holds cleaned string data from parser
    ArrayList<String> cleanedData;

    // Holds data analytics about the quantity of each string
    ArrayList<DataPoint> analyticsData;

    public DataProcessor(ArrayList<String> rawData) {
        this.rawData = rawData;
        CleanData();
        analyzeData();
    }

    /**
     * The CleanData method cleans the strings from the rawData ArrayList by
     * removing punctuation and spaces, non-words, and numbers. It also sets all
     * characters to lowercase and sorts the list alphabetically.
     */
    private void CleanData() {
        cleanedData = new ArrayList<>();

        for (String rawDataElement : rawData) {
            StringBuilder cleanDataElement = new StringBuilder();
            for (char currentChar : rawDataElement.toLowerCase().toCharArray()) {
                if ((currentChar >= 'a' && currentChar <= 'z')
                        || (currentChar >= '0' && currentChar <= '9')
                        || (currentChar == '-')) {
                    cleanDataElement.append(currentChar);
                }
            }

            // If the cleanDataElement contains letters and not just numbers, add to the cleanData ArrayList
            if (cleanDataElement.toString().matches(".*[a-z].*")) {
                cleanedData.add(cleanDataElement.toString());
            }
        }

        // Sort data alphabetically
        cleanedData.sort(String::compareToIgnoreCase);
    }

    private void analyzeData() {
        analyticsData = new ArrayList<>();

        for (String cleanDataElement : cleanedData) {
            boolean dataPointFound = false;
            for (DataPoint dataPoint : analyticsData) {
                if (dataPoint.getStringElement().equals(cleanDataElement)) {
                    dataPoint.incrementQuantity();
                    dataPointFound = true;
                    break;
                }
            }
            if (!dataPointFound) {
                analyticsData.add(new DataPoint(cleanDataElement));
            }
        }

        analyticsData.sort(DataPoint::compareTo);
    }

    // Data Getters
    public ArrayList<String> getCleanedData() {
        return cleanedData;
    }

    public ArrayList<DataPoint> getAnalyticsData() {
        return analyticsData;
    }


}
