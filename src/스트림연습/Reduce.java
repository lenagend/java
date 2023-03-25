package 스트림연습;

import java.util.*;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,3,5,7,9,11,13,15);
        List<Integer> nums2 = new ArrayList<>();

        //요소의 합 구하기
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //초기값 미설정시 Optional로 받아야한다(아무 요소도 없는 상황도 있을 수 있다)
        Optional<Integer> optionalSum = nums2.stream().reduce(Integer::sum);
        if(!optionalSum.isPresent()) System.out.println("리스트에 숫자가 없습니다");

        //최댓값 최솟값
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        Optional<Integer> min = nums.stream().reduce(Integer::min);
        System.out.println("최댓값 : " + max.get());
        System.out.println("최소값 : " + min.get());


    }
}
