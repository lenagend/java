package 알고리즘;

import java.util.Arrays;

public class 프로그래머스스킬테스트1_2 {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score); // 사과 점수 배열을 오름차순으로 정렬
        int n = score.length;
        int answer = 0;

        // 사과들을 m개씩 묶어서 상자를 만든다.
        for (int i = n - m; i >= 0; i -= m) {
            int boxPrice = score[i] * m; // 상자 가격 계산 (최저 점수 * m)
            answer += boxPrice; // 총 이익에 더하기
        }

        return answer;
    }

    public static void main(String[] args) {
        프로그래머스스킬테스트1_2 sol = new 프로그래머스스킬테스트1_2();
        int k1 = 3;
        int m1 = 4;
        int[] score1 = {1, 2, 3, 1, 2, 3, 1};
        System.out.println("Result: " + sol.solution(k1, m1, score1)); // 예시 결과 출력

        int k2 = 4;
        int m2 = 3;
        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println("Result: " + sol.solution(k2, m2, score2)); // 예시 결과 출력
    }
}
