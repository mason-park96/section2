/*
작성자: 박무승
작성일: 23.07.30 (일)

코드 설명
해당 코드는 그래프의 탐색 알고리즘 중 하나인 DFS 알고리즘의 코드이다.
우리는 출발점과 목적지 사이에 최적의(혹은 최단의, 최장의) 경로를 찾아야한다.
그 과정에서 모든 노드를 탐색하여 목적지와 동일한 노드를 찾아야한다. 이때,
 깊은 순서로 탐색할지 (자식 노드) DFS
    --> 하나의 노선을 끝까지 탐색 후 목적지가 불일치하면 다음 노선을 탐색.
    --> 해당 경로를 완전히 탐색하고 넘어가기 때문에 운이 좋으면 몇 번의 탐색 만에 경로 찾기 가능
 넓은 순서로 탐색할지 (형제 노드) BFS
    --> 제일 첫 번째로 탐색한 경로의 목적지가 일치하더라도 다른 모든 경로를 살펴봐야함
 의 방법이 존재한다.

DFS(깊이 우선 탐색) 는 Stack 과 재귀를 활용하여 구현한다.
이미 방문한 노드(정점, vertex)를 방문하면 재귀를 종료한다.
하나의 연결에 대하여 그 연결이 끝날 때 까지 탐색 후 탐색을 종료하면 다음 경로를 탐색한다.

     * @param array : 각 정점을 행/열로 하고, 연결된 정점은 1로, 연결되지 않은 정점은 0으로 표기하는 2차원 배열
     * @param visited : 방문 여부 확인을 위한 배열
     * @param src : 방문할 정점
     * @param result : 방문했던 정점 리스트를 저장한 List
*/

package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DepthFirstSearch {
    public ArrayList<Integer> dfs (int[][] array, boolean[] visited, int src, ArrayList<Integer> result) {
        // 이미 방문했다면 (탈출 !!)
        if (visited[src] == true) {
            result.add(src);
            return result;
        }

        // 아직 방문하지 않았다면
        // 방문한 정점 표기
        visited[src] = true;

        // 현재 정점에서 이동할 수 있는 정점을 순회하며 재귀호출
        // 이게 이 알고리즘의 핵심 로직이다. 함 보자.
        for(int index = 0; index < array.length; index++) {
            // 두 정점 src 와 index 가 연결되어 있다면
            if (array[src][index] == 1) {
                // 재귀 호출을 통하여 방문 여부를 담은 데이터를 반환과 동시에 할당
                result = dfs(array, visited, index, result);
            }
        }
        // 다 돌아간 result 반환
        return result;
    }
}
