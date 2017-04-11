package leetcode;

/*
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        if(obstacleGrid.size() <=0 || obstacleGrid[0].size() <= 0 )return 0;
        int depth = obstacleGrid.size(),width = obstacleGrid[0].size();
        con = vector<vector<int> >(depth+1,vector<int>(width+1,0));

        return dfs(depth,width,obstacleGrid);
    }

    int dfs(int m,int n,vector<vector<int> > &obstacleGrid){


        if(m < 1 || n < 1) return 0;
        if(con[m][n] > 0) return con[m][n];
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        if(m == 1 && n == 1) return 1;
        con[m-1][n] = dfs(m-1,n,obstacleGrid);
        con[m][n-1] = dfs(m,n-1,obstacleGrid);
        return con[m-1][n] + con[m][n-1];
    }

 private:
    vector<vector<int> > con;
 */
public class UniquePathsII {
}
