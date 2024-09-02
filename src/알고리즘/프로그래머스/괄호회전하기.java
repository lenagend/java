package 알고리즘.프로그래머스;

import java.util.*;

public class 괄호회전하기 {
    public static void main(String[] args) {
        괄호회전하기 q = new 괄호회전하기();
        String s = "[](){}";

        int result = q.solution(s);

        System.out.println(result);
    }
    public int solution(String s) {
        int answer = 0;

        String temp = s;

        for(int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;  // 추가: 유효성을 확인하기 위한 플래그

            for(char c : temp.toCharArray()){
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                } else {
                    if(stack.isEmpty()){
                        isValid = false;
                        break;
                    } else {
                        char top = stack.pop();
                        if((c == ')' && top != '(') ||
                                (c == '}' && top != '{') ||
                                (c == ']' && top != '[')){
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            // 스택이 비어있고 isValid가 true인 경우에만 정답으로 간주
            if(isValid && stack.isEmpty()){
                answer++;
            }

            // 문자열을 한 칸 회전
            temp = temp.substring(1) + temp.charAt(0);
        }

        return answer;
    }
}
