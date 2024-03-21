package org.example;

import org.example.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonHelper {
    private String path;

    public JsonHelper(String path) {
        this.path = path;
    }

    public void createOrUpdate(List<Result> results) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"initTime\":").append(Result.getTimeReadFile()).append(", ");
            sb.append("\"result\":[");
            sb.append("\n");
            for (int i = 0; i < results.size(); i++) {
                Result result = results.get(i);
                sb.append("{");
                sb.append("\"search\":\"").append(result.getNameOnHashMap()).append("\", ");
                sb.append("\"result\":").append("[").append(result.getIdOnHashMap()).append("]").append(", ");
                sb.append("\"time\":").append(result.getTimeOneOperation());
                sb.append("}");
                if (i < results.size() - 1) {
                    sb.append(", ");
                }
                sb.append("\n");

            }
            sb.append("]");
            sb.append("}");
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в JSON файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
