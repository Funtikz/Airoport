package org.example;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Searcher {
    private Trie<String, List<Integer>> data = new PatriciaTrie<>();

    public Searcher(Trie<String, List<Integer>> data) {
        this.data = data;
    }

    public HashMap<String, List<Integer>> searchByName(String name){
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<List<Integer>> collect = new ArrayList<>(data.prefixMap(name)
                .values());
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list :collect){
            result.addAll(list);
        }
        result = result.stream().sorted().collect(Collectors.toList());
        map.put(name, result);
        return map;
    }

}
