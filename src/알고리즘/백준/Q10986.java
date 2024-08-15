package 알고리즘.백준;

import java.util.Scanner;

public class Q10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i ++){
            A[i] = sc.nextInt();
        }

        long[] prefix_sum = new long[N + 1];
        long[] remainder_count = new long[M];

        long count = 0;
        for(int i = 1; i <= N; i++){
            prefix_sum[i] = (A[i-1] + prefix_sum[i-1]) % M;

            if(prefix_sum[i] == 0){
                count++;
            }

            count += remainder_count[(int) prefix_sum[i]];
            remainder_count[(int) prefix_sum[i]]++;
        }

        System.out.println(count);

    }
}
