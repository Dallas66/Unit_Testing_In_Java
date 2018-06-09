package utils;

import org.junit.*;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class UtilsTest {

    private Utils utils = new Utils();
    private String a, b, c;

    @Before
    public void init() {
        a = null;
        b = "abc";
        c = "абв";
    }

    @After
    public void destr() {
        b = null;
        c = null;
    }


    @Test
    public void testConcatenateWords() {
        assertEquals("abc + абв = abcабв", "abcабв", utils.concatenateWords(b, c));
    }

    @Test
    public void testConcatenateWordsWithOneNull() {
        assertEquals("Must be abc", "abc", utils.concatenateWords(b, a));
    }

    @Test
    public void testEmptyString() {
        assertEquals("String must be empty", "", utils.concatenateWords("", ""));
    }

    @Test
    public void testNullsString() {
        assertNull(utils.concatenateWords(null, null));
    }

    @Test
    public void testContainsNonLatin() {
        assertFalse(utils.concatenateWords(c, b).matches(("^[a-zA-Z ]+$")));
        assertTrue(utils.concatenateWords(b, b).matches(("^[a-zA-Z ]+$")));
    }


    @Test
    public void testComputeFactorial() {
        assertEquals("factorial(3) = 6", 6, utils.computeFactorial(3));
        assertEquals("factorial(11) = 39916800", 39916800, utils.computeFactorial(11));
        assertEquals("factorial(6) = 720", 720, utils.computeFactorial(6));
    }


    // n = 12345678, 100% timeout
    @Test(timeout = 1)
    @Ignore
    public void testComputeFactorialWithTimeOut() {
        int n = (int) (Math.random() * 10000);
        utils.computeFactorial(n);
    }


}