package 알고리즘.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] patternA = {1,2,3,4,5};
        int[] patternB = {2,1,2,3,2,4,2,5};
        int[] patternC = {3,3,1,1,2,2,4,4,5,5};

        int pointerA = 0;
        int pointerB = 0;
        int pointerC = 0;

        int scoreA = 0;
        int scoreB = 0;
        int scoreC = 0;

        for (int i = 0; i < answers.length; i++){
            if(pointerA >= patternA.length){
                pointerA = 0;
            }
            if(pointerB >= patternB.length){
                pointerB = 0;
            }
            if(pointerC >= patternC.length){
                pointerC = 0;
            }

            if(answers[i] == patternA[pointerA]) scoreA++;
            if(answers[i] == patternB[pointerB]) scoreB++;
            if(answers[i] == patternC[pointerC]) scoreC++;

            pointerA++;
            pointerB++;
            pointerC++;

        }

        // 세 사람의 점수를 리스트에 저장
        int maxScore = Math.max(scoreA, Math.max(scoreB, scoreC));

        List<Integer> result = new ArrayList<>();
        if (scoreA == maxScore) result.add(1);
        if (scoreB == maxScore) result.add(2);
        if (scoreC == maxScore) result.add(3);

        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        모의고사 sol = new 모의고사();
        int[] answers = {1,3,2,4,2};
        int[] result = sol.solution(answers);
        System.out.println(Arrays.toString(result));  // [1, 2, 3] 출력
    }
}
