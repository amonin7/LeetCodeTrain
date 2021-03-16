package com.avminin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public HashMap<Character, Integer> initialAnagram(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (res.containsKey(s.charAt(i))) {
                res.replace(s.charAt(i), res.get(s.charAt(i)) + 1);
            } else {
                res.put(s.charAt(i), 1);
            }
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            HashMap<Character, Integer> initAn = initialAnagram(strs[i]);
            if (res.containsKey(initAn)) {
                List<String> new_list = res.get(initAn);
                new_list.add(strs[i]);
                res.replace(initAn, new_list);
            } else {
                List<String> new_list = new ArrayList<>();
                new_list.add(strs[i]);
                res.put(initAn, new_list);
            }
        }
        return new ArrayList<>(res.values());
    }
}
