package migu.algorithm.study.data;

public class IntDataDoubleNode extends IntData {
    private IntDataDoubleNode prev;
    private IntDataDoubleNode next;

    public IntDataDoubleNode() {
        super();
    }

    public IntDataDoubleNode(int data) {
        super(data);
    }
    public IntDataDoubleNode(IntData data) {
        this.setData(data.getData());
    }

    public IntDataDoubleNode getPrev() {
        return prev;
    }

    public void setPrev(IntDataDoubleNode prev) {
        this.prev = prev;
    }

    public IntDataDoubleNode getNext() {
        return next;
    }

    public void setNext(IntDataDoubleNode next) {
        this.next = next;
    }
}
