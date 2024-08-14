package 알고리즘.프로그래머스;

import java.util.HashSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] case1 = {2,1,3,4,1};
        System.out.println(s.solution(case1));
    }
}
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
