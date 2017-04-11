package leetcode;

/*
Determine if a Sudoku is valid, according

bool isValidSudoku(vector<vector<char> > &board) {
        if(board.size() !=9 || board[0].size() != 9) return false;
        set<char> dset;
        for(int i=0;i<board.size();i++){
            dset.clear();
            for(int j=0;j!=board[i].size();j++){
                if(board[i][j] != '.' && dset.find(board[i][j]) != dset.end())
                    return false;
                dset.insert(board[i][j]);
            }
        }

        for(int i=0;i<board[0].size();i++){
            dset.clear();
            for(int j=0;j!=board.size();j++){
                if(board[j][i] != '.' && dset.find(board[j][i]) != dset.end())
                    return false;
                dset.insert(board[j][i]);
            }
        }

        int cx = 0,cy = 0;
        for(int i=0;i<9;i++){
            dset.clear();
            cx = (i/3)*3;
            cy = i%3*3;
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(board[cx+j][cy+k] != '.' && dset.find(board[cx+j][cy+k]) != dset.end())
                    return false;
                    dset.insert(board[cx+j][cy+k]);
                }
            }
        }

        return true;
    }
 */
public class ValidSudoku {
}
