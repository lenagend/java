package 알고리즘.프로그래머스;

import java.util.*;

public class 올바른괄호 {
    public static void main(String[] args) {
        올바른괄호 q = new 올바른괄호();
        String s = "()()";
        String s2 = ")()(";

        boolean result1 = q.solution(s);
        boolean result2 = q.solution(s2);

        System.out.println(result1);
        System.out.println(result2);
    }
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                // 스택이 비어있으면 올바르지 않은 괄호
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // 스택이 비어있다면 모든 괄호가 올바르게 짝지어졌음을 의미
        return stack.isEmpty();
    }
}
