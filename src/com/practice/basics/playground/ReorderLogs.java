package com.practice.basics.playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {

    public static void main(String[] args) {
        String[] logs = new String[] {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        ReorderLogs reorderLogs = new ReorderLogs();
        List<String> strings = reorderLogs.reorderLogs(logs);
        for (String str : strings) {
            System.out.print(str);
        }
    }

    public List<String> reorderLogs(String[] logs) {
        List<String> result = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for (String log : logs) {
            String[] parts = log.split(" ", 2); // split into 2 parts identifier and content
            if (Character.isDigit(parts[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        Collections.sort(letters, (a , b) -> {
            String[] aParts = a.split(" ", 2);
            String[] bParts = b.split(" ", 2);
            int cmp = aParts[1].compareTo(bParts[1]);
            if (cmp == 0) {
                return aParts[0].compareTo(bParts[0]);
            }
            return cmp;
        });
        result.addAll(letters);
        result.addAll(digits);
        return result;
    }
}
