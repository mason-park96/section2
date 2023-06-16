package queue;

public class CircularQueue {
    int front;
    int rear;
    Object[] circularQueue;

    // k 만큼의 크기를 갖는 원형 큐 초기화
    public void MyCircularQueue(int k) {
        this.circularQueue = new Object[k];
        this.front = -1;
        this.rear = -1;
    }

    public void enQueue(Object value) {
        this.rear++;
        if(this.rear >= this.circularQueue.length) {
            this.rear = 0;
        }
        this.circularQueue[rear] = value;
    }

    public void deQueue() {
        if(this.circularQueue.length == 0) {
            System.out.println("빈 배열이므로 삭제할 원소가 없습니다.");
            return;
        }

        this.front++;
    }

    public int getRear() {
        return this.rear;
    }

    public boolean isEmpty() {
        // if(queue.size() == 0) return true;
        // else return false;
    }

    public boolean isFull() {

    }
}
