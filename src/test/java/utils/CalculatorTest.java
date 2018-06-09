package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private static final String ADDITION_EXPRESSION = "1 + 1";
    private static final String SUBTRACTION_EXPRESSION = "5 - 2";
    private static final String MULTIPLICATION_EXPRESSION = "5 * 2";
    private static final String DIVISION_EXPRESSION = "6 / 3";
    private static final String INFINITY_EXPRESSION = "1 / 0";
    private static final String EXCESS_SIGN_EXPRESSION = "6 / / 3";
    private static final String EMPTY_EXPRESSION = "";
    private static final double DELTA = 1e-15;

    @Test
    public void calculateAddition() {
        assertEquals(2.0, calculator.calculate(ADDITION_EXPRESSION), DELTA);
    }

    @Test
    public void calculateSubtraction() {
        assertThat(calculator.calculate(SUBTRACTION_EXPRESSION), is(equalTo(3.0)));

    }

    @Test
    public void calculateMultiplication() {
        assertThat(calculator.calculate(MULTIPLICATION_EXPRESSION), is(equalTo(10.0)));

    }

    @Test
    public void calculateDivision() {
        assertThat(calculator.calculate(DIVISION_EXPRESSION), is(equalTo(2.0)));

    }

    @Test
    public void calculateInfinity() {
        assertThat((Double.isInfinite(calculator.calculate(INFINITY_EXPRESSION))), is(equalTo(true)));

    }

    @Test
    public void calculateExcessSign() {
        assertThat(calculator.calculate(EXCESS_SIGN_EXPRESSION), is(equalTo(0.0)));
    }

    @Test
    public void calculateEmptyExpression() {
        assertThat(calculator.calculate(EMPTY_EXPRESSION), is(equalTo(0.0)));
    }
}