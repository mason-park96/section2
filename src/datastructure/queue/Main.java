package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 데이터 추가
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // peek() 메서드로 맨 앞 요소 확인
        int frontElement = queue.peek();
        System.out.println("맨 앞 요소: " + frontElement);

        // 큐 출력
        System.out.println("큐의 모든 요소:");
        for (int num : queue) {
            System.out.println(num);
        }
    }
}