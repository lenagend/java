package 알고리즘.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 실패율 {
    public int[] solution(int N, int[] stages) {

        int[] stageCount = new int[N + 2];

        for(int stage : stages){
            stageCount[stage]++;
        }
        List<StageInfo> failureRates  = new ArrayList<>();
        int totalPlayers = stages.length;

        for(int i = 1; i <= N; i++){
            if (totalPlayers == 0){
                failureRates.add(new StageInfo(i, 0));
            }else{
                double failureRate = (double) stageCount[i] / totalPlayers;
                failureRates.add(new StageInfo(i, failureRate));
                totalPlayers -= stageCount[i];
            }
        }


        failureRates.sort((a, b)->{
            if(b.failureRate == a.failureRate){
                return a.stageNumber - b.stageNumber;
            }else{
                return Double.compare(b.failureRate, a.failureRate);
            }
        });

        int[] result = new int[N];

        for(int i = 0; i < N; i ++){
            result[i] = failureRates.get(i).stageNumber;
        }

        return result;
    }

    public static void main(String[] args) {
        실패율 q = new 실패율();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = q.solution(N, stages);

        for(int i = 0; i < result.length; i ++){
            System.out.print(result[i] + " ");
        }
    }
    class StageInfo{
        int stageNumber;
        double failureRate;

        StageInfo(int stageNumber, double failureRate) {
            this.stageNumber = stageNumber;
            this.failureRate = failureRate;
        }
    }
}

