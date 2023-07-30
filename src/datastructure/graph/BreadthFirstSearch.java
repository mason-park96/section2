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

 BFS 는 Queue 자료구조를 활용하여 구현된다.
 BFS 는 시작 정점을 Queue 에 삽입 후 인접한 정점을 큐에 차례대로 삽입하면서 탐색을 진행한다.
 시작 정점에서 도달할 수 없는 정점은 탐색하지 않는다. --> 시작 정점이 도달하는 경로 탐색할 때만 사용하자 !
 방문 여부를 저장하는 visited 배열 등을 사용하여야 한다. 아니면 무한루프에 빠짐 ㅅㄱ

!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@
BFS 는
최 단 경 로
최 단 경 로
최 단 경 로 를 찾을때 사용하면 좋은 탐색 알고리즘이다.
!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@


 장점 !
    - 최단거리 찾는데 유용함 (시적 정점의 인접 정점부터 탐색하기 때문)

 단점 !
    - 그래프 사이즈가 클 경우 메모리를 많이 사용한다. (방문한 정점을 모두 Queue 에 저장하기 때문)
        * 사이즈 크면 DFS 로 탐색해라 ~!
    - 그래프의 밀도가 높으면 (간선이 많으면) BFS 탐색 성능 떨어짐


    * @param array : 각 정점을 행/열로 하고, 연결된 정점은 1로, 연결되지 않은 정점은 0으로 표기하는 2차원 배열
    * @param visited : 방문여부 확인을 위한 배열
    * @param src : 방문할 정점
    * @param result : 방문했던 정점 리스트를 저장한 List
*/

package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



// 구현 초안
// 기초적인 로직
public class BreadthFirstSearch {
    public ArrayList<Integer> bfs_array(int[][] array, boolean[] visited, int src, ArrayList<Integer> result) {
        // BFS 는 Queue 자료구조를 사용한다.
        Queue<Integer> queue = new LinkedList<>();

        // 탐색할 정점 scr 을 queue 에 삽입
        queue.offer(src);
        // 탐색 했으니까 방문했다고 표시
        visited[src] = true;

        // queue 가 텅 빌때까지 다음 동작을 반복하라고 하는데
        // 과연 어떤 동작을 지시하길래 그래프 전체가 탐색이 되는지 함 보자
        // 그래프 ( = array ) 의 정점을 기준으로 탐색하는군
        while (!queue.isEmpty()) {
            // 현재 방문한 정점을 queue 에서 삭제하고 cur 에 저장.
            int cur = queue.poll();
            // result 에 현재 방문한 정점을 삽입
            result.add(cur);

            for (int i = 0; i < array[cur].length; i++) {
                if(array[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }
}