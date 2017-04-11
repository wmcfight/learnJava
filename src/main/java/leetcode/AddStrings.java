package leetcode;

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
/**
 * 注意最后一位的处理
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int tLen = Math.max(num1.length(), num2.length());
        StringBuffer stringBuffer = new StringBuffer();
        String newNum1 = reverse(num1);
        String newNum2 = reverse(num2);
        int flag = 0;
        for (int i = 0; i < tLen; i++) {
            int cur1 = i >= newNum1.length() ? 0 : newNum1.charAt(i) - '0';
            int cur2 = i >= newNum2.length() ? 0 : newNum2.charAt(i) - '0';
            int curSum = cur1 + cur2 + flag;
            stringBuffer.append(curSum%10);
            flag = curSum/10;
        }

        // key point
        if (flag == 1) {
            stringBuffer.append(flag);
        }

        return stringBuffer.reverse().toString();
    }

    private String reverse(String data) {
        return new StringBuffer(data).reverse().toString();
    }
}
