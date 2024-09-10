package 알고리즘.프로그래머스;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        크레인인형뽑기게임 q = new 크레인인형뽑기게임();

        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = q.solution(board, moves);

        System.out.print(result);

    }
    public int solution(int[][] board, int[] moves) {
        int n = board[0].length;
        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for(int i = 0; i < moves.length; i++){
            int index = moves[i] - 1;
            for(int j = 0; j < n; j ++){
                int current = board[j][index];
                if(current != 0){
                    board[j][index] = 0;
                    if(basket.isEmpty()){
                        basket.push(current);
                    }else{
                        if(basket.peek() == current){
                            answer+=2;
                            basket.pop();
                        }else{
                            basket.push(current);
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
