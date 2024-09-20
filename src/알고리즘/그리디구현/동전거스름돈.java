package 알고리즘.그리디구현;

import java.util.Scanner;

public class 동전거스름돈 {
    public static int solution(int N) {
        int[] coins = {500, 100, 50, 10};
        int answer = 0;
        for(int coin : coins){
            if(coin > N){
                continue;
            }
           answer += N / coin;
           N = N % coin;
        }

        return answer;  // 최종 결과 반환
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(solution(N));
    }
}
