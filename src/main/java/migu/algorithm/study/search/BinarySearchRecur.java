package migu.algorithm.study.search;

public class BinarySearchRecur {
    private int[] arr;

    public BinarySearchRecur() {
    }

    public BinarySearchRecur(int[] arr) {
        this.arr = arr;
    }

    public boolean binarySearchRecur(int target) {
        if (binarySearchRecur(0, arr.length - 1, target) == target)
            return true;
        else
            return false;
    }

    private int binarySearchRecur(int first, int last, int target) {
        int mid = (first + last) / 2;
        if (first > last)
            return -1;

        if (arr[mid] == target)
            return arr[mid];
        else {
            if (arr[mid] > target)
                return binarySearchRecur(first, mid - 1, target);
            else
                return binarySearchRecur(mid + 1, last, target);
        }
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
