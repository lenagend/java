import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTraining {
    public static void main(String[] args) {
        prinAll(Arrays.asList("김광민", "박소현", "양성민", "권영우"), (String s)->{System.out.println(s); 
            System.out.println("입니다");});
    }

    public static <T> void prinAll(List<T> list, Consumer<T> c){
        for(T t: list){
            c.accept(t);
        }
    }
}
