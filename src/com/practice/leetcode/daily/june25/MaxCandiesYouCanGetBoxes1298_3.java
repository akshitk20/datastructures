package com.practice.leetcode.daily.june25;

import java.util.HashSet;
import java.util.Set;

public class MaxCandiesYouCanGetBoxes1298_3 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candiesCollected = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> foundBoxes = new HashSet<>();

        for (int box : initialBoxes) {
            candiesCollected += dfs(box, candies, status, keys, containedBoxes, visited, foundBoxes);
        }
        return candiesCollected;
    }

    public int dfs(int box, int[] candies, int[] status, int[][] keys, int[][] containedBoxes, Set<Integer> visited, Set<Integer> foundBoxes) {
        if (visited.contains(box)) {
            return 0;
        }

        if (status[box] == 0) {
            foundBoxes.add(box); // can be opened in future
            return 0;
        }

        visited.add(box);
        int candiesCollected = candies[box];

        for (int ngbr : containedBoxes[box]) {
            candiesCollected += dfs(ngbr, candies, status, keys, containedBoxes, visited, foundBoxes);
        }

        for (int key : keys[box]) {
            status[key] = 1;
            if (foundBoxes.contains(key)) {
                candiesCollected += dfs(key, candies, status, keys, containedBoxes, visited, foundBoxes);
            }
        }

        return candiesCollected;
    }
}
