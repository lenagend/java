package 동작파라메터연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTraining {
    public static void main(String[] args) {
        List<String> strs = convert(Arrays.asList(1,2,3,4,5), (Integer i)->i+"번");
        for(String s: strs){
            System.out.println(s);
        }
    }
    public static  <T, R> List<R> convert(List<T> list, Function<T, R> f){
        List<R> result = new ArrayList<>();
        for(T t: list){
            result.add(f.apply(t));
        }
        return result;
    }
}


