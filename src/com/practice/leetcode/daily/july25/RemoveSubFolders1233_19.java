package com.practice.leetcode.daily.july25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFolders1233_19 {

    public List<String> removeSubfolders(String[] folders) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : folders) {
            set.add(s);
        }

        for (String folder : folders) {
            String tempFolder = folder;
            boolean found = false;

            while (!folder.isEmpty()) {
                int lastIndex = folder.lastIndexOf("/");
                folder = folder.substring(0, lastIndex);
                if (set.contains(folder)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(tempFolder);
            }
        }
        return result;
    }
}
