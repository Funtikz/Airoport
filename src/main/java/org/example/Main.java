package org.example;

import org.apache.commons.collections4.Trie;
import org.example.Readers.CsvReader;
import org.example.Readers.TxtReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        if (args.length != 8) {
            System.err.println("Неверное количество аргументов.");
            System.exit(1);
        }

        UtilityClass utilityClass = new UtilityClass();

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "--data":
                    utilityClass.setPathToCSV(args[i + 1]);
                    break;
                case "--indexed-column-id":
                    utilityClass.setColumn(Integer.parseInt(args[i + 1]));
                    break;
                case "--input-file":
                   utilityClass.setPathToTxt(args[i+1]);
                   break;
                case "--output-file":
                    utilityClass.setPathToJson(args[i+1]);
                    break;
                default:
                    System.err.println("Неизвестный аргумент: " + args[i]);
                    System.exit(1);
            }
        }

        long startTime = System.currentTimeMillis();
        CsvReader csvReader = new CsvReader(utilityClass.getPathToCSV());
        Trie<String, Integer> dataCSV = csvReader.readData(utilityClass.getColumn());
        TxtReader txtReader = new TxtReader(utilityClass.getPathToTxt());
        List<String> dataTXT = txtReader.read();
        Searcher searcher = new Searcher(dataCSV);
        long endTime = System.currentTimeMillis();
        Result.setTimeReadFile(String.valueOf(endTime-startTime));
        List<Result> listOfResult = new ArrayList<>();


        for (String s : dataTXT) {
            Result result = new Result();
            long start = System.currentTimeMillis();
            HashMap<String, List<Integer>> stringListHashMap = searcher.searchByName(s);
            long stop = System.currentTimeMillis();
            result.setMapResult(stringListHashMap);
            result.setTimeOneOperation(String.valueOf(stop - start));
            listOfResult.add(result);
        }

        JsonHelper jsonHelper = new JsonHelper(utilityClass.getPathToJson());
        jsonHelper.createOrUpdate(listOfResult);
    }
}

