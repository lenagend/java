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
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{ 
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
