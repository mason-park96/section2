package queue;

import java.util.*;

public class KoplitDataStructure04 {

    public static void main(String[] args) {
        KoplitDataStructure04 koplitDataStructure04 = new KoplitDataStructure04();
        System.out.println(koplitDataStructure04.paveBox(new Integer[] {8, 6, 4, 2, 3, 9, 7, 4, 8, 13, 12, 13, 10}));
    }
    public int paveBox(Integer[] boxes) {
        // TODO:
        // 반복문을 사용하여야 한다.
        // 배열을 순회하며 배열 가장 앞에 있는 요소보다 큰 값을 가지는 요소를 찾는다.
        // 찾으면 첫 요소부터 해당 요소 앞의 요소까지 몇 개 인지 파악하여 int exitNum 에 대입
        // int maxExitNum (초기값 0) 과 비교하여 더 큰 값을 int maxExitNum 에 대입
        // 반복문이 끝나고 maxExitNum 을 return

        int firstBoxNum = 0;
        int firstBoxSize = 0;
        int exitNum = 0;
        int maxExitNum = 0;

        for (int i = 0; i < boxes.length; i++) {

            firstBoxSize = boxes[firstBoxNum];

            if (boxes[i] > firstBoxSize) {
                exitNum = i - firstBoxNum;
                maxExitNum = Math.max(maxExitNum, exitNum);
                firstBoxNum = i;
            }

            if(i == boxes.length - 1) {
                exitNum = i - firstBoxNum + 1;
                maxExitNum = Math.max(maxExitNum, exitNum);
            }
        }

        return maxExitNum;
    }

    // Queue 를 순회하여 최대값을 return 하는 메서드
    private int findMaxElement(Queue<Integer> queue) {
        // 빈배열 처리
        if (queue.isEmpty()) {
            throw new IllegalArgumentException(("Queue is Empty"));
        }

        Integer maxElement = Integer.MIN_VALUE;

        for (Integer element : queue) {
            if (maxElement < element) {
                maxElement = element;
            }
        }

        return maxElement;

    }
}
