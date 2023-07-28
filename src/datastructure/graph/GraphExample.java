package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphExample {

    // 그래프를 인접리스트로 표현한 것이다.
    public static void main(String[] args) {
        // 아래는 그래프를 인접행렬로 구현한 것이다.
        int[][] adjacencyMatrix = new int[][]{
                {0, 0, 1},
                {1, 0, 1},
                {1, 0, 0}
        };

        Arrays.stream(adjacencyMatrix)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce("", (a, b) -> a + " " + b)
                ).forEach(System.out::println);

        System.out.println();

        // 아래는 그래프를 인접 리스트로 나타낸 것이다.
        // 근데 왜 이런지 이해를 할 수가 없다 ......
        // A, B, C는 각각의 인덱스로 표기합니다. 0 == A, 1 == B, 2 == C 아하 이거구나

        /*
        인접 리스트는 언제 사용할까?
        메모리를 효율적으로 사용하고 싶을 때 인접 리스트를 사용한다.
        인접 행렬은 연결 가능한 모든 경우의 수를 저장하기 때문에 상대적으로 메모리를 많이 차지한다.
        */

        ArrayList<ArrayList<Integer>> AdjacentList = new ArrayList<>();
        AdjacentList.add(new ArrayList<>(Arrays.asList(2, null)));      // A로 시작해서 2(C) --> null
        AdjacentList.add(new ArrayList<>(Arrays.asList(0, 2, null)));   // B로 시작해서 0(A) --> 2(C) --> null
        AdjacentList.add(new ArrayList<>(Arrays.asList(0, null)));      // C로 시작해서 0(A) --> null

        System.out.println(AdjacentList.get(0));
        System.out.println(AdjacentList.get(1));
        System.out.println(AdjacentList.get(2));
    }
}
