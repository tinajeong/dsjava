package migu.algorithm.study.sort;

import migu.algorithm.study.sort.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void testSelectionSort() {
        InsertionSort insertionSort = new InsertionSort(new int[]{1,4,3,2});
        Assert.assertArrayEquals(new int[]{1,2,3,4},insertionSort.insertionSort());

        insertionSort.setUnsortedList(new int[]{4,2,5,1,7,6,3});
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7},insertionSort.insertionSort());
    }
}
