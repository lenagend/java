package 람다연습;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 메서드참조 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Kim", "yang", "Park");
        List<String> validNames =  names.stream().filter(메서드참조::isValidName).collect(Collectors.toList());

        for(String s: validNames){
            System.out.println(s);
        }
    }
    private static boolean isValidName(String string){
        return Character.isUpperCase(string.charAt(0));
    }
}
