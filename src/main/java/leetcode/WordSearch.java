package leetcode;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.


bool exist(vector<vector<char> > &board, string word) {
        if(board.size()<=0 || board[0].size() <=0) return false;

        int depth = board.size(),width = board[0].size();
        vector<vector<bool> > con = vector<vector<bool> >(depth, vector<bool>(width,false));
        for(int i=0;i!=depth;i++){
            for(int j=0;j!=width;j++){
                if(searchWord(board,word,0,i,j,con)) return true;
            }
        }

        return false;
    }

    bool searchWord(vector<vector<char> > &board,string& word, int cur,int x,int y,vector<vector<bool> >&con){


        if(x<0 || x>board.size()-1 || y<0 || y>board[0].size()-1 || board[x][y] != word[cur] || con[x][y]){
            return false;
        }

        if(cur == word.size() - 1){
            return true;
        }



        con[x][y] = true;
        bool result = searchWord(board,word,cur+1,x-1,y,con) ||
                       searchWord(board,word,cur+1,x+1,y,con) ||
                       searchWord(board,word,cur+1,x,y-1,con) ||
                       searchWord(board,word,cur+1,x,y+1,con);
        con[x][y] = false;
        return result;

    }
 */
public class WordSearch {

}
