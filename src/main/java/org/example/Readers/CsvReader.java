package org.example.Readers;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private final String filePath;

    public CsvReader(String filePath) {
        this.filePath = filePath;
    }

    public Trie<String, List<Integer> > readData(Integer column) {
        Trie<String, List<Integer>> trie = new PatriciaTrie<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] data = line.split(",");
                List<Integer> list = new ArrayList<>();
                if (trie.containsKey(data[column-1])){
                     trie.get(data[column-1]).add(Integer.valueOf(data[0]));
                }
                else {
                    list.add(Integer.valueOf(data[0]));
                    trie.put(data[column-1], list);
                }
            }
        } catch (IOException e) {
            System.err.println("Не верный путь к CSV файлу: " + e.getMessage());
        }
        return trie;
    }

}
