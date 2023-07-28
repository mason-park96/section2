package datastructure.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExerciseStack {
    public static void main(String[] args) {
        ExerciseStack exerciseStack = new ExerciseStack();
        Stack<Object> stack = new Stack<>();
        exerciseStack.pushStack(stack, "Hello World!");
        exerciseStack.pushStack(stack, 15);
        exerciseStack.pushStack(stack, 30);
        exerciseStack.pushStack(stack, 45);
        exerciseStack.popStack(stack);
        exerciseStack.popStack(stack);
        exerciseStack.popStack(stack);
    }

    public void pushStack(Stack stack, Object element) {
        stack.push(element);
        System.out.println("=".repeat(100));
        System.out.println("[삽입] " + element + " 이/가 Stack 에 삽입되었습니다!");
        System.out.println(stack);
    }

    public void popStack(Stack stack) throws EmptyStackException {
        stack.pop();
        System.out.println("=".repeat(100));
        System.out.println("[삭제] Stack 의 마지막 요소가 제거되었습니다!");
        System.out.println(stack);
    }
}
