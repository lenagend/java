package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Doit구간합 {
    public static void main(String[] args) throws IOException {
        // 시스템 입력을 받기 위한 버퍼 리더 객체 생성
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        // 입력된 문자열을 토큰으로 분리하기 위한 객체 생성
        StringTokenizer stringTokenizer
                = new StringTokenizer(bufferedReader.readLine());

        // 첫 번째 입력값(수열의 크기)을 정수로 변환하여 저장
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        // 두 번째 입력값(질문의 수)을 정수로 변환하여 저장
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        // 수열의 누적 합을 저장할 배열 선언. 인덱스는 1부터 시작
        long[] S = new long[suNo + 1];

        // 수열의 원소들을 입력받아 배열에 누적 합을 계산하여 저장
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 주어진 질문의 수만큼 반복
        for (int q = 0; q < quizNo; q++) {
            // 질문에 사용될 두 인덱스 값을 입력 받음
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            // 누적 합 배열을 사용해 해당 범위의 합을 출력
            System.out.println(S[j] - S[i - 1]);
        }
    }

}
