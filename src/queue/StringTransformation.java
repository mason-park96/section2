package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StringTransformation {
    public static void main(String[] args) {

    }
    private Queue<Character> queue;

    public StringTransformation() {
        queue = new LinkedList<>();
    }

    public void getString(String str) {
        for(char letter : str.toCharArray()) {
            System.out.println();
        }
    }
}
