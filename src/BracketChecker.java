import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        String str = "Cheer up Korea! [{(3+3)(*5}/7]";
        System.out.println(isBalanced(str));
    }

    public static Boolean isBalanced(String formula) {
        /*
        파라미터로 받은 수식의 괄호가 수학적 문법에 맞게 배치되었는지 판별하는 메서드
        모든 여는 괄호에 대응하는 닫는 괄호가 있어야 함
        여는 괄호와 닫는 괄호의 순서가 일치해야 함
        모든 괄호 쌍은 서로 중첩되지 않음
        */


        Stack<Character> stack = new Stack<>();

        // 스택이 비었을 경우 오른쪽 괄호가 입력되면 안된다.
        // 만약 오른쪽 괄호가 들어왔다면 그 전에 입력된 괄호는 동일한 종류의 왼쪽 괄호여야 한다.
        // 왼쪽 괄호는 언제든지 추가되어도 상관없다.
        // 전체 수식에 대하여 탐색하여야 하며, String formula 를 Stack stack 에 넣어줘야 한다.

        for (int i = 0; i < formula.length(); i++) {
            // 수식에서 괄호 부호만 추출한다.
            char element = formula.charAt(i);
            if (element == '{' || element == '[' || element == '(') {
                stack.push(element);
            } else if (element == '}' || element == ']' || element == ')') {
                // 빈 배열에 바로 우측 괄호
                if(stack.empty()) {
                    return false;
                }

                // 스택은 비어있지 않은데 (기존에 왼쪽 괄호가 입력이 됐는데) 오른쪽 괄호가 들어온 경우
                // 가장 최근에 입력된 괄호가 동일한 종류의 왼쪽 괄호인지 확인해야한다.
                // 맞으면 Good, 아니면 return false

                char top = stack.pop();

                if (element == '}' && top != '{' || element == ']' && top != '[' || element == ')' && top != '(') {
                    return false;
                }
            }
        }

        System.out.println(stack);
        return stack.isEmpty();
    }
}
