package leetcode;

/**
 * test case:
 * "aaa111"
 * "ABABABABABABABABABAB1"
 * "aaa123"
 *
 * 边界条件太多了， NND
 * http://www.cnblogs.com/grandyang/p/5988792.html
 * TODO
 */
public class StrongPasswordChecker {
    private static final int MAX_LEN = 20;
    private static final int MIN_LEN = 6;
    private static int isUpper = 1, isLower = 1, isDight = 1;
    public int strongPasswordChecker(String s) {
        isUpper = 1; isLower = 1; isDight = 1;
        if (s == null) return MIN_LEN;
        if (s.length() <= 1) return MIN_LEN - s.length();
        int[] operationNum = new int[3];
        if (s.length() < MIN_LEN) operationNum[0] += MIN_LEN - s.length();
        if (s.length() > MAX_LEN) operationNum[1] += s.length() - MAX_LEN;
        int addNum = operationNum[0];
        int delNum = operationNum[1];
        int curLen = 1;
        for (int i = 0; i < s.length(); i++) {
            check(s, i);
            if (i != 0) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    curLen++;
                } else {
                    fixRepated(operationNum, curLen);
                    curLen = 1;
                }
            }
        }

        //KEY POINT
        fixRepated(operationNum, curLen);
        int eNum = 0;
        eNum = isDight + isLower + isUpper;
        int result = 0;
        result = Math.max(operationNum[2] + addNum, eNum);
        result += delNum;
        return result;
    }

    private void fixRepated(int[] operationNum, int curLen) {
        while(operationNum[1] > 0) {
            if (curLen / 3 > 0 && curLen % 3 != 2) {
                operationNum[1]--;
                curLen--;
                System.out.println("Del number");
            } else {
                break;
            }
        }
        while(operationNum[0] > 0) {
            if (curLen / 3 > 0 && curLen % 3 != 2) {
                operationNum[0]--;
                curLen--;
                System.out.println("Add number");
            } else {
                break;
            }
        }
        operationNum[2] += curLen/3;
    }

    private void check(String s, int cur) {
        if (s.charAt(cur) >= '0' && s.charAt(cur) <= '9') isDight = 0;
        if (s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z') isLower = 0;
        if (s.charAt(cur) >= 'A' && s.charAt(cur) <= 'Z') isUpper = 0;
    }

    public static void main(String[] args) {
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
        System.out.println(strongPasswordChecker.strongPasswordChecker("..."));
    }
}
