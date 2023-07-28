package datastructure.tree.traversal;

// 이진 탐색 트리 후위 순회 알고리즘
// Date: 2023-07-28
// 작성자: 박무승

/*
 * 왼쪽 서브트리 --> 오른쪽 서브트리 --> 현재 노드 순서대로 탐색하는
 * 알고리즘을 의미한다.
 * */

import datastructure.tree.BinaryTree;

import java.util.ArrayList;

public class PostorderTraverse {
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

        PostorderTraverse post = new PostorderTraverse();

        post.postOrder(tree, list);

        System.out.println(list);
    }

    public ArrayList<String> postOrder(BinaryTree node, ArrayList<String> list) {
        if (node != null) {
            list = postOrder(node.getLeftChild(), list);
            list = postOrder(node.getRightChild(), list);
            list.add(node.getData());
        }
        return list;
    }
}
