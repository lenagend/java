package 알고리즘.백준;

import java.util.*;

public class Q2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        // 시작점 i를 1부터 N까지 순회한다
        for (int start = 1; start <= N; start++) {
            int sum = 0; // 연속된 수들의 합을 저장하는 변수

            // 시작점에서 시작하여 연속된 수들의 합을 계산한다
            for (int end = start; end <= N; end++) {
                sum += end;

                if (sum == N) { // 합이 N과 같으면 카운트를 증가시킨다
                    count++;
                    break; // 더 이상 합을 구할 필요 없으므로 반복 종료
                } else if (sum > N) { // 합이 N보다 크면 더 이상 진행할 필요 없으므로 종료
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
