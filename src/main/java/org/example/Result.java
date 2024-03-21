package org.example;

import java.util.HashMap;
import java.util.List;


public class Result {
    private HashMap<String, List<Integer>> mapResult;
    public static String  timeReadFile;
    private String timeOneOperation;


    public String getNameOnHashMap(){
        String string = mapResult.keySet().toString();
        return string.replace("[", "").replace("]", "");
    }

    public String getIdOnHashMap(){
        String string = mapResult.values().toString();
        return string.replace("[", "").replace("]", "");
    }


    public Result() {
    }

    public HashMap<String, List<Integer>> getMapResult() {
        return mapResult;
    }

    public void setMapResult(HashMap<String, List<Integer>> mapResult) {
        this.mapResult = mapResult;
    }

    public static String getTimeReadFile() {
        return timeReadFile;
    }

    public static void setTimeReadFile(String timeReadFile) {
        Result.timeReadFile = timeReadFile;
    }

    public String getTimeOneOperation() {
        return timeOneOperation;
    }

    public void setTimeOneOperation(String timeOneOperation) {
        this.timeOneOperation = timeOneOperation;
    }

    @Override
    public String toString() {
        return "Result{" +
                "timeReadFile" + timeReadFile + "\n" +
                "mapResult=" + mapResult + "\n" +
                ", timeOneOperation='" + timeOneOperation + '\'' +
                '}';
    }
}
