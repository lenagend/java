package 알고리즘.프로그래머스;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        주식가격 q = new 주식가격();
        int[] prices = {1, 2, 3, 2, 3};

        int[] result = q.solution(prices);

        for(int n : result){
            System.out.print(n);
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}
