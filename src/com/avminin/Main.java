package com.avminin;

import com.avminin.bin.search.FirstBadVersion;
import com.avminin.tree.Trie;

public class Main {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        System.out.println(obj.startsWith("worde"));
        System.out.println(new FirstBadVersion().firstBadVersion(5));
//        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
    }
}
