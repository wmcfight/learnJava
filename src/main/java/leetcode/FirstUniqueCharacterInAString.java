package leetcode;


import java.util.Arrays;
/*
Given a string, find the first non-repeating character in it and return it's index.
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

 */

/**
 * 学会用Arrays.fill方法
 * Arrays.sort
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] target = new int[256];
        Arrays.fill(target, -1);
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            if (target[cur] == -1) {
                target[cur] = i;
            } else if (target[cur] >= 0) {
                target[cur] = -2;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < target.length; i++) {
            if (target[i] >= 0) {
                result = Math.min(result, target[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
