package 알고리즘.연습문제;

import java.util.Arrays;
import java.util.Comparator;

public class 배열제어 {
    public static void main(String[] args) {
        // 테스트를 위한 배열
        int[] arr = {3, 5, 1, 2, 5, 3, 7, 1};

        // Solution 클래스의 solution 메서드 호출
        int[] result = Solution.solution(arr);

        // 결과 출력
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public static int[] solution(int[] arr) {
        // Stream을 이용하여 중복 제거 및 내림차순 정렬
        return Arrays.stream(arr)
                .boxed()  // int를 Integer로 박싱
                .distinct()  // 중복 제거
                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
                .mapToInt(Integer::intValue)  // Integer를 int로 언박싱하여 int[]로 변환
                .toArray();  // 배열로 변환
    }
}