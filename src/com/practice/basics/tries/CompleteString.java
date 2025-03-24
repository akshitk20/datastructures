package com.practice.basics.tries;

class MyNode {
    MyNode[] links = new MyNode[26];
    boolean isWord;
    public MyNode() {}

    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public void put(char ch, MyNode node) {
        links[ch-'a'] = node;
    }

    public MyNode get(char ch) {
        return links[ch-'a'];
    }

    public void setEnd() {
        isWord = true;
    }

    public boolean getEnd() {
        return isWord;
    }
}

class MyTrie {
    MyNode root;
    public MyTrie() {
        root = new MyNode();
    }

    public void insert(String word) {
        MyNode node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new MyNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExist(String word) {
        MyNode node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (!node.getEnd()) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
public class CompleteString {
    // TC : N * LEN
    public static String completeString(int n, String[] a) {
        // Write your code here.
        MyTrie trie = new MyTrie();
        for (String s : a) {
            trie.insert(s);
        }
        String max = "";
        for (String s : a) {
            if (trie.checkIfPrefixExist(s)) {
                if (s.length() > max.length()) {
                    max = s;
                } else if (s.length() == max.length()
                        && s.compareTo(max) < 0) {
                    max = s;
                }
            }
        }
        return max;
    }
}
