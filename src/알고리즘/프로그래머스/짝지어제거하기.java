package 알고리즘.프로그래머스;

import java.util.*;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        짝지어제거하기 q = new 짝지어제거하기();
        String s = "cdcd";

        int result = q.solution(s);

        System.out.println(result);
    }
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                char top = stack.pop();
                if(c!=top){
                    stack.push(top);
                    stack.push(c);
                }
            }
        }


        return stack.isEmpty() ? 1 : 0;
    }
}
