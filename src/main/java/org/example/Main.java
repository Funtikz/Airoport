package org.example;


import org.apache.commons.collections4.Trie;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Example {
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

        CSVReader csvReader = new CSVReader(utilityClass.getPathToCSV());
        Trie<String, Integer> data = csvReader.readData(utilityClass.getColumn());
        System.out.println("Все выполнено успешно!");
    }
}

