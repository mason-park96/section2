/*
방향이 없는 간선들의 목록이 주어질 때, 연결된 정점의 컴포넌트(그룹들)가 몇 개인지 반환하는 함수를 작성하는 문제

*/
package datastructure.koplit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class DataStructureNum12 {
    //만약 길이 존재하고, 방문하지 않았다면
    public int connectedVertices(int[][] edges) {

        final int[] bigger = {0};

        // 최대 버텍스를 찾습니다.
        Arrays.stream(edges).forEach(data -> {
            int currentBigger = Arrays.stream(data)
                    .boxed()
                    .max(Comparator.comparing(i -> i))
                    .orElse(0);
            if (bigger[0] < currentBigger) bigger[0] = currentBigger;
        });

        //최대 버택스 + 1만큼의 배열을 선언합니다(0부터 시작)
        int[][] adjArray = new int[bigger[0] + 1][bigger[0] + 1];

        // edges를 순회하며, (무향 그래프이므로 쌍방으로) 간선을 연결해 줍니다.
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adjArray[from][to] = 1;
            adjArray[to][from] = 1;
        }

        // 방문한 버텍스를 담을 배열을 선언합니다.
        boolean[] visited = new boolean[bigger[0] + 1];
        // 컴포넌트가 몇 개인지 카운트할 변수를 선언합니다.
        int count = 0;

        // 방문 여부를 체크한 배열을 모두 순회합니다.
        for (int vertex = 0; vertex < visited.length; vertex++) {
            //만약 방문하지 않았다면
            if (!visited[vertex]) {
                //컴포넌트를 늘려주고
                count++;
                // 그래프와 버텍스, 방문했는지 확인할 visited를 bfs 혹은 dfs를 사용하여 변수에 담습니다.
                visited = bfs_array(adjArray, vertex, visited);
//                visited = dfs_array(adjArray, vertex, visited);
            }
        }
        return count;
    }

    public boolean[] bfs_array(int[][] adjArray, int vertex, boolean[] visited) {
        //bfs의 경우 큐를 사용합니다.
        Queue<Integer> queue = new LinkedList<>();
        //시작지점을 큐에 넣어주고, 해당 버택스의 방문 여부를 변경합니다.
        queue.add(vertex);
        visited[vertex] = true;
        //큐에 더이상 방문할 요소가 없을 경우까지 반복합니다.
        while (!queue.isEmpty()) {
            //현재 위치를 큐에서 꺼내온 후
            int cur = queue.poll();
            //전체 배열에서 현재 버택스의 행만 확인합니다.
            for (int i = 0; i < adjArray[cur].length; i++) {
                //길이 존재하고, 아직 방문하지 않았을 경우
                if (adjArray[cur][i] == 1 && !visited[i]) {
                    //큐에 해당 버택스의 위치를 넣어준 이후
                    queue.add(i);
                    //방문여부를 체크합니다.
                    visited[i] = true;
                }
            }
        }
        //이어진 모든 길을 순회한 후 방문여부가 체크된 배열을 반환합니다.
        return visited;
    }

    public boolean[] dfs_array(int[][] adjArray, int vertex, boolean[] visited) {
        //현재 버택스의 방문여부를 체크합니다.
        visited[vertex] = true;
        //해당 버택스의 행을 순회합니다.
        for (int i = 0; i < adjArray.length; i++) {
            //만약 길이 존재하고, 방문하지 않았다면
            if (adjArray[vertex][i] == 1 && !visited[i]) {
                //재귀를 사용하여 이어진 길부터 탐색을 다시 시작합니다.
                dfs_array(adjArray, i, visited);
            }
        }
        //이어진 모든 길을 순회한 후 방문여부가 체크된 배열을 순회합니다.
        return visited;
    }
}

