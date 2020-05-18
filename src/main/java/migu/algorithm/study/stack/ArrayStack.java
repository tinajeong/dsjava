package migu.algorithm.study.stack;

import migu.algorithm.study.data.IntData;

public class ArrayStack extends Stack<IntData> {
    public static final int length = 100; //default length
    private IntData[] dataList;
    private int topIndex = -1;

    public ArrayStack() {
        dataList = new IntData[length];
    }

    public ArrayStack(int length) {
        dataList = new IntData[length];
    }

    @Override
    void push(IntData data) {
        dataList[++topIndex] = data;
    }

    @Override
    IntData pop() {
        IntData temp = dataList[topIndex];
        dataList[topIndex--] = null;
        return temp;
    }

    @Override
    public IntData peek() {
        return !isEmpty() ? dataList[topIndex] : null;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void printArray()
    {
        for(int i =0; i<=topIndex;i++)
        {
            System.out.println(dataList[i].getData());
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        System.out.println("isEmpty: " + arrayStack.isEmpty());
        for (int i = 0; i < 5; i++) {
            arrayStack.push(new IntData(i));
        }
        arrayStack.printArray();

        System.out.println("isEmpty: " + arrayStack.isEmpty());
        if (!arrayStack.isEmpty()) {
            System.out.println("peek: " + arrayStack.peek().getData());
        }

        while (!arrayStack.isEmpty()) {
            System.out.println("pop: " + arrayStack.pop().getData());
            arrayStack.printArray();
        }
    }
}
