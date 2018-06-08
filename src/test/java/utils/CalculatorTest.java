package utils;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private static String ADDITION_EXPRESSION = "-1 + 1";
    private static String SUBTRACTION_EXPRESSION = "5 - 2";
    private static String MULTIPLICATION_EXPRESSION = "5 * 2";
    private static String DIVISION_EXPRESSION = "6 / 3";
    private static String INFINITY_EXPRESSION = "1 / 0";
    private static String EXSCESS_SIGN_EXPRESSION = "6 / / 3";
    private static String EMPTY_EXPRESSION = "";
    private static final double DELTA = 1e-15;

    @Test
    public void calculateAddition() {
        assertEquals(0.0,calculator.calculate(ADDITION_EXPRESSION),DELTA);
    }

    @Test
    public void calculateSubtraction() {
        assertEquals(3.0,calculator.calculate(SUBTRACTION_EXPRESSION),DELTA);
    }

    @Test
    public void calculateMultiplication() {
        assertEquals(10.0,calculator.calculate(MULTIPLICATION_EXPRESSION),DELTA);
    }

    @Test
    public void calculateDivision() {
        assertEquals(2.0,calculator.calculate(DIVISION_EXPRESSION),DELTA);
    }

    @Test
    public void calculateInfinity(){
        assertTrue(Double.isInfinite(calculator.calculate(INFINITY_EXPRESSION)));
    }

    @Test
    public void calculateExcessSign(){
        assertEquals(0.0,calculator.calculate(EXSCESS_SIGN_EXPRESSION),DELTA);
    }

    @Test
    public void calculateEmptyExpression(){
        assertEquals(0.0,calculator.calculate(EMPTY_EXPRESSION),DELTA);
    }
}