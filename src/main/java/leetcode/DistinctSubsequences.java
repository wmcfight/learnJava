package leetcode;

/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

int numDistinct(string S, string T) {

        if(T.size() <=0 || S.size()<=0 || T.size()>S.size()) return 0;
        vector<vector<int> > con(S.size(),vector<int>(T.size(),0));
        int temp = 0;
        for(int i=0;i<S.size();i++){
            if(S[i] == T[0]){
                con[i][0] = ++temp;
            }else{
            	con[i][0] = temp;
            }
        }

        for(int i=1;i<T.size();i++){
            for(int j=i;j<S.size();j++){
                if(T[i] == S[j]){
                   con[j][i] = con[j-1][i-1]+con[j-1][i];
                }else{
                   con[j][i] = con[j-1][i];
                }
            }
        }

        return con[S.size()-1][T.size()-1];
      }
 */
public class DistinctSubsequences {
}
