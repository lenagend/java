package 스트림연습;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 스트림만들기 {
    public static void main(String[] args) {
        //값으로 스트림 만들기
        Stream<String> stream = Stream.of("김광민", "박소현", "양성민", "권영우");
        stream.map(String::length).forEach(System.out::println);

        //함수로 무한 스트림 만들기
        //초깃값과 람다를 인수로 받아서 새로운 값을 끊임없이 생산할 수 있다.
        //limit이 없다면 언바운드 상태가 된다
        Stream.iterate(1, n -> n * 2)
                .limit(5)
                .forEach(System.out::println);

        //generate는 iterate와 달리 생산된 각 값을 연속적으로 계산하지는 않는다.
        Stream.generate(Math::random)
                .limit(3)
                .forEach(System.out::println);


    }
}
