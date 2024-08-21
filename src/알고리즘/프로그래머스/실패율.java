package 알고리즘.프로그래머스;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] fail = new int[N+1];
        int[] success = new int[N+1];

        for(int i = 1; i <= stages.length; i ++){
            fail[stages[i]] ++;
            for(int j = 1; j <= stages[i]; j++){
                success[j] ++;
            }
        }

        int[] result = new int[N];

        for(int i = 1; i <= N; i ++){
            result[i-1] = fail[i] / success[i];
        }

        result.s

        int[] answer = new int[N];

        return answer;
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
}
