package 동작파라메터연습;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTraining {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("하늘");
        strs.add("바다");
        strs.add("땅");

        List<String> resultList = filter(strs, (String s) -> s.length()==1);

        for (String s: resultList
             ) {
            System.out.println(s);
        }
    }

    public static  <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t: list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
