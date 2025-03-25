package edu.guilford;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Bee Movie Test");

        FileParser parser = new FileParser("bee_movie_script.txt");
        DataProcessor processor = new DataProcessor(parser.parseFile());
        for (DataPoint point : processor.getAnalyticsData()) {
            System.out.println(point.toString());
        }

        FileWriter fileWriter = new FileWriter(
            processor.getAnalyticsData().stream()
            .map(DataPoint::toString)
            .collect(Collectors.toCollection(ArrayList::new))
        );
        fileWriter.writeData("ANALYZED_Bee_Movie_Script.txt");
    }
}