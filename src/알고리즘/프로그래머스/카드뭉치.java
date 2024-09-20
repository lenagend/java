package 알고리즘.프로그래머스;

import java.util.*;

public class 카드뭉치 {
    public static void main(String[] args) {
        카드뭉치 q = new 카드뭉치();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = q.solution(cards1, cards2, goal);

        System.out.print(result);

    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> que1 = new ArrayDeque<>();
        ArrayDeque<String> que2 = new ArrayDeque<>();
        ArrayDeque<String> que3 = new ArrayDeque<>();

        for(String s: cards1){
            que1.add(s);
        }

        for(String s: cards2){
            que2.add(s);
        }

        for(String s: goal){
            que3.add(s);
        }

        String answer = "Yes";

        while (!que3.isEmpty()) {
            String c3 = que3.poll();

            // 각 큐에서 카드가 남아있다면 c1과 c2를 업데이트
            String c1 = que1.peek();
            String c2 = que2.peek();

            if (c1 != null && c1.equals(c3)) {
                que1.poll(); // 사용한 카드는 제거
            } else if (c2 != null && c2.equals(c3)) {
                que2.poll(); // 사용한 카드는 제거
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
