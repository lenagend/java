package 알고리즘.백준;
import java.util.*;
public class Q1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < N; i++){
            int find = nums[i];
            int left = 0;
            int right = N - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[right];

                if (sum == find) {
                    result++;
                    break;  // 같은 수에 대해 중복을 피하기 위해
                } else if (sum < find) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(result);
    }
}
