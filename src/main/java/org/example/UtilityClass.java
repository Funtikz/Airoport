package org.example;


public class UtilityClass {
   private String pathToCSV;
   private Integer column;
   private String pathToTxt;
   private String pathToJson;


    public String getPathToCSV() {
        return pathToCSV;
    }

    public void setPathToCSV(String pathToCSV) {
        this.pathToCSV = pathToCSV;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getPathToTxt() {
        return pathToTxt;
    }

    public void setPathToTxt(String pathToTxt) {
        this.pathToTxt = pathToTxt;
    }

    public String getPathToJson() {
        return pathToJson;
    }

    public void setPathToJson(String pathToJson) {
        this.pathToJson = pathToJson;
    }

    public UtilityClass(String pathToCSV, Integer column, String pathToTxt, String pathToJson) {
        this.pathToCSV = pathToCSV;
        this.column = column;
        this.pathToTxt = pathToTxt;
        this.pathToJson = pathToJson;
    }

    public UtilityClass(){

    }

    @Override
    public String toString() {
        return "UtilityClass{" +
                "pathToCSV='" + pathToCSV + '\'' +
                ", column=" + column +
                ", pathToTxt='" + pathToTxt + '\'' +
                ", pathToJson='" + pathToJson + '\'' +
                '}';
    }
}
