package leetcode;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

int minPathSum(vector<vector<int> > &grid) {
        if(grid.size()<=0 || grid[0].size()<=0) return 0;
        int depth = grid.size() , width = grid[0].size();
        vector<int> con(width+1,0);
        for(int i=1;i<=width;i++){
            con[i] = con[i-1] + grid[0][i-1];
        }
        con[0] = INT_MAX;
        for(int i=1;i<depth;i++){
            for(int j=1;j<=width;j++){
                con[j]  = min(con[j-1],con[j]) + grid[i][j-1];
            }
        }

        return con[width];


    }


 */
public class MinimumPathSum {
}
