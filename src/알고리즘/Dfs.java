package 알고리즘;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
    static class Graph {
        int vertices;                    // 정점의 수
        List<List<Integer>> adjList;     // 인접 리스트

        Graph(int vertices) {
            this.vertices = vertices;    // 정점 수 초기화
            adjList = new ArrayList<>(); // 인접 리스트 초기화

            // 각 정점에 대한 인접 리스트 생성
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // 간선 추가 메소드
        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest); // 양방향 그래프
            adjList.get(dest).add(src);
        }
    }

    private static void dfs(Graph graph, int start, boolean[] visited) {
        visited[start] = true; // 현재 정점 방문 처리
        System.out.print(start + " "); // 방문한 정점 출력

        // 현재 정점과 인접한 정점들을 순회
        for (int adjacent : graph.adjList.get(start)) {
            // 인접 정점이 아직 방문되지 않았다면 재귀적으로 호출
            if (!visited[adjacent]) {
                dfs(graph, adjacent, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5); // 정점이 5개인 그래프 생성

        // 간선 추가
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        boolean[] visited = new boolean[graph.vertices]; // 방문 여부 배열 초기화

        System.out.println("깊이 우선 탐색 결과: ");
        dfs(graph, 0, visited); // DFS 실행, 시작 정점은 0
    }
}
