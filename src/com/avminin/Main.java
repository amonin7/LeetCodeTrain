package com.avminin;

import com.avminin.array.FirstBadVersion;
import com.avminin.string.LongestPalindromicSubstring;
import com.avminin.string.PalindromicSubstrings;
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
