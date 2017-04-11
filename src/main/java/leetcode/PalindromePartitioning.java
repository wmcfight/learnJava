package leetcode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

public:
    vector<vector<string>> partition(string s) {
        int len = s.size();
        vector<vector<string> > result;
        if(len<=0) return result;
        vector<vector<bool> > con(len,vector<bool>(len,false));

        for(int i=0;i<len;i++){
            for(int j=i;j>=0;j--){
                if(s[j] == s[i] && (i-j<2 || con[j+1][i-1])){
                    con[j][i] = true;
                }
            }
        }

        vector<string> data;
        getSubstr(s,con,data,0,result);
        return result;
    }

    void getSubstr(string&s, vector<vector<bool>>&con, vector<string>& data, int cur, vector<vector<string>>&result){
        if(cur>=s.size()){
            result.push_back(data);
            return;
        }

        for(int i=0;i<s.size();i++){
            if(con[cur][i]){
                data.push_back(s.substr(cur,i-cur+1));
                getSubstr(s,con,data,i+1,result);
                data.pop_back();
            }
        }
    }

 */
public class PalindromePartitioning {
}
