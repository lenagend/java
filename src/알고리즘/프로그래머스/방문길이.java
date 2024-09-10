package 알고리즘.프로그래머스;

import java.util.*;

public class 방문길이 {
    public static void main(String[] args) {
        방문길이 q = new 방문길이();
        int result = q.solution("LULLLLLLU");
        System.out.println(result);
    }

    public int solution(String dirs) {
        int x = 0;
        int y = 0;

        Set<String> history = new HashSet<>();

        for(char dir : dirs.toCharArray()){

            String start = x + "," + y;

            if(dir == 'U' && y < 5){
                y++;
            } else if(dir == 'D' && y > -5){
                y--;
            } else if(dir == 'R' && x < 5){
                x++;
            } else if(dir == 'L' && x > -5){
                x--;
            }

            String end = x + "," + y;
            String route = start + "to" + end;
            String reverseRoute = end + "to" + start;

            if(!history.contains(route) && !history.contains(reverseRoute)) {
                history.add(route);
                history.add(reverseRoute);
            }
        }

        return history.size() / 2;
    }

}
