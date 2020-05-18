package migu.algorithm.study.stack;

import migu.algorithm.study.data.IntData;
import migu.algorithm.study.data.IntDataNode;

public class LinkedListStack extends Stack<IntData> {
    IntDataNode head;


    @Override
    void push(IntData data) {
        IntDataNode newNode = new IntDataNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    IntData pop() {
        if (!isEmpty()) {
            IntDataNode tbdNode = head;
            head = head.getNext();
            IntData topNode = (IntData) head;
            tbdNode = null;
            return topNode;
        }
        return null;
    }

    @Override
    IntData peek() {
        return !isEmpty() ? new IntData(head.getData()) : null;
    }

    @Override
    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        System.out.println("isEmpty: " + linkedListStack.isEmpty());
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(new IntData(i));
        }

        System.out.println("isEmpty: " + linkedListStack.isEmpty());
        if (!linkedListStack.isEmpty()) {
            System.out.println("peek: " + linkedListStack.peek().getData());
        }

        while (!linkedListStack.isEmpty()) {
            IntData intData = linkedListStack.pop();
            if (intData != null)
                System.out.println("pop: " + intData.getData());
        }
    }
}
