/*
작성자: 박무승
작성일: 23.08.01 (화)

내용
BFS 를 활용하여 graph 상의 두 vertex 를 연결하는 최단거리의 경로를 반환하는 메서드를 작성해보자.

* */
package datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    public static void main(String[] args) {
        BFSSolution bfs = new BFSSolution();

        int[][] graph = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };

        int start = 0;
        int end = 5;
        System.out.println(bfs.shortestPath(graph, start, end));
    }

    public ArrayList<Integer> shortestPath(int[][] graph, int start, int end) {
        boolean[] visited = new boolean[graph.length];
        // 왜 굳이 메서드를 2개를 호출해야 하는지 잘 모르겠다.
        // visited 를 지역 변수로 하여 bfs 메서드 안에 넣어버려도 차이가 없지 않나.
        return bfs(graph, start, end, visited);
    }

    private ArrayList<Integer> bfs(int[][] graph, int start, int end, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        // 얘는 못보던건데 어디에 쓰이는거지 ??
        // 단순히 탐색하는 알고리즘이 아니고, 두 정점 사이의 최단거리를 구해야하니
        // 탐색하다가 end 만나면 종료하는거겠지. 근데 parent 가 무슨 의미일까
        int[] parent = new int[graph.length];

        queue.offer(start);
        visited[start] = true;
        // 현재 기준점을 확인할 배열 ?? 기준점이 뭔데. start?
        parent[start] = -1;

        // queue 가 텅 비면 탐색 다 한거다.
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // BFS 로직으로 탐색을 하다가, 목적지 노드를 탐색하게 된다면! (목적지에 도달하면)
            if(node == end) {
                // return 할 경로를 생성하여
                ArrayList<Integer> path = new ArrayList<>();
                while (node != -1) {
                    path.add(node);
                    // 아하 뒤로 돌아가서 start 까지 가려고 ~ 그래서 배열 ~ 아하 이런 용도구나.
                    // 그래서 기준점 ~ 목적지 노드를 방문했을때, 목적지 노드로 부터 출발 노드 까지의 경로를
                    // 역으로 탐색하여 path 에 저장할 때 탐색을 종료하는 기준이구나.
                    node = parent[node];
                }
                // path 를 역순으로 추적하여 저장하였기 때문에 뒤집기 필요
                Collections.reverse(path);
                return path;
            }

            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    // 그렇구나 그냥 정점(노드)의 번호(리터럴)을 저장하는구나.
                    // 그래서 기준점만 -1 로 하니까 구분이 되네.
                    // 그리고 line.no.58 에서 node = parent[node] 를 위해서 리터럴을 일치시키는구나.
                    parent[i] = node;
                }
            }
        }
        // 목적지 노드를 찾는 경우 line.no.62 에서 경로를 return 하지만
        // 목적지 or 경로를 찾지 못한 경우
        return null;
    }
}
