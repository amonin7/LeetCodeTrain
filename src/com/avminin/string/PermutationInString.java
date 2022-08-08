package com.avminin.string;

import java.util.HashMap;
import java.util.Set;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Letters = new HashMap<>();
        for (char c : s1.toCharArray())
            s1Letters.put(c, s1Letters.getOrDefault(c, 0) + 1);

        Set<Character> letters = s1Letters.keySet();
        int i = 0;
        while (i < s2.length() && !letters.contains(s2.charAt(i))) ++i;
        if (s2.length() - i < s1.length()) return false;

        HashMap<Character, Integer> s2Letters = new HashMap<>();
        for (int j = i; j < s1.length() + i; ++j)
            s2Letters.put(s2.charAt(j), s2Letters.getOrDefault(s2.charAt(j), 0) + 1);

        if (s1Letters.equals(s2Letters)) return true;
        for (int j = s1.length() + i; j < s2.length(); ++j) {
            Character c = s2.charAt(j - s1.length());
            if (s2Letters.get(c) == 1) s2Letters.remove(c);
            else s2Letters.put(c, s2Letters.get(c) - 1);
            s2Letters.put(s2.charAt(j), s2Letters.getOrDefault(s2.charAt(j), 0) + 1);
            if (s1Letters.equals(s2Letters)) return true;
        }
        return false;
    }
}
