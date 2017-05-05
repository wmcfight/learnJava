package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

bool wordBreak(string s, unordered_set<string> &dict) {
        vector<bool> con(s.size()+1,false);
        con[0] = true;
        for(int i=1;i<=s.size();i++){
            for(int j=i-1;j>=0;j--){
                if(con[j] && dict.find(s.substr(j,i-j)) != dict.end()){
                    con[i] = true;
                    break;
                }
            }
        }

        return con[s.size()];
    }
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cons = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Arrays.fill(cons, false);
        cons[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j>=0; j--) {

                if (cons[j] && wordDictSet.contains(s.substring(j, i))) {
                    cons[i] = true;
                    break;
                }
            }
        }
        return cons[s.length()];
    }

    public static void main(String[] args) {
        WordBreak sample = new WordBreak();
        System.out.println(sample.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
