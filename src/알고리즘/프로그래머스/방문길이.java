package 알고리즘.프로그래머스;

import java.util.*;

public class 방문길이 {
    public static void main(String[] args) {
        방문길이 q = new 방문길이();
        int result = q.solution("ULURRDLLU");
        System.out.println(result);
    }
    public int solution(String dirs) {
        Route[][] map = new Route[10][10];

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Route route = new Route(
                        false,
                        i-5,
                        j-5
                );
                map[i][j] = route;
            }
        }

        Route current = map[5][5];

        for(char direction : dirs.toCharArray()){

        }


        int answer = 0;
        return answer;
    }
    class Route{
        boolean visited;
        int x;
        int y;
        Route(boolean visited, int x, int y){
            this.visited = visited;
            this.x = x;
            this.y = y;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
