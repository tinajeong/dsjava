package migu.algorithm.study.sort;

public class SelectionSort {
    private int minValue;
    private int minIndex;
    private int[] unsortedList;


    public SelectionSort(int[] unsortedList) {
        this.unsortedList = unsortedList;
    }

    public int[] selectionSort() {
        for (int i = 0; i < unsortedList.length; i++) {
            printArray();
            minValue = unsortedList[i];
            minIndex = i;
            for (int j = i; j < unsortedList.length; j++) {
                if (minValue > unsortedList[j]) {
                    minValue = unsortedList[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                unsortedList[minIndex] = unsortedList[i];
                unsortedList[i] = minValue;
            }
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
