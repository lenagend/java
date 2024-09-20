package 알고리즘.프로그래머스;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        기능개발 q = new 기능개발();

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = q.solution(progresses, speeds);

        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> remainingDays = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i ++){
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            remainingDays.add(days);
        }

        int firstFinishDayleft = remainingDays.poll();

        List<Integer> answer = new ArrayList<>();
        int count = 1;
        while(!remainingDays.isEmpty()){
            int nextFinishDayLeft = remainingDays.poll();
            if(firstFinishDayleft >= nextFinishDayLeft){
                count++;
            }else{
                answer.add(count);
                firstFinishDayleft = nextFinishDayLeft;
                count = 1;
            }
        }

        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
