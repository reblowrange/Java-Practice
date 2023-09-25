package org.example.funtru;

import org.example.funtru.model.Key;

import java.util.HashMap;
import java.util.Map;

public class HashMapWorking {
    public static void main(String[] s) {
        Map<Key, Integer> map = new HashMap<>();
        map.put(new Key("abc"), 20);
        map.put(new Key("xyz"), 30);
        map.put(new Key("abx"), 40);

        map.keySet().forEach( x-> System.out.println(map.get(new Key("abc"))));
    }
}
