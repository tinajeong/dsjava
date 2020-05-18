package migu.algorithm.study.data;

public class BiTreeIntDataNode extends BiTreeDataNode{
    private IntData data;

    public BiTreeIntDataNode() {
        super();
    }

    public BiTreeIntDataNode(IntData data) {
        super();
        this.data = data;
    }

    public IntData getData() {
        return data;
    }

    public void setData(IntData data) {
        this.data = data;
    }
}
