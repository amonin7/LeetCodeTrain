package com.avminin.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sChars = new HashMap<>();
        HashMap<Character, Integer> tChars = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            sChars.put(c, sChars.getOrDefault(c, 0) + 1);
            c = t.charAt(i);
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);
        }
        if (sChars.keySet().size() != tChars.keySet().size()) return false;
        for (Character c : sChars.keySet()) {
            if (!sChars.get(c).equals(tChars.getOrDefault(c, 0))) return false;
        }
        return true;
    }
}
