package org.example;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Searcher {
    private Trie<String, Integer> data = new PatriciaTrie<>();

    public Searcher(Trie<String, Integer> data) {
        this.data = data;
    }

    public HashMap<String, List<Integer>> searchByName(String name){
        HashMap<String, List<Integer>> map = new HashMap();
        List<Integer> collect = data.prefixMap(name).values().stream().sorted().collect(Collectors.toList());
        map.put(name, collect);
        return map;
    }

}
