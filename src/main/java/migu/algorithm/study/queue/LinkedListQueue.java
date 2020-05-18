package migu.algorithm.study.queue;

import migu.algorithm.study.data.IntData;
import migu.algorithm.study.data.IntDataNode;

public class LinkedListQueue extends Queue<IntData> {
    IntDataNode front;
    IntDataNode rear;

    @Override
    void enqueue(IntData data) {
        IntDataNode newNode = new IntDataNode(data);
        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
    }

    @Override
    IntData dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            IntDataNode temp = this.front;
            this.front = this.front.getNext();
            IntData data = new IntData(temp.getData());
            temp = null;
            return data;
        }
    }

    @Override
    IntData peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            IntData data = new IntData(this.front.getData());
            return data;
        }
    }

    @Override
    boolean isEmpty() {
        if (this.front == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        for (int i = 1; i < 6; i++) {
            linkedListQueue.enqueue(new IntData(i));
        }
        while (!linkedListQueue.isEmpty()) {
            IntData data = linkedListQueue.dequeue();
            if (data != null) {
                System.out.println(data.getData());
            }
        }
    }

}
