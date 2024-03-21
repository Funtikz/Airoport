package org.example;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {
    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public Trie<String, Integer> readData(Integer column) {
        Trie<String, Integer> trie = new PatriciaTrie<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] data = line.split(",");
                trie.put(data[column-1], Integer.valueOf(data[0]));
            }
        } catch (IOException e) {
            System.err.println("Не верный путь к CSV файлу: " + e.getMessage());
        }
        return trie;
    }

}
