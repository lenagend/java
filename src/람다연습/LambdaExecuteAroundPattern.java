package 람다연습;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaExecuteAroundPattern {
    public static void main(String[] args) throws IOException {
        String text = processFile();
        String text2 = newProcessFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(text);
        System.out.println(text2);
    }

    //자원을 열고 실행하고 닫는 코드, 하지만 한번에 하나의 동작밖에 하지 못한다.
    public static String processFile() throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("src/test.txt"))){
            return br.readLine();
        }
    }

    public static String newProcessFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("src/test.txt"))){
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

}
