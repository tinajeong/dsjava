package migu.algorithm.study.list;

import migu.algorithm.study.data.IntData;

class ArrayList implements List {
    public static final int length = 100; //default length
    private IntData[] dataList;
    private int curPosition;
    private int numOfData;

    public ArrayList() {
        this.dataList = new IntData[100];
        curPosition = -1;
        numOfData = 0;
    }

    public ArrayList(int length) {
        this.dataList = new IntData[length];
        curPosition = -1;
        numOfData = 0;
    }

    public ArrayList(IntData[] dataList) {
        this.dataList = dataList;
        curPosition = -1;
        numOfData = 0;
    }

    @Override
    public void insertData(IntData listData) {
        if (numOfData >= dataList.length) {
            System.out.println(
                    String.format("[Warning] exceeded array list size. you can't insert a new element: %d", listData.getData()));
        } else {
            this.dataList[numOfData++] = listData;
        }
    }

    @Override
    public IntData removeData() {
        IntData temp = this.dataList[curPosition];
        for (int i = curPosition; i < numOfData; i++) {
            if (i == numOfData - 1) {
                this.dataList[i] = null;
                numOfData--;
                curPosition--;
                break;
            }
            this.dataList[i] = this.dataList[i + 1];
        }
        return temp;
    }

    @Override
    public int countData() {
        return numOfData;
    }

    @Override
    public boolean listFirst() {
        if (numOfData == 0)
            return false; // can't point index because there's no data in list
        curPosition = 0;
        return true;
    }

    @Override
    public boolean listNext() {
        if (curPosition >= numOfData - 1)
            return false;
        curPosition++;
        return true;
    }

    public void printListStatus() {
        System.out.printf("info of array list: \n" +
                        "\t- max length: %d\n" +
                        "\t- curPosition: %d\n" +
                        "\t- numOfData: %d\n\n"
                , dataList.length, curPosition, numOfData);

    }

    public int getCurPosition() {
        return curPosition;
    }

    public IntData[] getDataList() {
        return dataList;
    }

    public static void main(String[] args) {
        //init arrayList
        ArrayList arrayList = new ArrayList(10);
        arrayList.printListStatus();

        //insert data
        IntData listData;
        for (int i = 0; i < 11; i++) {
            listData = new IntData();
            listData.setData(i);
            arrayList.insertData(listData);

        }
        arrayList.printListStatus();

        //traverse
        if (arrayList.listFirst()) {

            System.out.print("[\t" + arrayList.getDataList()[arrayList.getCurPosition()].getData() + "\t");
            while (arrayList.listNext()) {
                System.out.print(arrayList.getDataList()[arrayList.getCurPosition()].getData() + "\t");
            }
            System.out.print("]");
        }
        System.out.println();

        // remove element which has number 3
        if (arrayList.listFirst()) {
            while (arrayList.listNext()) {
                if (arrayList.getDataList()[arrayList.getCurPosition()].getData() == 3) {
                    IntData removedData = arrayList.removeData();
                    System.out.println(String.format("removed %d", removedData.getData()));
                }
            }
        }
        arrayList.printListStatus();

        //traverse
        if (arrayList.listFirst()) {

            System.out.printf("[\t%d\t", arrayList.getDataList()[arrayList.getCurPosition()].getData());
            while (arrayList.listNext()) {
                System.out.printf("%d\t", arrayList.getDataList()[arrayList.getCurPosition()].getData());
            }
            System.out.print("]");
        }

    }
}