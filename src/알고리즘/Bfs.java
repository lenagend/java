package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    static class Graph {
        private int vertices; // 그래프의 정점 개수
        private LinkedList<Integer>[] adjacencyList; // 인접리스트를 저장할 배열

        // 생성자: 정점 개수를 받아서 초기화하고 인접리스트 배열 생성
        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];

            // 인접리스트 배열의 각 인덱스에 LinkedList 초기화
            for (int i = 0; i < vertices; ++i) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        // 간선 추가 메서드: 두 정점 u, v를 받아 인접리스트에 추가
        void addEdge(int u, int v) {
            adjacencyList[u].add(v);
        }

        // BFS 메서드: 시작 정점을 받아 BFS 탐색 수행
        void BFS(int start) {
            boolean[] visited = new boolean[vertices]; // 정점 방문 여부를 저장할 배열
            Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐 생성

            visited[start] = true; // 시작 정점을 방문 처리
            queue.add(start); // 큐에 시작 정점 추가

            while (!queue.isEmpty()) { // 큐가 비어있지 않으면 계속 탐색
                int current = queue.poll(); // 큐에서 정점을 하나 꺼냄
                System.out.print(current + " "); // 방문한 정점 출력

                // 인접리스트를 순회하며 방문하지 않은 정점을 방문 처리하고 큐에 추가
                for (int neighbor : adjacencyList[current]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(6); // 6개의 정점을 가진 그래프 생성
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 4);
            graph.addEdge(3, 5);
            graph.addEdge(4, 5);

            System.out.println("BFS 탐색 순서:");
            graph.BFS(0); // 정점 0부터 BFS 탐색 시작
        }
    }
}
