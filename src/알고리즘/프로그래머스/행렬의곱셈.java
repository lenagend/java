package 알고리즘.프로그래머스;

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows1 = arr1.length;          // arr1의 행 개수
        int cols1 = arr1[0].length;       // arr1의 열 개수 (arr2의 행 개수와 같아야 함)
        int cols2 = arr2[0].length;       // arr2의 열 개수

        int[][] answer = new int[rows1][cols2];  // 결과 행렬의 크기는 arr1의 행 개수 x arr2의 열 개수

        for(int i = 0; i < rows1; i++){
            for(int j = 0; j < cols2; j++){
                for(int k = 0; k < cols1; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        행렬의곱셈 q = new 행렬의곱셈();
        int[][] arr1 = {
                {1,4},
                {3,2},
                {4,1}
        };

        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };

        int[][] result = q.solution(arr1, arr2);

        // 결과 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
