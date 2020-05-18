package migu.algorithm.study.list;

import migu.algorithm.study.data.IntData;
import migu.algorithm.study.data.IntDataNode;
class SinglyLinkedList extends LinkedList<IntData> {
    private IntDataNode before;
    private IntDataNode head = new IntDataNode(); // dummy
    private IntDataNode curr;
    public SinglyLinkedList() {
        super();
    }

    @Override
    void insertFront(IntData data) {
        IntDataNode newNode = new IntDataNode(data);
        if (this.isAscending()) {
            IntDataNode preNode = this.head; // preNode of newNode
            while ((preNode.getNext() != null) && (compareTo(newNode.getData(), preNode.getNext().getData()) == 1)) {
                preNode = preNode.getNext();
            }
            newNode.setNext(preNode.getNext());
            preNode.setNext(newNode);
            this.setNumOfData(this.getNumOfData() + 1);
        } else {
            // insert data in head regardless of number
            newNode.setNext(this.head.getNext());
            this.head.setNext(newNode);
            this.setNumOfData(this.getNumOfData() + 1);
        }
    }


    @Override
    void removeData() {
        IntDataNode currNode = curr;
        if (currNode != null) {
            this.before.setNext(curr.getNext());
            curr = this.before;
            this.setNumOfData(this.getNumOfData() - 1);
            currNode = null;
        } else {
            printListStatus();
        }
    }

    @Override
    boolean listFirst() {
        if (this.head.getNext() == null) {
            return false;
        }
        this.before = this.head;
        curr = this.head.getNext();

        return true;
    }

    @Override
    boolean listNext() {
        if (this.head.getNext() == null) {
            return false;
        }

        this.before = curr;
        IntDataNode tobeNext = before.getNext();
        if ((this.before != null) && (tobeNext != null)) {
            curr = tobeNext;
            return true;
        } else {
            return false;
        }
    }

    private int compareTo(int data1, int data2) {
        return Integer.compare(data1, data2);
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
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.testSLL();
        singlyLinkedList.setAscending(true);
        singlyLinkedList.testSLL();
    }

    public void testSLL() {
        for (int i = 1; i < 6; i++) {
            insertFront(new IntData(i));
        }

        System.out.println("insertion completed");

        if (listFirst()) {
            System.out.printf("[\t%d\t", getCurr().getData());
            removeData();
            while (listNext()) {
                System.out.printf("%d\t", getCurr().getData());
                removeData();
            }
        }
        System.out.println("]");

        printListStatus();
    }

}
