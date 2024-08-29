package 알고리즘.연습문제;

import java.util.*;

public class Q10진수를2진수로 {
    public static void main(String[] args) {
        Q10진수를2진수로 q = new Q10진수를2진수로();
        String answer = q.solution(987654321);
        System.out.println(answer);
    }
    String solution(int demical) {
       int N = demical; //13
       Stack<Integer> stack = new Stack<>();
       while (N > 0){
           stack.push(N % 2);
           N /= 2;
       }
       StringBuilder sb = new StringBuilder();
       while(!stack.empty()){
           sb.append(stack.pop());
       }

       return sb.toString();
    }
}
