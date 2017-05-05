package leetcode;

/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        return leftValue(leftValue(leftValue(num, 2),3),5) == 1;
    }

    private int leftValue(int num, int re) {
        while (num % re ==0) {
            num/=re;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
