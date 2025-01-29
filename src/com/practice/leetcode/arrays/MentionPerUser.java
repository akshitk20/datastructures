package com.practice.leetcode.arrays;

import java.util.List;

public class MentionPerUser {
    // todo : do again vvimp
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            return timeA==timeB ? b.get(0).compareTo(a.get(0)) : timeA-timeB;
        });

        for (List<String> event : events) {
            if (event.get(0).equals("MESSAGE")) {
                handleMessage(event, mentions, offlineTime);
            } else {
                handleOffline(event, offlineTime);
            }
        }
        return mentions;

    }

    public void handleOffline(List<String> event, int[] offlineTime) {
        int timeStamp = Integer.parseInt(event.get(1));
        int id = Integer.parseInt(event.get(2));
        offlineTime[id] = timeStamp;
    }

    public void handleMessage(List<String> event, int[] mention, int[] offlineTime) {
        int timeStamp = Integer.parseInt(event.get(1));
        String[] tokens = event.get(2).split(" ");

        for (String token : tokens) {
            if (token.equals("ALL")) {
                for (int i = 0 ; i < mention.length ; i++) {
                    mention[i]++;
                }
            } else if (token.equals("HERE")) {
                for (int i = 0 ; i < mention.length ; i++) {
                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timeStamp)
                        mention[i]++;
                }
            } else {
                int id = Integer.parseInt(token);
                mention[id]++;
            }
        }
    }
}
