package 스트림연습;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        //두개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트를 반환하라
        List<Integer> num1 = Arrays.asList(1,2,3,4,5);
        List<Integer> num2 = Arrays.asList(2,5,6);
        List<int[]> pairs =
        num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        pairs.stream().forEach(x-> System.out.println(x[0] + "," + x[1]));


    }
}
