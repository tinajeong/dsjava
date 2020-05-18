package migu.algorithm.study.list;

public abstract class LinkedList<T> {
    private int numOfData = 0;
    private boolean ascending = false;

    void insertFront(T data ) {
    };
    void insertBehind(T data) {};
    void removeData() { };

    abstract boolean listFirst();

    abstract boolean listNext();

    int countData() {
        return numOfData;
    }

    int getNumOfData() {
        return numOfData;
    }

    void setNumOfData(int numOfData) {
        this.numOfData = numOfData;
    }

    boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
