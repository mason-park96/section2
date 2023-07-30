/*
작성자: 박무승
작성일: 23.07.30 (일)

주어진 그래프의 두 정점을 잇는 최단거리를 구하는 메서드를 작성하시오.

앗 ! 최단거리 구하는 문제니까 BFS 를 사용해야겠잖아 !?

이 문제를 해결하기 위해서는 인접 노드들을 "하나의 섬"으로 묶으라고?
뭔소리인지 도통 모르겠지만, 그렇다면 어떻게 묶어야할까?

array[cur][i] 들을 하나로 묶으라는건데, 저장된 데이터라고 해봐야 간선 (0 or 1) 일거아냐
배열로 묶어줘야하나?
*/
package datastructure.graph;

import java.util.ArrayList;

public class BFSFindMostShortPath {
    public static void main(String[] args) {
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
    }

    // 설마 이게 섬으로 묶어주는 메서드인가?
    public ArrayList<Integer> shortestPath(int[][] graph, int start, int end) {
        boolean[] visited = new boolean[graph.length];
        return bfs(graph, start, end, visited);
    }

    // 이건 그냥 넓이우선탐색 알고리즘 같은디
    private ArrayList<Integer> bfs(int[][] graph, int start, int end, boolean[] visited) {

    }


}
