package migu.algorithm.study.sort;

public class InsertionSort {
    int[] unsortedList;
    int sortedListSize = 0;

    public InsertionSort() {
    }

    public InsertionSort(int[] unsortedList) {
        this.unsortedList = unsortedList;
    }

    public int[] insertionSort() {
        int j;
        for (int i = 1; i < unsortedList.length; i++) {
            printArray();
            int curData = unsortedList[i];
            for (j =i-1; j >= 0; j--) {
                if (unsortedList[j] > curData) {
                    unsortedList[j+1] = unsortedList[j];
                    System.out.printf(">\t");
                    printArray();
                }
                else
                    break;
            }

            unsortedList[j+1] = curData;

        }
        printArray();
        return unsortedList;
    }

        public void printArray () {
            try {
                for (int i = 0; i < unsortedList.length; i++) {
                    System.out.printf(unsortedList[i] + "\t");
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int[] getUnsortedList () {
            return unsortedList;
        }

        public void setUnsortedList ( int[] unsortedList){
            this.unsortedList = unsortedList;
        }
    }
