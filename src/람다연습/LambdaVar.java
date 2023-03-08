package 람다연습;

public class LambdaVar {
    public static void main(String[] args) {
        int number = 135;
        Runnable r = () -> System.out.println(number);
        //오류
        //number = 136;
    }
}
