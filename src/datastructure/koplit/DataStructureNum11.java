/*
그래프, 시작점, 종점을 입력 받아서
입력 받은 그래프에서 입력받은 시작점으로부터 종점에 도달할 수 있는 경로가 존재하는지 return 하는 메서드
true false 반환 메서드
*/

package datastructure.koplit;

public class DataStructureNum11 {

    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );

        System.out.println(result);
    }
    public static boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:
        // to 를 방문할 때 까지
        // 모든 경로를 다 탐색
        // 다 탐색해도 to 가 안나오면 false
        // 다 탐색했는데 to 가 나오면 즉시 종료 후 true return
        boolean result = false;
        int numOfNodes = matrix.length;
        boolean[] visited = new boolean[numOfNodes];
        dfs(matrix, visited, from, to, result);
        return result;
    }

    private static void dfs(int[][] array, boolean[] visited, int src, int to, boolean result) {
        if (src == to) {
            result = true;
            return;
        }

        // 이미 방문했다면 (탈출 !!)
        if (visited[src]) {
            return;
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
                dfs(array, visited, index, to, result);
            }
        }
    }
}
