package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
A password is considered strong if below conditions are all met:

It has at least 6 characters and at most 20 characters.
It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.
 */
/**
 * test case:
 * "aaa111"
 * "ABABABABABABABABABAB1"
 * "1234567890123456Baaaaa"
 * "1010101010aaaB10101010"
 * "aaaaaaaaaaaaaaaaaaaaa"
 * "1Abababcaaaabababababa"
 * "aaaabbaaabbaaa123456A"
 * "aaaaaa1234567890123Ubefg"
 * "AAAAAABBBBBB123456789a"
 * "aaa123"
 *
 * 边界条件太多了， NND
 * http://www.cnblogs.com/grandyang/p/5988792.html
 * http://bookshadow.com/weblog/2016/10/21/leetcode-strong-password-checker/
 *
 * 做到吐血！！！！！
 */
public class StrongPasswordChecker {
    private static final int MAX_LEN = 20;
    private static final int MIN_LEN = 6;
    private static int isUpper = 1, isLower = 1, isDight = 1;
    public int strongPasswordChecker(String s) {
        List<Integer> repeated = new ArrayList<>();
        isUpper = 1; isLower = 1; isDight = 1;
        if (s == null) return MIN_LEN;
        if (s.length() <= 1) return MIN_LEN - s.length();
        int[] operationNum = new int[4];
        // 0 add 1 add operation 2 delete operation 3 delete
        if (s.length() < MIN_LEN) operationNum[0] += MIN_LEN - s.length();
        if (s.length() > MAX_LEN) operationNum[3] += s.length() - MAX_LEN;
        int curLen = 1;
        for (int i = 0; i < s.length(); i++) {
            check(s, i);
            if (i != 0) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    curLen++;
                } else {
                    if (curLen >= 3) {
                        repeated.add(curLen);
                    }
                    curLen = 1;
                }
            }
        }

        //KEY POINT
        if (curLen >= 3) {
            repeated.add(curLen);
        }
        fixRepated(operationNum, repeated);
        int eNum = 0;
        eNum = isDight + isLower + isUpper;
        int result = 0;
        result = Math.max(operationNum[0] + operationNum[1], eNum);
        result += operationNum[2] + operationNum[3];
        return result;
    }

    private void fixRepated(int[] operationNum, List<Integer> list) {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()%3 >= o2.intValue()%3 ? 1 : -1;
            }
        });
        while (operationNum[3] > 0) {
            boolean find = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= 3) {
                    find = true;
                    int delOps = Math.min(list.get(i) % 3 + 1, operationNum[3]);
                    list.set(i, list.get(i) - delOps);
                    operationNum[3] -= delOps;
                    operationNum[2] += delOps;
                }
            }
            if (!find) {
                break;
            }
        }

        int realOps = 0;
        for (int i = 0; i < list.size(); i++) {
            int addOps = list.get(i) / 3 ;
            realOps += addOps;
        }
        operationNum[1] = Math.max(operationNum[0], realOps);
        operationNum[0] = Math.max(0, operationNum[0] - operationNum[1]);
    }

    private void check(String s, int cur) {
        if (s.charAt(cur) >= '0' && s.charAt(cur) <= '9') isDight = 0;
        if (s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z') isLower = 0;
        if (s.charAt(cur) >= 'A' && s.charAt(cur) <= 'Z') isUpper = 0;
    }

    public static void main(String[] args) {
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
//        System.out.println(strongPasswordChecker.strongPasswordChecker("1010101010aaaB10101010"));
//        System.out.println(strongPasswordChecker.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println("3 " +strongPasswordChecker.strongPasswordChecker("..."));
//        System.out.println("1 " +strongPasswordChecker.strongPasswordChecker("aaa123"));
//        System.out.println("2 " +strongPasswordChecker.strongPasswordChecker("aaa111"));
//        System.out.println("3 " +strongPasswordChecker.strongPasswordChecker("aA1"));
        System.out.println("3 " +strongPasswordChecker.strongPasswordChecker("aaaabaaaaaa123456789F"));
//        System.out.println(strongPasswordChecker.strongPasswordChecker("1234567890123456Baaaaa"));
//        System.out.println(strongPasswordChecker.strongPasswordChecker("ABABABABABABABABABAB1"));
//        System.out.println("2 " + strongPasswordChecker.strongPasswordChecker("1Abababcaaaabababababa"));
//        System.out.println("3 " + strongPasswordChecker.strongPasswordChecker("aaaabbaaabbaaa123456A"));
//        System.out.println("4 " + strongPasswordChecker.strongPasswordChecker("aaaaaa1234567890123Ubefg"));
//        System.out.println("4 " + strongPasswordChecker.strongPasswordChecker("AAAAAABBBBBB123456789a"));
    }
}
