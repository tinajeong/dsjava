package migu.algorithm.study.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort(new int[]{6, 2, 4, 1, 3, 7, 5, 8});
        mergeSort.mergeSort();
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, mergeSort.getUnsortedList());
    }
}
