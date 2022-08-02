package com.avminin;

import com.avminin.bin.search.FirstBadVersion;
import com.avminin.bin.search.SearchInsertPosition;
import com.avminin.tree.Trie;

public class Main {

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3}, 2));
    }
}
