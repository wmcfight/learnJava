package leetcode;

/**
You are a product manager and currently leading a team to develop a new product. Unfortunately,
the latest version of your product fails the quality check.
Since each version is developed based on the previous version,
 all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version.
 You should minimize the number of calls to the API.
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n <= 1) return n;
        int begin = 1, end = n;
        while (begin < end) {
            int version = begin + (end - begin) / 2;
            if (isBadVersion(version)) {
                end = version;
            } else {
                begin = version + 1;
            }
        }
        return end;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
