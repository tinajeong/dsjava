package migu.algorithm.study.search;

import migu.algorithm.study.util.PrintArray;

public class BinarySearchLoop {
    int[] arr;

    public BinarySearchLoop() {
    }

    public BinarySearchLoop(int[] arr) {
        this.arr = arr;
    }

    public boolean binarySearch(int target) {
        new PrintArray().printArray(arr);
        int first = 0;
        int last = arr.length - 1;
        int cnt = 0;
        while (first <= last) {
            int mid = (first + last) / 2;
            cnt++;
            if (arr[mid] > target) {
                last = mid - 1;
            } else if (arr[mid] < target) {
                first = mid + 1;
            } else {
                return true;
            }
        }
        System.out.println(cnt);
        return false;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
