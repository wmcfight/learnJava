package leetcode;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.
 */

/**
 * just the answer of numberOf1Bits
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        return hammingWeight(res);
    }

    private int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
