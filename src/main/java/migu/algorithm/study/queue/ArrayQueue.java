package migu.algorithm.study.queue;

import migu.algorithm.study.data.IntData;

public class ArrayQueue extends Queue<IntData> {
    private final static int length = 100; //default length
    private int front;
    private int rear;
    private IntData[] queueArr;

    public ArrayQueue() {
        queueArr = new IntData[length];
    }

    public ArrayQueue(int length) {
        queueArr = new IntData[length];
    }

    private int getNextIdx(int idx) {
        if (idx == this.queueArr.length - 1)
            return 0;
        else
            return idx + 1;
    }

    @Override
    public void enqueue(IntData data) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            this.rear = getNextIdx(this.rear);
            queueArr[this.rear] = data;
        }
    }

    @Override
    public IntData dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            this.front = getNextIdx(this.front);
            return queueArr[this.front];
        }
    }

    @Override
    public IntData peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            return queueArr[getNextIdx(this.front)];
        }
    }

    @Override
    boolean isEmpty() {
        if (this.front == this.rear)
            return true;
        else
            return false;
    }

    @Override
    boolean isFull() {
        if (getNextIdx(this.rear) == this.front)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 1; i < 6; i++) {
            arrayQueue.enqueue(new IntData(i));
        }
        while (!arrayQueue.isEmpty()) {
            IntData data = arrayQueue.dequeue();
            if (data != null) {
                System.out.println(data.getData());
            }
        }

    }
}
