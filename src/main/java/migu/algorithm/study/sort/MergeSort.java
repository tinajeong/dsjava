package migu.algorithm.study.sort;

public class MergeSort {
    private int[] unsortedList;

    public MergeSort() {
    }

    public MergeSort(int[] unsortedList) {
        this.unsortedList = unsortedList;
    }

    public void mergeSort() {
        mergeSort(0, unsortedList.length - 1);
    }

    private void mergeSort(int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            mergeSort(s, m);
            mergeSort(m + 1, e);
            merge(s, m, e);
        }
    }

    private void merge(int s, int m, int e) {
        int[] tempArray = new int[e+1];
        int ss = s;
        int mm = m + 1;
        int temp = s;

        while (ss <= m && mm <= e) {
            if (unsortedList[ss] < unsortedList[mm]) {
                tempArray[temp++] = unsortedList[ss];
                ss++;
            } else {
                tempArray[temp++] = unsortedList[mm];
                mm++;
            }
        }

        while (ss <= m) {
            tempArray[temp++] = unsortedList[ss];
            ss++;
        }

        while (mm <= e) {
            tempArray[temp++] = unsortedList[mm];
            mm++;
        }

        if (e + 1 - s >= 0) {
            System.arraycopy(tempArray, s, unsortedList, s, e + 1 - s);
        }
    }


    private void printArray() {
        try {
            for (int value : unsortedList) {
                System.out.print(value + "\t");
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
