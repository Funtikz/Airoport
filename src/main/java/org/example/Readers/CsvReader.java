package org.example.Readers;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    private String filePath;

    public CsvReader(String filePath) {
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
