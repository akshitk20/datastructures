package com.practice.leetcode.daily.jan25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets916_10 {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < words1.length ; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(Character ch : words1[i].toCharArray()) {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            int count = 0;
            int j = 0;
            for (Character ch : words2[j].toCharArray()) {
                Map<Character, Integer> map2 = new HashMap<>();
                map2.put(ch, map2.getOrDefault(ch,0)+1);
                for (Character key : map2.keySet()) {
                    if (map.get(key)!= null && map.get(key) >= map2.get(key)) {
                        count++;
                    }
                }
                j++;
            }
            System.out.println(count);
            if (count == words2.length) {
                result.add(words1[i]);
            }
        }
        return result;
    }

    // todo: debug this
    public static void main(String[] args) {
        String[] words1 = new String[] {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = new String[] {"e","o"};
        System.out.println(wordSubsets(words1, words2));
    }
}
