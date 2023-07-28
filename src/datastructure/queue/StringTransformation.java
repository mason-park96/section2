package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StringTransformation {
    public static String transformString(String input) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder output = new StringBuilder();

        // Queue 에 문자 넣기 완료
        for (Character letter : input.toCharArray()) {
            queue.offer(letter);
        }

        // datastructure.queue 의 모든 요소를 다 출력할 때 까지 (빈 queue가 될 때 까지) 반복
        while (!queue.isEmpty()) {
            output.append(queue.poll());
            // 위에서 append(datastructure.queue.poll()) 함으로 인하여 datastructure.queue 가 빈 datastructure.queue 가 된 상태인데
            // poll() 메서드로 빈 datastructure.queue 에 접근해서 OutOfMemoryError 에러 발생한다고?
            // null 을 반환해야 할텐데
            // datastructure.queue 가 비어있을 경우 datastructure.queue.poll(); 하면 null 을 return 하는데 이때 이 null을
            // 다시 datastructure.queue 에 넣어주니까 datastructure.queue.size() 가 계속 0에서 1로 바뀌는구나.
            // 그래서 무한 루프 발생하였구나.
            if(!queue.isEmpty()) {
                // 아래의 코드 한 줄 자체가 무한루프를 야기하는 코드이기 때문에
                // 조건문으로 접근을 제한하였구나.
                queue.offer(queue.poll());
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력해주세요: ");
        String input = scanner.next();
        System.out.println();
        System.out.println("변경된 문자열입니다: " + transformString(input));
    }
}
