package org.example;

import java.util.ArrayList;
import java.util.List;

public class AirportSearcher {
    private List<Airoport> airoports = new ArrayList<>();

    public AirportSearcher(List<Airoport> airoports) {
        this.airoports = airoports;
    }

    public List<Integer> searchByName(String name){
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i< airoports.size(); i++){
            if (airoports.get(i).getName().startsWith(name)){
                result.add(airoports.get(i).getId());
            }
        }
        return  result;
    }
}
