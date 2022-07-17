package com.avminin.tree;

import java.util.HashMap;

public class Trie {

    public static class TrieNode {
        public HashMap<Character, TrieNode> chars;
        public boolean hasEnding;

        public TrieNode() {
            this.chars = new HashMap<>();
            this.hasEnding = false;
        }
    }

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curLetter = root;
        for (int i = 0; i < word.length(); ++i) {
            char curC = word.charAt(i);
            TrieNode nextLetter = curLetter.chars.getOrDefault(curC, new TrieNode());
            curLetter.chars.put(curC, nextLetter);
            curLetter = nextLetter;
        }
        curLetter.hasEnding = true;
    }

    public boolean search(String word) {
        TrieNode curLetter = root;
        for (int i = 0; i < word.length(); ++i) {
            char curC = word.charAt(i);
            curLetter = curLetter.chars.get(curC);
            if (curLetter == null) return false;
        }
        return curLetter.hasEnding;
    }

    public boolean startsWith(String prefix) {
        TrieNode curLetter = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char curC = prefix.charAt(i);
            curLetter = curLetter.chars.get(curC);
            if (curLetter == null) return false;
        }
        return true;
    }

}
