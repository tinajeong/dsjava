package migu.algorithm.study.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchRecurTest {


    @Test
    public void binarySearchRecur() {
        BinarySearchRecur binarySearchRecur = new BinarySearchRecur(new int[]{1,2,5,7,8,10,14,15,16});
        Assert.assertEquals(true,binarySearchRecur.binarySearchRecur(5));
    }
}
