package 알고리즘;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode20 {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";

        System.out.println(isValid(s1)); // Output: true
        System.out.println(isValid(s2)); // Output: true
        System.out.println(isValid(s3)); // Output: false
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
