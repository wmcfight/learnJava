package leetcode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems


 int minCut(string s) {
        vector<vector<bool> > bcon(s.size(),vector<bool>(s.size(),false));
        vector<int> dcon(s.size()+1,0);
        for(int i=0;i<=s.size();i++){
            dcon[i] = s.size()-i-1;
        }

        if(s.size()<=0) return 0;

        for(int i=s.size()-1;i>=0;i--){
            for(int j=i;j<s.size();j++){
                if(s[i] == s[j] && (j-i<2 || bcon[i+1][j-1])){
                    bcon[i][j] = true;
                    dcon[i] = min(dcon[i],dcon[j+1]+1);
                }

            }
        }

        return dcon[0];
    }


 */
public class PalindromePartitioning2 {
}
