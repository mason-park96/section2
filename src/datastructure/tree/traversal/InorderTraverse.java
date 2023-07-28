package datastructure.tree.traversal;

import datastructure.tree.BinaryTree;

import java.util.ArrayList;

public class InorderTraverse {
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

        InorderTraverse in = new InorderTraverse();

        in.inOrder(tree, list);
        System.out.println(list);
    }

    public ArrayList<String> inOrder(BinaryTree node, ArrayList<String> list) {
        if(node != null) {
            list = inOrder(node.getLeftChild(), list);
            list.add(node.getData());
            list = inOrder(node.getRightChild(), list);
        }
        return list;
    }
}
