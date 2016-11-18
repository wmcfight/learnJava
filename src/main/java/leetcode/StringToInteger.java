package leetcode;

/**
 * testcase:
 * "9223372036854775809": 2147483647
 * "-10000a42": -10000
 * "+-2" : 0
 */
public class StringToInteger {
    public int myAtoi(String str) {
        double result = 0;
        if (str == null || str.length() <= 0) return (int)result;
        str = str.trim();
        double flag = 1;
        int cur = 0;
        if (str.charAt(cur) == '+') {
            cur++;
        } else if (str.charAt(cur) == '-') {
            cur++;
            flag = flag * -1;
        }

        for (int i = cur; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar >= '0' && curChar <= '9') {
                result = result * 10 + (curChar - '0');
            } else {
                break;
            }

        }

        result = result * flag;

        if (result >= Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("9223372036854775809"));
    }
}
