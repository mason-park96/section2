package datastructure.graph;
/*
섬의 갯수 구하기!
2차원 배열의 요소 중 1 = 땅, 0 = 물을 의미한다.
1과 동서남북으로 인접한 공간이 1 (땅) 일 경우 이는 같은 섬을 의미한다.
이때, 주어진 그래프가 몇 개의 섬을 가지는지 구하자.
*/


public class DFSSolution {
    public static void main(String[] args) {
        char grid[][] = new char[][]{
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };

        DFSSolution dfsSolution = new DFSSolution();
        System.out.println("섬의 갯수는 다음과 같습니다.");
        System.out.println(dfsSolution.numIsland(grid));

    }

    public int numIsland(char[][] grid) {
        // 빈 배열 처리 !
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0; // 섬의 숫자를 담을 변수 선언 후 초기화
        // 이중 for 문을 사용하여 대륙 전체를 순회하기 위한 변수들임
        int numRows = grid.length;  // 행 길이
        int numCols = grid[0].length;   // 열 길이

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // 만약 내가 접근한 배열의 요소가 땅이라면(섬이라면)
                // 섬의 숫자를 증가시키고 DFS 로직으로 주변에 이어진 섬이 있는지 확인하자.
                // 근데 이렇게 되면 모든 섬에 대하여 numIsland++ 작업을 하니까 섬의 갯수가 제곱으로 반환되지 않나?
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    // i, j 좌표의 배열 요소에 대해서
    // 동서남북 방향으로 인접한 땅(1) 이 있는지 판별하는 메서드야.
    private void dfs(char[][] grid, int row, int col) {
        // 섬의 최대 길이 확인 (왜 하는거지 여기서는?)
        int numRows = grid.length;  // 행 길이
        int numCols = grid[0].length;   // 열 길이

        // 이동 후 좌표가 섬의 크기를 벗어나거나 바다를 만날 경우의 예외처리
        // 오매 그냥 종료시키는구나 이럼 에러 메시지 안뜨겠네.
        if(row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] == '0') {
            return;
        }

        // 방문한 땅을 0으로 바꾼다고?
        // visited 를 이렇게 처리하나?
        // 종이랑 팬이 있어야하는데 ㅠㅠ
        // 이게 핵심 로직이네 0으로 바꿔버리는거
        // 그래서 다음 좌표 탐색때 중복해서 섬 숫자를 저장안하는구나.
        // OK 굿굿
        // 섬 발견하면 갯수 + 1 처리 하고 연결된 땅 전부다 0 (바다)로 만들어버리네 없애버리네
        grid[row][col] = '0';

        // up, down, right, left 탐색 해줘야지 인접한 점이 섬인지 봐야하니까
        dfs(grid, row - 1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row + 1, col);
    }
}
