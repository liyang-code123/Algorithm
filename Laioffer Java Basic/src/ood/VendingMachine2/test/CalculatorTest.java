package ood.VendingMachine2.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator test1 = new Calculator();

    @Test
    public void add_succeed() {
        int res = test1.add(1, 3);

        assertEquals(4, res);
    }

    @Test
    public void add_failed() {
        int res = test1.add(1, 3);

        assertNotEquals(5, res);
    }

    @Test
    public void deduct_succeed() {
        int res = test1.deduct(1, 3);

        assertEquals(-2, res);
    }

    @Test
    public void deduct_failed() {
        int res = test1.deduct(1, 3);

        assertNotEquals(-3, res);
    }
}