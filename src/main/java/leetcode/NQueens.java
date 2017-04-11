package leetcode;

/*
 vector<vector<string> > solveNQueens(int n) {

        vector<vector<string> > result;
        vector<string> data = vector<string>(n,string(n,'.'));
        int depth = 0;
        getSubNQueen(depth,n,data,result);
        return result;
    }

    void getSubNQueen(int depth,int n,vector<string>&data,vector<vector<string> >&result){
        if(depth >= n){
            result.push_back(data);
        }

        for(int i=0;i<n;i++){
            if(getCon(i,depth,n)) continue;
            data[depth][i] = 'Q';
            con[depth][i] = 1;
            getSubNQueen(depth+1,n,data,result);
            con[depth][i] = 0;
            data[depth][i] = '.';
        }


    }

    bool getCon(int i,int depth,int n){
        int j = 1;
        while(depth > 0){
            if(con[depth-1][i] == 1 ||
            (i>=j && con[depth-1][i-j] == 1) ||
            (i+j<=n-1 && con[depth-1][i+j] == 1)){
                return true;
            }
            j++;
            depth--;
        }

        return false;
    }
 */
public class NQueens {
}
