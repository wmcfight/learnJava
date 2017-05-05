package leetcode;

/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
int minDistance(string word1, string word2) {
        //if(word1.size() <= 0) return word2.size();
        //if(word2.size() <= 0) return word1.size();
        int len1 = word1.size(),len2 = word2.size();
        vector<vector<int> > con = vector<vector<int> >(len1+1 ,vector<int>(len2+1, 0));

        for(int i=0;i<=len1;i++){
            con[i][0] = i;
        }
        for(int i=0;i<=len2;i++){
            con[0][i] = i;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1[i-1] == word2[j-1]){
                    con[i][j] = con[i-1][j-1];
                }else{
                    con[i][j] = min(con[i-1][j-1],min(con[i][j-1] , con[i-1][j])) +1;
                }
            }
        }

        return con[len1][len2];
    }

 */
public class EditDistance {

}
