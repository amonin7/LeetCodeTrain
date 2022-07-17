package com.avminin.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty()) return false;
                Character lastPushed = stack.pollFirst();
                if (!(lastPushed == '{' && c == '}'
                    || lastPushed == '[' && c == ']'
                    || lastPushed == '(' && c == ')')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
