package migu.algorithm.study.stack;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testOneParenthesis()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(27,calculator.calculateInfix("(1+2*4)*3"));
    }

    @Test
    public void testTwoParenthesis()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(63,calculator.calculateInfix("(1+6*4-(2*2))*3"));
    }
    @Test
    public void testThreeParenthesis()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(6,calculator.calculateInfix("((1-2)+3)*(5-2)"));
    }
}