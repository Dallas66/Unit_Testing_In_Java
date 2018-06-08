package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class UtilsTest {

    private Utils utils = new Utils();
    private String a,b,c;

    @Before
    public void init(){
        a = null;
        b = "abc";
        c = "абв";
    }

    @After
    public void destr(){
        b = null;
        c = null;
    }


    @Test
    public void concatenateWords() {
        assertEquals("abc + абв = abcабв","abcабв",utils.concatenateWords(b,c));
    }

    @Test
    public void concatenateWordsWithOneNull() {
        assertEquals("Must be abc","abc",utils.concatenateWords(b,a));
    }

    @Test
    public void emptyString(){
        assertEquals("String must be empty","",utils.concatenateWords("",""));
    }

    @Test
    public void nullsString(){
        assertNull(utils.concatenateWords(null, null));
    }

    @Test
    public void containsNonLatin(){
        assertFalse(utils.concatenateWords(c,b).matches(("^[a-zA-Z ]+$")));
        assertTrue(utils.concatenateWords(b,b).matches(("^[a-zA-Z ]+$")));
    }


    @Test
    public void computeFactorial() {
        assertEquals("6 is factorial of 3",6,utils.computeFactorial(3));
        assertEquals("39916800 is factorial of 11",39916800,utils.computeFactorial(11));
        assertEquals("720 is factorial of 6",720,utils.computeFactorial(6));
    }


    @Test(timeout = 1)
    public void computeFactorialWithTimeOut(){
       utils.computeFactorial(30);
    }


}