package 알고리즘.백준;

import java.util.Scanner;

public class Doit3번문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N+1];
        int[] sums = new int[N+1];
        for(int i = 1; i <= N; i++){
            nums[i] = sc.nextInt();
            sums[i] = sums[i-1] + nums[i];
        }
        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = 0;
            System.out.println(sums[y]-sums[x-1]);
        }

    }
}
