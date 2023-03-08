package 스트림연습;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("각 단어의", "길이를 나타내는", "리스트를", "만들어보자", "공백제거");
        List<Integer> lengths = words.stream()
                .map(str -> str.replaceAll(" ", ""))
                .map(String::length)
                .collect(Collectors.toList());
        lengths.stream().forEach(System.out::println);
    }
}
