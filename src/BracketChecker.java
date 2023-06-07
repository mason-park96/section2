import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        String str = "Cheer up Korea! {}{{}}{}{}";
        isBalanced(str);
    }

    public static Boolean isBalanced(String formula) {
        /*
        파라미터로 받은 수식의 괄호가 수학적 문법에 맞게 배치되었는지 판별하는 메서드
        모든 여는 괄호에 대응하는 닫는 괄호가 있어야 함
        여는 괄호와 닫는 괄호의 순서가 일치해야 함
        모든 괄호 쌍은 서로 중첩되지 않음
        */

        Stack<Character> stack = new Stack<>();
        // String data --convert--> char[] data --convert--> stack data
        char[] charArray = formula.toCharArray();
        for (char element : charArray) {
            stack.push(element);
        }

        System.out.println(stack);
        return true;
    }
}
