/*
그래프, 시작점, 종점을 입력 받아서
입력 받은 그래프에서 입력받은 시작점으로부터 종점에 도달할 수 있는 경로가 존재하는지 return 하는 메서드
true false 반환 메서드
*/

package datastructure.koplit;

import java.util.ArrayList;
import java.util.Arrays;

public class DataStructureNum11 {

    public static void main(String[] args) {
        DataStructureNum11 num11 = new DataStructureNum11();

        int[][] matrix = new int[][]
                {
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0}
                };

        int[][] currentMatrix = new int[matrix.length][];

        for(int i = 0; i < matrix.length; i++) {
            currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
            System.out.println(Arrays.toString(currentMatrix[i]));
        }

    }

    public boolean getDirections(int[][] matrix, int from, int to) {
        //2차원 배열을 선언합니다.
        // 현재 그래프에 입력받은 그래프의 사이즈를 할당하여 선언
        // 굳이 지역 변수로 바꿔주는 이유가 있을까? 원본 데이터 보존인가.
        int[][] currentMatrix = new int[matrix.length][];

        // currentMatrix 에 매개변수로 입력받은 2차원 배열 matrix 를 복사하여 넣어준다.
        for (int i = 0; i < matrix.length; i++) currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        // 입력된 출발점(from) 과 도착점(to) 이 같다면 true 를 반환한다.
        // 이게 재귀함수의 탈출 조건이네. 흠 ......
        if (from == to) return true;

        // 입력된 출발지점의 1차원 배열을 순회합니다.
        // from 점과 다른 모든 정점과의 관계를 탐색하여
        // 어떤 정점이 연결된 정점인지 식별하는 작업이다.
        for (int i = 0; i < currentMatrix[from].length; i++) {
            // from 정점과 i 정점이 간선으로 연결되어 있다면
            if (currentMatrix[from][i] == 1) {
                // 해당 루트를 순회했다고 표시합니다( 1 -> 0으로 변경)
                // 이게 섬 땅덩어리 넓이 구하는 문제에서도 활용된 방식인데, 간선을 0 (없는 것) 으로 바꿔버린다. 이게 순회했다는 표시인가?
                // 그래, 재귀 과정에서 간선이 있을때만 (1일 때만) 동작하도록 조건을 걸었으니까, 0으로 표시하면 중복 순회를 안하지.
                // 이게 중복 탐색 방지구나.
                currentMatrix[from][i] = 0;
                // 표시된 행렬과, 출발지점을 현재 지점인 i로 변경하여 재귀함수를 실행합니다.
                // 재귀함수가 끝까지 도달하였을때 true를 반환한 경우 true를 반환합니다.
                // from 정점과 연결된 i 부터 시작해서 다시 경로를 탐색한다. 이때
                // 재귀를 반복하며 탈줄조건 (from == to) 을 만족할 경우 return true ----일 경우 ----> return true
                // 재귀함수의 결과를 조건으로 삼는 기술이다. 좋아 완전히 이해했어.
                if (getDirections(currentMatrix, i, to)) return true;
            }
        }
        //길을 찾을수 없는 경우 false를 반환합니다.
        // 위의 동작을 함으로서 전체 경로를 다 순회해도 from == to 인 경우가 없을 경우 return false. 경로가 없는 것이다.
        return false;
    }

}
