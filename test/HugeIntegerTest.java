import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HugeIntegerTest {

    @Test
    public void testParse() {
        HugeInteger number = new HugeInteger();

        number.parse("12345");

        assertEquals(
                "0000000000000000000000000000000000012345",
                number.toString()
        );
    }

    @Test
    public void testToString() {
        HugeInteger number = new HugeInteger();

        number.parse("12345");

        assertEquals(
                "0000000000000000000000000000000000012345",
                number.toString()
        );
    }

    @Test
    public void testAdd() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12345");
        number2.parse("67890");

        HugeInteger result = number1.add(number2);

        assertEquals(
                "0000000000000000000000000000000000080235",
                result.toString()
        );
    }

    @Test
    public void testAddWithCarry() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("999");
        number2.parse("1");

        HugeInteger result = number1.add(number2);

        assertEquals(
                "0000000000000000000000000000000000001000",
                result.toString()
        );
    }

    @Test
    public void testSubtract() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("67890");
        number2.parse("12345");

        HugeInteger result = number1.subtract(number2);

        assertEquals(
                "0000000000000000000000000000000000055545",
                result.toString()
        );
    }

    @Test
    public void testSubtractWithBorrow() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("1000");
        number2.parse("1");

        HugeInteger result = number1.subtract(number2);

        assertEquals(
                "0000000000000000000000000000000000000999",
                result.toString()
        );
    }

    @Test
    public void testIsEqualTo() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12345");
        number2.parse("12345");

        assertTrue(number1.isEqualTo(number2));
    }

    @Test
    public void testIsNotEqualTo() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12345");
        number2.parse("54321");

        assertFalse(number1.isEqualTo(number2));
    }

    @Test
    public void testIsLessThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12345");
        number2.parse("54321");

        assertTrue(number1.isLessThan(number2));
    }

    @Test
    public void testIsNotLessThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("54321");
        number2.parse("12345");

        assertFalse(number1.isLessThan(number2));
    }

    @Test
    public void testIsGreaterThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("54321");
        number2.parse("12345");

        assertTrue(number1.isGreaterThan(number2));
    }

    @Test
    public void testIsNotGreaterThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12345");
        number2.parse("54321");

        assertFalse(number1.isGreaterThan(number2));
    }

    @Test
    public void testIsZero() {
        HugeInteger number = new HugeInteger();

        assertTrue(number.isZero());
    }

    @Test
    public void testIsNotZero() {
        HugeInteger number = new HugeInteger();

        number.parse("12345");

        assertFalse(number.isZero());
    }
}
