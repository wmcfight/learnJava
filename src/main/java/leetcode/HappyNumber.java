package leetcode;

import java.util.HashSet;
import java.util.Set;
/**
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number
 by the sum of the squares of its digits, and repeat the process
 until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
/**
 * 不要从数据的角度来解决
 * 用set 做退出
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n < 1) return false;
        Set<Long> usedNum = new HashSet<>();
        long cur = n;
        while(true) {
            long sum = 0;
            while (cur > 0) {
                sum += (cur%10) * (cur%10);
                cur /= 10;
            }

            if (sum == 1) {
                return true;
            }
            if (usedNum.contains(sum)) {
                return false;
            } else {
                usedNum.add(sum);
            }

            cur = sum;
        }
    }
}
