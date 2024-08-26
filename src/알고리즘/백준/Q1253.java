package 알고리즘.백준;
import java.util.*;
public class Q1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i ++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int answer = 0;
        for(int i = 0; i < N; i ++){
            int left = 0;
            int right = N - 1;
            while(left < right){
                if(nums[left] == nums[i]){
                    left++;
                    continue;
                }
                if(nums[right] == nums[i]){
                    right--;
                    continue;
                }
                int sum = nums[left]+nums[right];
                if(sum==nums[i]){
                    answer++;
                    break;
                }else if(sum < nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(answer);
    }
}
