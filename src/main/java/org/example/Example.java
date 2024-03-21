package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\228fu\\IdeaProjects\\Airoport\\src\\main\\resources\\airports.csv";
        CSVReader csvReader = new CSVReader(path);
        List<String[]> listOfData = csvReader.readData();
        Searcher searcher = new Searcher(listOfData);
        Result result = searcher.searchByColumn("Bow", 1);
        System.out.println(result);
    }
}
