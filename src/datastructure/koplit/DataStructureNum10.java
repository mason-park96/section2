package datastructure.koplit;
/*
이차원 배열을 입력하면
그 배열이 서술하는 인접행렬을 return 하는 메서드 작성
converter 네
Encoder 라고 봐도될듯
*/

public class DataStructureNum10 {

    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });


    }
    public static int[][] createMatrix(int[][] edges) {
        // TODO:
        // 먼저 edges 의 각 행의 0, 1번째 요소 중 최댓값을 구해야해
        // 그 최댓값이 인접행렬의 row, col 임

        int sizeOfGraph = 0;

        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j <= 1; j++) {
                if (edges[i][j] > sizeOfGraph) {
                    sizeOfGraph = edges[i][j];
                }
            }
        }
        // 이제 사이즈 알았으니까 graph 생성
        int[][] graph = new int[sizeOfGraph][sizeOfGraph];

        for(int i = 0; i < edges.length; i++) {
                convert(graph, edges[i][0], edges[i][1], edges[i][2]);
        }

        System.out.println(graph.length);
        System.out.println(graph[0].length);
        return graph;
    }

    private static void convert(int[][] graph, int row, int col, int direction) {
        // 예외처리

        int numRows = graph.length;  // 행 길이
        int numCols = graph[0].length;   // 열 길이

        if(row < 0 || col < 0 || row >= numRows || col >= numCols) {
            return;
        }

        if(direction == 0) {
            graph[row][col] = 1;
        } else if (direction == 1) {    // 무방향
            graph[row][col] = 1;
            graph[col][row] = 1;
        }
    }
}
