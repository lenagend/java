package 알고리즘;

import java.util.Scanner;

public class Doit2번문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        long max = 0;
        long sum = 0;
        for(int i = 0; i < N; i++){
            if(max < nums[i]) max = nums[i];
            sum += nums[i];
        }
        System.out.print(sum * 100.0 / max / N);

    }
}
