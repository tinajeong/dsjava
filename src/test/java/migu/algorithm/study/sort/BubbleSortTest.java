package migu.algorithm.study.sort;

import migu.algorithm.study.sort.BubbleSort;
import org.junit.Test;

import org.junit.Assert;

public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setUnsortedList(new int[]{1, 4, 3, 2, 5, 7, 6});
        Assert.assertArrayEquals("Result", new int[]{1, 2, 3, 4, 5, 6, 7}, bubbleSort.bubbleSort());
        bubbleSort.setUnsortedList(new int[]{4, 3, 2, 1, 7, 8, 6, 5, 9});
        Assert.assertArrayEquals("Result", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, bubbleSort.bubbleSort());
    }
}
