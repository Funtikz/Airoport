package org.example.Readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {
    private String path;

    public String getPath() {
        return path;
    }

    public TxtReader(String path) {
        this.path = path;
    }

    public List<String> read(){
        List<String>  result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.err.println("Не верный путь к txt файлу!" + e.getMessage());
        }
        return  result;
    }
}
