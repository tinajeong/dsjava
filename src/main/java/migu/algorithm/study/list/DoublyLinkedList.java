package migu.algorithm.study.list;

import migu.algorithm.study.data.IntData;
import migu.algorithm.study.data.IntDataDoubleNode;

public class DoublyLinkedList extends LinkedList<IntData> {
    private IntDataDoubleNode head;
    private IntDataDoubleNode tail;
    private IntDataDoubleNode curr;

    public DoublyLinkedList() {
        this.head = new IntDataDoubleNode(); //dummy
        this.tail = new IntDataDoubleNode(); //dummy
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    @Override
    void insertFront(IntData data) {
        IntDataDoubleNode newNode = new IntDataDoubleNode(data);
        if (head.getNext() != tail) {
            newNode.setPrev(head);
            newNode.setNext(head.getNext());
            head.getNext().setPrev(newNode);
            head.setNext(newNode);
        } else {
            newNode.setPrev(head);
            newNode.setNext(tail);
            head.setNext(newNode);
            tail.setPrev(newNode);
        }
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    void insertBehind(IntData data) {
        IntDataDoubleNode newNode = new IntDataDoubleNode(data);
        if (tail.getPrev() != head) {
            newNode.setNext(tail);
            newNode.setPrev(tail.getPrev());
            tail.getPrev().setNext(newNode);
            tail.setPrev(newNode);
        } else {
            newNode.setNext(tail);
            newNode.setPrev(head);
            head.setNext(newNode);
            tail.setPrev(newNode);
        }
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    boolean listFirst() {
        if (this.head.getNext() == tail) {
            return false;
        } else {
            this.curr = head.getNext();
            return true;
        }
    }

    @Override
    boolean listNext() {
        if (this.curr.getNext() == this.tail) {
            this.curr = null;
            return false;
        } else {
            this.curr = this.curr.getNext();
            return true;
        }
    }

    boolean listLast() {
        if (this.tail.getPrev() == this.head) {
            return false;
        } else {
            this.curr = tail.getPrev();
            return true;
        }
    }

    boolean listPrevious() {
        if (this.curr.getPrev() == head) {
            this.curr = null;
            return false;
        } else {
            this.curr = this.curr.getPrev();
            return true;
        }
    }

    @Override
    void removeData() {
        if (this.curr != null) {
            IntDataDoubleNode tbdNode = this.curr; //To be deleted Node
            if ((this.curr != head) && (this.curr != tail))  //check twice
            {
                tbdNode.getPrev().setNext(tbdNode.getNext());
                tbdNode.getNext().setPrev(tbdNode.getPrev());
                tbdNode = null;
                this.setNumOfData(this.getNumOfData() - 1);
            } else {
                System.out.println("Can't delete dummy node");
            }

        } else {
            System.out.println("Current Node is null");
        }
    }

    public IntDataDoubleNode getCurr() {
        return curr;
    }

    public void setCurr(IntDataDoubleNode curr) {
        this.curr = curr;
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

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.testDLL(true, true);
        doublyLinkedList.testDLL(true, false);
        doublyLinkedList.testDLL( false, true);
        doublyLinkedList.testDLL( false, false);
    }

    public void testDLL(boolean insertReverse, boolean travReverse) {
        if (insertReverse) {
            for (int i = 1; i < 6; i++) {
                insertFront(new IntData(i));
            }
        } else {
            for (int i = 1; i < 6; i++) {
               insertBehind(new IntData(i));
            }
        }

        System.out.println("insertion completed");
        if (travReverse) {
            if (listLast()) {
                printListStatus();
                System.out.printf("[\t%d\t", getCurr().getData());
                removeData();
                while (listPrevious()) {
                    System.out.printf("%d\t", getCurr().getData());
                    removeData();
                }
            }
            System.out.println("]");
        } else {
            if (listFirst()) {
                printListStatus();
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
}
