package graph;

public class KoplitDataStructure07 {
    // 이 클래스는 멤버 변수로 graph 를 가지네
    // graph 를 생성하는 것이 이 클래스의 목적이구나?
    private int[][] graph;

    // 클래스 내에서만 int[][] graph 에 접근할 수 있으니까 Getter Setter 선언하는거지.
    // vertex 의 갯수 == size 로 2차원 배열을 생성해서 graph 에 할당하는구나
    // 그 후에 모든 원소를 0 으로 초기화하네.
    public void setGraph(int size) {
        graph = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }
    public int[][] getGraph() {
        return graph;
    }
    public void addEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return;  // 잘못된 값을 입력받으면 함수를 종료하는구나.
        graph[from][to] = 1;    // 정상적인 값을 입력받으면, 해당 두 간선이 연결돼있다는 뜻에서 원소에 1을 저장하는구나?
    }

    public boolean hasEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return false;    // vertex 가 아닌 다른 숫자를 입력받을 경우 false 리턴하고
        else if(graph[from][to] == 1) return true;    // 정상적인 두 vertex 가 연결되어 있는지 물어보면 정상 처리
        else return false;  // 1 아니면 연결 안되어있으니까 false 리턴
    }

    public void removeEdge(int from, int to) {
        // 정상 입력 아니면 컷. 아 이게 왜 이렇게 한 땀 한 땀 하나 했더니
        // 잘못된 영역을 참조한다고 에러 뜨겠네 이거 안하면 ㅇㅋㅇㅋ
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 0;
        // 연결 끊어야 하니까 해당 원소에 0 넣어줘야지 ㅠㅠ
    }
}
