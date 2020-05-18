package migu.algorithm.study.list;

import migu.algorithm.study.data.IntData;
import migu.algorithm.study.data.IntDataNode;

public class CircularLinkedList extends LinkedList<IntData> {
    private IntDataNode tail = new IntDataNode(); //dummy
    private IntDataNode before;
    private IntDataNode curr;

    public CircularLinkedList() {
        super();
        //dummy count
        this.setNumOfData(1);
    }

    @Override
    void insertFront(IntData data) {
        IntDataNode newNode = new IntDataNode(data);
        newNode.setNext(this.tail.getNext());
        this.tail.setNext(newNode);
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    void insertBehind(IntData data) {
        IntDataNode newNode = new IntDataNode(data);
        newNode.setNext(this.tail);
        if (tail.getNext() == null) {
            this.tail.setNext(newNode);
        } else {
            this.before = tail.getNext();
            while (before.getNext() != this.tail) {
                this.before = before.getNext();
            }
            this.before.setNext(newNode);
        }
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    void removeData() {
        IntDataNode currNode = this.curr;
        if (currNode != null && getNumOfData() != 1) {
            IntData intData = new IntData(currNode.getData());
            if (currNode.getNext() == this.tail) {
                this.before.setNext(this.tail);
            } else {
                this.before.setNext(this.curr.getNext());
            }
            this.curr = this.before;
            this.setNumOfData(this.getNumOfData() - 1);
            currNode = null;
        } else {
            printListStatus();
        }
    }

    @Override
    boolean listFirst() {
        if (this.tail.getNext() == null) {
            return false;
        } else if (this.getNumOfData() == 1) {
            return false;
        }
        this.before = this.tail;
        this.curr = before.getNext();
        return true;
    }

    @Override
    boolean listNext() {
        if (this.tail.getNext() == null) {
            return false;
        } else if (this.getNumOfData() == 1) {
            return false;
        }
        this.before = this.curr;
        this.curr = this.before.getNext();
        return true;
    }

    public void printListStatus() {
        if (curr != null) {
            System.out.printf("info of linked list: \n" +
                            "\t- currentData: %d\n" +
                            "\t- numOfData: %d\n\n"
                    , curr.getData(), this.getNumOfData());

        } else {
            System.out.println("[Error]: Unable to print list status: Could not refer current node - null");
        }
    }

    public IntDataNode getCurr() {
        return curr;
    }

    public void setCurr(IntDataNode curr) {
        this.curr = curr;
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.testCLL(true);
        circularLinkedList.testCLL(false);
    }

    public void testCLL(boolean isFront) {
        if (isFront) {
            for (int i = 1; i < 6; i++) {
                insertFront(new IntData(i));
            }
        } else {
            for (int i = 1; i < 6; i++) {
                insertBehind(new IntData(i));
            }
        }
        if (listFirst()) {
            System.out.printf("[\t%d\t", getCurr().getData());
            removeData();
            while (listNext()) {
                System.out.printf("%d\t", getCurr().getData());
                removeData();
            }
        }
        System.out.println("]");

    }

}
