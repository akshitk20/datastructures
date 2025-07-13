package com.practice.leetcode.daily.july25;

import java.util.Arrays;

public class MaxMatchingPlayersTrainers2410_13 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int playerIndex = 0, trainersIndex = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while (playerIndex < players.length && trainersIndex < trainers.length) {
            if (players[playerIndex] <= trainers[trainersIndex]) {
                playerIndex++;
            }
            trainersIndex++;
        }

        return playerIndex;
    }
}
