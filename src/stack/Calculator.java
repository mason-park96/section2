package stack;/*
스택을 이용하여 사칙연산 계산기를 구현하는 문제이다.
사용자로부터 수식 전체를 입력받아서 계산을 진행한다.

쉽게 말해서 중위 표기법을 후위 표기법으로 변환 후 후위 표기법을 연산하는 알고리즘을 작성하고자 한다.
 */

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("수식을 입력하세요: ");
        String input = sc.nextLine();
        double result = evaluate(input);
        System.out.println("결과: " + result);
    }

    public static double evaluate(String expression) {
        // 수식으로부터 연산자와 피연산자를 구분하여 추출해야 한다고?
        // 완전히 구분해서 추출해버리면, 후위 표기법이 아닌 것 같기도 하고 잘 모르겠네 ㅠㅠ
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int lenOfExpression = expression.length();

        for (int i = 0; i < lenOfExpression; i++) {
            // String type 데이터인 수식을 한 글자 한 글자 다 추출해서 연산을 할거야
            // 피연산자는 피연산자에 맞는 처리, 연산자는 연산자에 맞는 처리를 할건데 이때 처리란
            // 피연산자는 numbers 에 push
            // 연산자는 operators 에 push
            char element = expression.charAt(i);
            if (Character.isDigit(element)) { // 만약 피연산자이면 (숫자이면)
                // char to double 형변환. 아스키코드 때문에 - '0' 연산하여 대입
                double num = element - '0';
                // 그 다음 문자도 숫자일 경우, 현재 자릿수의 크기가 10배가 된다. 자릿수 연산을 해줘야함
                // 133 일 경우, 1 --> (1 * 10) + 3 ---> (13 * 10) + 3 이렇게 처리해줘야함.
                // 언제까지? 다음 문자가 숫자가 아닐 때 까지
                // nullPointException 이 발생할 수도 있다. 따라서, i+1 < lenOfExpression 이어야 한다.
                // 그래야 expression 의 마지막 글자 까지만 탐색함. 안걸어주면 할당 안된 주소 참조해서 바로 에러남
                while (i + i < lenOfExpression && Character.isDigit(expression.charAt(i + 1))) {
                    // 다음 자릿수가 연산자나 괄호가 나올때까지 자릿수 연산을 해준다.
                    num = num * 10 + (expression.charAt(i + 1) - '0');
                    i++;
                }
                // 이제 하나의 char type 숫자를 온전히 double type 숫자로 형변환한 것이다.
                // 이 숫자를 stack 에 추가
                numbers.push(num);
            } else if (element == '(') {
                operators.push(element);
            } else if (element == ')') {
                // ( ) 괄호 사이에 다른 연산자가 있을 경우 해당 연산자와 피연산자를 연산해야한다?
                // 입력됨과 동시에 연산을 처리해야하나?
                // 그럼 괄호 연산을 수행한 것과 마찬가지이다!
                while (operators.peek() != '(') {
                    double result = applyOperation(operators.pop(), numbers.pop(), numbers.pop());
                    // 괄호 연산자 사이에 다른 연산자가 있을 경우, 피연산자들을 그 연산자로 연산해준다.
                    // 그리고 숫자 제거하고, 연산 결과 넣어줌
                    numbers.push(result);
                }
                // 이게 머선 말이냐, 우괄호 찾을 경우!
                // 괄호 사이의 연산자로 피연산자 연산해서 넣어줌
                // 좌괄호 제거 ---> 결과적으로 (, 연산자, ) 셋 다 제거해주는거임!
                operators.pop();
            } else if (element == '+' || element == '-' || element == '*' || element == '/') {
                // 이건 i 번째 element 가 괄호 없는 일반적인 연산자일 경우인데
                // 이때는 우선순위 더 높은 연산자가 operators stack 에 저장되어 있는지 확인하고
                // 저장되어 있으면 연산 해버림.
                // 우선순위 더 높은 연산을 모두 찾고 모두 연산하고 나면 (그럼 다 삭제됨)
                // 연산자를 다 pop() 하고, 연산결과 (result)를 다 push()하고
                while (!operators.isEmpty() && hasPrecedence(element, operators.peek())) {
                    double result = applyOperation(operators.pop(), numbers.pop(), numbers.pop());
                    numbers.push(result);
                }
                // 우선순위가 더 높은 연산자에 대한 연산을 다 끝낸 다음에, 비로소 현재 i 번째 element 가 가지고 있는
                // 연산자를 operators stack 에 저장함
                operators.push(element);
            }
        }
        // 이렇게 반복문을 끝낸 후, 모든 괄호 연산과 우선순위가 높은 연산을 다 끝내고 나면
        // 남아있는 연산자와 피연산자에 대한 연산을 한다.
        // 언제까지? operators stack 이 다 없어질때까지
        while (!operators.isEmpty()) {
            double result = applyOperation(operators.pop(), numbers.pop(), numbers.pop());
            numbers.push(result);
        }
        // 연산자 스택과 피연산자 스택을 둘 다 비워야하나
        return numbers.pop();

    }

    // 연산자, 피연산자를 입력받아서 사칙연산 하는 메서드
    // pop() 메서드는top element 부터 반환하기 때문에 파라미터로 받아서 가공할때 순서를 잘 살펴야한다.
    // 뺄셈, 나눗셈 연산 등에서 계산이 틀릴 수 있기 때문이다.
    private static double applyOperation(char operator, double num2, double num1) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return num1 / num2;
        }
        // 연산 안될 경우 0 리턴하라고?
        // 음 ...... 이건 왜 이런지 잘 모르겠네
        return 0;
    }

    // i번째 연산자와 top element 인 연산자를 비교하여 상위의 우선순위 연산자가 있나를 판별하는 메서드이다.
    // op1 == element
    // op2 == operators.peek()
    // 즉, op2 이 우선순위가 더 높으면 true
    // op1 이 우선순위가 더 높으면 false
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            // 근데 이거 operators.peek() 이 element 보다 우선순위 더 높은거아냐?
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            // 이건 명백히 op1 이 우선순위가 더 높은 경우인데, 이때 false return 하네
            return false;
        }
        // 위의 두 경우를 제외하면 op2 가 우선순위가 더 높은 케이스인가봐
        return true;
    }
}
