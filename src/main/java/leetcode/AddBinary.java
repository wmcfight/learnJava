package leetcode;

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) return a == null ? b : a;
        StringBuffer stringBuffer = new StringBuffer();
        a = reverseStr(a);
        b = reverseStr(b);
        int locA = 0, locB = 0;
        int addNumber = 0 ,curA =0, curB = 0;
        while (locA < a.length() || locB < b.length()) {
            curA = locA < a.length() ? a.charAt(locA) - '0' : 0;
            curB = locB < b.length() ? b.charAt(locB) - '0' : 0;
            locA = locA < a.length() ? locA+1 : locA;
            locB = locB < b.length() ? locB+1 : locB;
            stringBuffer.append((curA + curB + addNumber) % 2);
            addNumber = (curA + curB + addNumber) / 2;
        }

        if (addNumber > 0) {
            stringBuffer.append(addNumber);
        }
        return reverseStr(stringBuffer.toString());
    }

    private String reverseStr(String src) {
        StringBuffer stringBuffer = new StringBuffer(src);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
