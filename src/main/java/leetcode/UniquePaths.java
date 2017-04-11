package leetcode;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

public:
    int uniquePaths(int m, int n) {
        con = vector<vector<int> >(m+1,vector<int>(n+1,0));

        return dfs(m,n);

    }

    int dfs(int m,int n){

        if(m < 1 || n < 1) return 0;
        if(m == 1 && n == 1) return 1;
        if(con[m][n] > 0) return con[m][n];
        con[m-1][n] = dfs(m-1,n);
        con[m][n-1] = dfs(m,n-1);
        return con[m-1][n] + con[m][n-1];
        //return dfs(m-1,n) + dfs(m,n-1);
    }

    private:
    vector<vector<int> > con;

 */
public class UniquePaths {
}
