package leetcode;

import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        vector<bool> con(s.size()+1,false);
        con[0] = true;
        vector<vector<bool> > tdata(s.size()+1, vector<bool>(s.size()+1,false));
        for(int i=1;i<=s.size();i++){
            for(int j=i-1;j>=0;j--){
                if(con[j] && dict.find(s.substr(j,i-j)) != dict.end()){
                    con[i] = true;
                    tdata[j][i] = true;
                }
            }
        }

        vector<string> result,path;
        if(con[s.size()]){
            getSubString(tdata,s,path,result,s.size());
        }
        return result;
    }

    void getSubString(vector<vector<bool> >&tdata,string&s,vector<string>&vstring,vector<string>&result,int cur){
        if(cur == 0){
            string temp;
            for(int i=vstring.size()-1;i>=0;i--){
                temp += vstring[i]+" ";
            }
            temp.erase(temp.end()-1);
            result.push_back(temp);
            return ;
        }

        for(int i=0;i<cur;i++){
            if(tdata[i][cur]){
                vstring.push_back(s.substr(i,cur-i));
                getSubString(tdata,s,vstring,result,i);
                vstring.pop_back();
            }
        }

    }

 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return null;
    }
}
