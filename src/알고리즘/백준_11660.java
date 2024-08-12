package 알고리즘;

import java.util.Scanner;

public class 백준_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N + 1][N + 1];
        int[][] sums = new int[N + 1][N + 1];

        // 표 입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nums[i][j] = sc.nextInt();
                // 누적 합 배열 생성
                sums[i][j] = nums[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }

        // 쿼리 처리
        for (int k = 0; k < M; k++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sums[x2][y2]
                    - sums[x1 - 1][y2]
                    - sums[x2][y1 - 1]
                    + sums[x1 - 1][y1 - 1];

            System.out.println(result);
        }

        sc.close();
    }
}
