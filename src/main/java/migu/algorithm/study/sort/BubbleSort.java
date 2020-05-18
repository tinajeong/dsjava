package migu.algorithm.study.sort;

public class BubbleSort {
    private int[] unsortedList;
    private int changedCount = 0;

    public BubbleSort() {
    }

    public BubbleSort(int[] unsortedList) {
        this.unsortedList = unsortedList;
    }

    public int[] bubbleSort() {
        printArray();
        for (int i = 0; i < unsortedList.length - 1; i++) {
            for (int j = 0; j < unsortedList.length - 1-i; j++) {
                if (unsortedList[j] > unsortedList[j + 1]) {
                    int temp = unsortedList[j];
                    unsortedList[j] = unsortedList[j + 1];
                    unsortedList[j + 1] = temp;
                    changedCount++;
                }
            }
            if (changedCount == 0)
                break;
            changedCount = 0;
            printArray();
        }
        return unsortedList;
    }

    public void printArray() {
        try {
            for (int i = 0; i < unsortedList.length; i++) {
                System.out.print(unsortedList[i] + "\t");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] getUnsortedList() {
        return unsortedList;
    }

    public void setUnsortedList(int[] unsortedList) {
        this.unsortedList = unsortedList;
    }
}

