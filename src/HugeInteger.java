import java.util.Arrays;

public class HugeInteger {
    private int[] digits = new int[40];

    public void parse(String input) {
        digits = new int[40];
        int startPosition = 40 - input.length();
        for (int index = 0; index < input.length(); index++) {
            char digitCharacter = input.charAt(index);
            int digit = digitCharacter - '0';
            digits[startPosition + index] = digit;
        }

    }

    @Override
    public String toString() {
        String result = "";
        for (int digit : digits) {
                result += digit;
        }
        return result;
    }

    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int carry = 0;
        for (int index = 39; index >= 0; index--) {
            int sum = digits[index] + other.digits[index] + carry;
            result.digits[index] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    public HugeInteger subtract(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int borrow = 0;
        for (int index = 39; index >= 0; index--) {
            int difference = digits[index] - other.digits[index] - borrow;
            if (difference < 0) {
                difference += 10; borrow = 1;
            } else {
                borrow = 0;
            } result.digits[index] = difference;
        } return result;
    }

    public boolean isEqualTo(HugeInteger other) {
        for (int index = 0; index < 40; index++) {
            if (digits[index] != other.digits[index]) {
                return false;
            }
        }
        return true;
    }

    public boolean isLessThan(HugeInteger other) {
        for (int index = 0; index < 40; index++) {
            if (digits[index] < other.digits[index]) {
                return true;
            } if (digits[index] > other.digits[index]) {
                return false;
            }
        } return false;
    }

    public boolean isGreaterThan(HugeInteger other) {
        for (int index = 0; index < 40; index++) {
            if (digits[index] > other.digits[index]) {
                return true;
            } if (digits[index] < other.digits[index]) {
                return false;
            }
        }
        return false;
    }

    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();
        number1.parse("123456789012345678901234567890");
        number2.parse("987654321");

        HugeInteger sum = number1.add(number2);
        System.out.print(sum);
    }

}