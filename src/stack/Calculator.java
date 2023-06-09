package stack;/*
스택을 이용하여 사칙연산 계산기를 구현하는 문제이다.
사용자로부터 수식 전체를 입력받아서 계산을 진행한다.

쉽게 말해서 중위 표기법을 후위 표기법으로 변환 후 후위 표기법을 연산하는 알고리즘을 작성하고자 한다.
 */

import java.beans.PropertyEditorSupport;
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
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int lenOfExpression = expression.length();

        for(int i = 0; i < lenOfExpression; i++) {
            char element = expression.charAt(i);
            if(Character.isDigit(element)) {
                // char to double 형변환. 아스키코드 때문에 - '0' 연산하여 대입
                double num = element - '0';
                // 그 다음 문자도 숫자일 경우, 현재 자릿수의 크기가 10배가 된다. 자릿수 연산을 해줘야함
                while(Character.isDigit(expression.charAt(i+1))) {
                    // 다음 자릿수가 연산자나 괄호가 나올때까지 자릿수 연산을 해준다.
                    num = num * 10 + (expression.charAt(i+1) - '0');
                    i++;
                }
                // 이제 하나의 char type 숫자를 온전히 double type 숫자로 형변환한 것이다.
                // 이 숫자를 stack에 추가
                numbers.push(num);
            } else if (element == '(') {
                operators.push(element);
            } else if (element == ')') {
                // ( ) 괄호 사이에 다른 연산자가 있을 경우 해당 연산자와 피연산자를 연산해야한다?
                // 입력됨과 동시에 연산을 처리해야하나?
                // 그럼 괄호 연산을 수행한 것과 마찬가지이다!
                while (operators.peek() != '(') {
                    double result = applyOperation(operators.pop(), numbers.pop(), numbers.pop());
                    numbers.push(result);
                }
                operators.push(element);
            } else if (element == '+' || element == '-' || element == '*' || element == '/') {
                // 내가 i 번째 연산자를 연산하고 싶은데, i 번째 연산자보다 높은 우선순위인 연산자가 있을 경우의 동작
                // 우선순위가 높은 연산부터 해줘야겠죠.
                while (!operators.isEmpty() && hasPrecendence(element, operators.peek())) {
                    double result = applyOperation(operators.pop(), numbers.pop(), numbers.pop());
                    numbers.push(result);
                }
                operators.push(element);
            }
        }
        // 이렇게 반복문을 끝낸 후, 나머지 연산을 실시한다.
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
            case  '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if(num2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return num1 / num2;
        }
        // 연산 안될 경우 0 리턴하라고?
        // 음 ...... 이건 왜 이런지 잘 모르겠네
        return 0;
    }
    // i번째 연산자와 top element 인 연산자를 비교하여 상위의 우선순위 연산자가 있나를 판별하는 메서드이다.
    public static boolean hasPrecendence(char op1, char op2) {
        if(op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
}
