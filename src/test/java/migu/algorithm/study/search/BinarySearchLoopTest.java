package migu.algorithm.study.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchLoopTest {


    @Test
    public void binarySearch() {
        BinarySearchLoop binarySearchLoop = new BinarySearchLoop(new int[]{1,3,5,7,9,10,15});
        Assert.assertEquals(true, binarySearchLoop.binarySearch(10));

        int[] sample = new int[50000];
        binarySearchLoop.setArr(sample);
        Assert.assertEquals(false, binarySearchLoop.binarySearch(1));
    }
}
