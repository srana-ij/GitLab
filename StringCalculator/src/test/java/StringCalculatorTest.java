import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by sohel rana on 23-9-2021 for skill test
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;


    @BeforeEach
    public void setup()
    {
        stringCalculator = new StringCalculator();
    }


    @Test
    public void emptyStringReturnsZero()
    {
        assertEquals(0, stringCalculator.add(""));
    }


    @Test
    public void stringNumberOneReturnsOne()
    {
        assertEquals(1, stringCalculator.add("1"));
    }


    @Test
    public void stringNumberTwoReturnsTwo()
    {
        assertEquals(2, stringCalculator.add("2"));
    }


    @Test
    public void stringWithoutValidNumberShouldThrowIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("a");
        });
    }


    @Test
    public void stringWithTwoNumbersSeparatedByACommaReturnsSum()
    {
        assertEquals(3, stringCalculator.add("1,2"));
    }


    @Test
    public void stringWithTwoNumbersSeparatedByADifferentSeparatorThrowsIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("1;2");
        });
    }


    @Test
    public void stringWithThreeNumbersSeparatedByACommaReturnsSum()
    {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }


    @Test
    public void stringWithThreeNumbersAndTwoSeparatorsReturnsSum()
    {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }


    @Test
    public void stringWithOneNumberAndTwoSeparatorsThrowsIllegalArgumentException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("1,\n");
        });
    }


    @Test
    public void stringWithTwoNumbersAndSemicolonACustomDelimiterReturnsSum()
    {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }


    @Test
    public void stringWithThreeNumbersAndExclamationMarkAsCustomDelimiterReturnsSum()
    {
        assertEquals(6, stringCalculator.add("//!\n1!2!3"));
    }


    @Test
    public void stringWithThreeNumbersAndDollarSignAndNewLineAsCustomDelimiterReturnsSum()
    {
        assertEquals(6, stringCalculator.add("//$\n1$2\n3"));
    }


    @Test
    public void stringNumberNegativeTwoReturnsThrowsIlllegalArgumentExceptionContainingWrongNumber()
    {
        try {
            stringCalculator.add("-2");
            fail();
        }
        catch(IllegalArgumentException e)
        {
            assertTrue(e.getMessage().contains("negatives not allowed"));
            assertTrue(e.getMessage().contains("-2"));
        }
    }


    @Test
    public void stringNumberTwoNegativesReturnsThrowsIlllegalArgumentExceptionContainingWrongNumbers()
    {
        try {
            stringCalculator.add("-2,-3");
            fail();
        }
        catch(IllegalArgumentException e)
        {
            assertTrue(e.getMessage().contains("negatives not allowed"));
            assertTrue(e.getMessage().contains("-2"));
            assertTrue(e.getMessage().contains("-3"));
        }
    }


}
