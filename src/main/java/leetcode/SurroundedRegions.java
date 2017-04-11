package leetcode;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X


void solve(vector<vector<char>> &board) {
        if(board.size() == 0 || board[0].size() == 0) return;
        int depth = board.size(),width = board[0].size();
        for(int i=0;i<depth;i++){
            dfs(board,i,0);
            dfs(board,i,width-1);
        }

        for(int j=0;j<width;++j){
            dfs(board,0,j);
            dfs(board,depth-1,j);
        }

        for(int i=0;i<depth;i++){
            for(int j=0;j<width;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '+'){
                    board[i][j] = 'O';
                }
            }
        }
    }

 private:
    void dfs(vector<vector<char>>&board ,int x, int y){
        if(x < 0 || x >= board.size() || y < 0 || y>=board[0].size() || board[x][y] != 'O'){
            return;
        }
        board[x][y] = '+';
        dfs(board,x-1,y);
        dfs(board,x+1,y);
        dfs(board,x,y-1);
        dfs(board,x,y+1);
    }

 */
public class SurroundedRegions {
}
