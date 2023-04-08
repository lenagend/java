package 스트림연습;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap2 {
//    flatMap은 스트림의 각 요소를 먼저 적용된 함수의 결과로 얻은 스트림으로 변환한 후, 이러한 스트림들을 하나의 스트림으로 "평탄화"합니다.
    public static void main(String[] args) {
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedNumbers); // 출력: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
