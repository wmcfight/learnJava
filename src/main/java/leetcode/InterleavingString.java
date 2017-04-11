package leetcode;

/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


bool isInterleave(string s1, string s2, string s3) {
        if(s3.size() != s1.size() + s2.size()){
            return false;
        }

        int len1 = s1.size(), len2 = s2.size();
        vector<vector<bool> > con = vector<vector<bool> >(len1+1, vector<bool>(len2+1,true));

        for(int i = 1 ;i<=len1;i++){
            con[i][0] = s1[i-1] == s3[i-1] && con[i-1][0];
        }

        for(int j = 1 ;j<=len2;j++){
            con[0][j] = s2[j-1] == s3[j-1] && con[0][j-1];
        }

        for(int i = 1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                con[i][j] = (s1[i-1] == s3[i-1+j] && con[i-1][j])
                         || (s2[j-1] == s3[i+j-1] && con[i][j-1]);
            }
        }

        return con[len1][len2];

    }
 */
public class InterleavingString {
}
