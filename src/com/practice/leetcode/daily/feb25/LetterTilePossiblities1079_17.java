package com.practice.leetcode.daily.feb25;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossiblities1079_17 {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] isUsed = new boolean[tiles.length()]; // keep track of used index
        numTile(tiles, new StringBuilder(), set, isUsed);
        return set.size()-1;
    }

    public void numTile(String tiles, StringBuilder str, Set<String> set, boolean[] used) {
        set.add(str.toString());
        for (int index = 0 ; index < tiles.length() ; index++) {
            if (!used[index]) {
                used[index] = true;
                str.append(tiles.charAt(index));
                numTile(tiles, str , set, used);
                str.deleteCharAt(str.length()-1); //backtracking
                used[index] = false;
            }
        }
    }
}
