package leetcode;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

int numDecodings(string s) {
        if(s.size()<=0) return 0;
        int cur = 1,prev = 0;
        for(int i=1;i<=s.size();i++){
            if(s[i-1] == '0') cur = 0;
            if(i<2 || !(s[i-2] == '1' || (s[i-2] == '2' && s[i-1] <= '6') ))
                prev = 0;
            int temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }
 */
public class DecodeWays {
}
