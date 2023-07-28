package datastructure.tree;

public class BinaryTree {
    private String data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(String data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    public String getData() {
        return data;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    @Override
    public String toString() {
        return "Value: " + data + ", Left Child: " + (leftChild != null ? leftChild.getData() : "null")
                +", Right Chile: " + (rightChild != null ? rightChild.getData() : "null");
    }
}
