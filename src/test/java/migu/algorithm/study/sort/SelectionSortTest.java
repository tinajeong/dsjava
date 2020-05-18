package migu.algorithm.study.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        SelectionSort selectionSort = new SelectionSort(new int[]{1,4,3,2,6,5});
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},selectionSort.selectionSort());
        selectionSort.setUnsortedList(new int[]{4, 3, 2, 1, 7, 8, 6, 5, 9});
        Assert.assertArrayEquals("Result", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, selectionSort.selectionSort());
    }
}
