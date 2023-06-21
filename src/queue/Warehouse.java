package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        // 생성자가 창고랑 선반 다 생성해서 할당함.
        Warehouse warehouse = new Warehouse();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 물건 보관하기");
            System.out.println("2. 물건 꺼내기");
            System.out.println("3. 종료하기");
            System.out.print("원하는 작업의 번호를 입력하세요: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("보관할 물건의 번호를 입력하세요.: ");
                int item = scanner.nextInt();
                warehouse.store(item);
            } else if (choice == 2) {
                warehouse.retrieve();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
            System.out.println();
        }
    }

    private Queue<Integer>[] shelves;

    // Queue 초기화
    // 창고는 5개의 공간(선반)을 가진다.
    // 이때 1개의 공간(선반) == 1개의 Queue (linkedList)
    // 생성하여 할당해주자.
    public Warehouse() {
        shelves = new Queue[5]; // 5개의 선반 생성
        for (int i = 0; i < shelves.length; i++) {
            shelves[i] = new LinkedList<>();
        }
    }

    public void store(int item) {
        // 무엇을 위한 상태 관리이지?
        // 보관할 수 없는 경우의 조건 마련을 위한 상태값이구나!
        boolean stored = false;
        for(Queue<Integer> shelf : shelves) {
            // 각 공간의 사이즈를 10으로 제한하였구나
            // 이와같은 방법으로 Queue Size 에 제한을 둘 수 있겠다!
            // 대신 리소스를 좀 잡아먹겠네.
            if(shelf.size() < 10) {
                shelf.add(item);
                System.out.println(item + "이가 " + (Arrays.asList(shelves).indexOf(shelf) + 1) + "번 선반에 보관되었습니다.");
                stored = true;
                break;
            }
        }

        if(!stored) { // 모든 선반이 꽉 차 있는 경우 보관 불가 메시지 출력
            System.out.println("보관할 수 있는 공간이 없습니다.");
        }
    }
    // 검색하여 가장 먼저 보관된 물건을 꺼내는 함수

    public int retrieve() {
        int item = -1;  // 초기값
        for (Queue<Integer> shelf : shelves) {
            if (!shelf.isEmpty()) { //만약 선반에 물건이 있다면
                item = shelf.poll();    // 선반에 저장된 데이터를 꺼냄. 가장 먼저 저장된 데이터 !!
                System.out.println(item + "이(가)"  + (Arrays.asList(shelves).indexOf(shelf) + 1) + "번 선반에서 꺼내졌습니다.");
                break;
            }
        }

        if (item == -1) {
            System.out.println("보관된 물건이 없습니다.");
        }
        return  item;
    }
}