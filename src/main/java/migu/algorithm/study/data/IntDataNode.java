package migu.algorithm.study.data;

public class IntDataNode extends IntData {
    private IntDataNode next;

    public IntDataNode() {
        super();
    }

    public IntDataNode(IntData intData)
    {
        this.setData(intData.getData());
    }

    public IntDataNode(IntDataNode next) {
        super();
        this.next = next;
    }

    public IntDataNode getNext() {
        return next;
    }

    public void setNext(IntDataNode next) {
        this.next = next;
    }
}
