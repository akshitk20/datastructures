package com.practice.basics.tries;

class Node {
    Node links[] = new Node[26];
    int countPrefix;
    int countEnd;

    public Node() {}

    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node get(char ch) {
        return links[ch-'a'];
    }

    public void incPrefix() {
        countPrefix++;
    }

    public void incrEnd() {
        countEnd++;
    }

    public void reducePrefix() {
        countPrefix--;
    }

    public void reduceEnd() {
        countPrefix--;
    }

}
public class Trie {
    Node root
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.incPrefix();
        }
        node.incrEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(i);
            } else {
                return 0;
            }
        }
        return node.countEnd;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(i);
            } else {
                return 0;
            }
        }
        return node.countPrefix;
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(i);
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.reduceEnd();
    }

}

