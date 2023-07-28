package datastructure.tree.traversal;

// 이진 탐색 트리 전위 순회 알고리즘
// Date: 2023-07-27
// 작성자: 박무승

/*특정 데이터가 저장된 노드를 찾을 때 까지 전체 노드를 하나씩 탐색하는 알고리즘이다.
트리 구조는 계층 구조이다.
때문에 대표적으로 전위, 중위, 후위 순회 알고리즘의 3 가지 탐색 방식이 있다.
아래에서는 전위 순회 알고리즘 예시와 그 설명을 작성하겠다.*/

import datastructure.tree.BinaryTree;
import java.util.ArrayList;

public class PreorderTraverse {
    // 여기서 노드를 멤버 클래스로 작성하면
    // 전위 순회를 할때 노드가 같이 로딩된다는건데
    // 이미 존재하는 이진 탐색 트리를 탐색하는 알고리즘이니까 좀 부적절한가?
    // 생성할때 이진 탐색 트리를 의존성 주입 받아서 하는게 더 좋겠네

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        BinaryTree tree = new BinaryTree("A");
        tree.setLeftChild(new BinaryTree("B"));
        tree.setRightChild(new BinaryTree("C"));
        tree.getLeftChild().setLeftChild(new BinaryTree("D"));
        tree.getLeftChild().setRightChild(new BinaryTree("E"));
        tree.getRightChild().setLeftChild(new BinaryTree("F"));
        tree.getRightChild().setRightChild(new BinaryTree("G"));
        tree.getLeftChild().getLeftChild().setLeftChild(new BinaryTree("H"));
        tree.getLeftChild().getLeftChild().setRightChild(new BinaryTree("I"));
        tree.getLeftChild().getRightChild().setLeftChild(new BinaryTree("J"));
        tree.getLeftChild().getRightChild().setRightChild(new BinaryTree("K"));
        tree.getRightChild().getLeftChild().setLeftChild(new BinaryTree("L"));
        tree.getRightChild().getLeftChild().setRightChild(new BinaryTree("M"));
        tree.getRightChild().getRightChild().setLeftChild(new BinaryTree("N"));
        tree.getRightChild().getRightChild().setRightChild(new BinaryTree("O"));

        PreorderTraverse pre = new PreorderTraverse();

        pre.preOrder(tree, list);
        System.out.println(list);

    }


    // 재귀 용법으로 전위 순회가 어떤 순서로 노드를 탐색하는지
    // 보여주기 위한 메서드이다.
    // 먼저 노드 탐색하고, 왼쪽 자식노드 탐색하고, 오른쪽 자식노드 탐색하고
    // 노드가 null 이면 (탐색이 끝나면) 여태 탐색한 노드의 이력(list)을 return 하는데
    // 그럼 몇 번 리턴하는거야?
    // 중요한건 매개변수로 받은 list 에 탐색한 노드를 저장해주니까
    // 몇 번 return 하든 알빠노? 아무튼 난 저장하니까 상관없다 이거야
    // 그냥 탈출조건이면, return; 으로 코드를 바꿔도 전혀 상관이 없겠네.
    // return 타입 명시된것 때문에 안되네. 근데 애초에 void 로 해도 상관없잖아.
    public ArrayList<String> preOrder(BinaryTree node, ArrayList<String> list) {
        if (node != null) {
            list.add(node.getData());
            list = preOrder(node.getLeftChild(), list);
            list = preOrder(node.getRightChild(), list);
        }
        return list;
    }
}
