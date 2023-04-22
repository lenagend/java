package 알고리즘;

import java.util.*;

public class 다익스트라 {
    static class Graph {
        private int vertices; // 그래프의 정점 개수
        private List<List<Node>> adjacencyList; // 인접리스트를 저장할 리스트

        // Node 클래스: 정점과 가중치를 저장하는 클래스
        static class Node implements Comparable<Node> {
            int vertex, weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }

            @Override
            public int compareTo(Node other) {
                return this.weight - other.weight;
            }
        }

        // 생성자: 정점 개수를 받아서 초기화하고 인접리스트 생성
        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);

            // 인접리스트의 각 인덱스에 LinkedList 초기화
            for (int i = 0; i < vertices; ++i) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        // 간선 추가 메서드: 두 정점 u, v와 가중치 w를 받아 인접리스트에 추가
        void addEdge(int u, int v, int w) {
            adjacencyList.get(u).add(new Node(v, w));
        }
    }

    // 다익스트라 알고리즘 메서드: 시작 정점을 받아 최단거리 계산 수행
    void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 생성
        int[] dist = new int[vertices]; // 최단거리를 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 최단거리 배열 초기화

        dist[start] = 0; // 시작 정점의 최단거리를 0으로 설정
        pq.add(new Node(start, 0)); // 시작 정점을 우선순위 큐에 추가

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면 계속 탐색
            Node currentNode = pq.poll(); // 우선순위 큐에서 정점 하나 꺼냄

            // 인접리스트를 순회하며 최단거리를 갱신하고 우선순위 큐에 추가
            for (Node neighbor : adjacencyList.get(currentNode.vertex)) {
                int altDist = dist[currentNode.vertex] + neighbor.weight;
                if (altDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = altDist;
                    pq.add(new Node(neighbor.vertex, altDist));
                }
            }
        }

        printShortestDistances(dist); // 최단거리 출력 메서드 호출

}
}
