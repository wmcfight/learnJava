package leetcode;

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 vector<vector<int> > generateMatrix(int n) {
        vector<vector<int> > matrix(n,vector<int>(n,0));

        int ldepth = 0, rdepth = n -1, lwidth = 0, rwidth =n-1;
        int direct = 0,x = 0,y=0,cur = 1;
        while(ldepth<=rdepth && lwidth <= rwidth){
            switch(direct){
                case 0:
                    for(int i=lwidth;i<=rwidth;i++){
                        matrix[x][i] = cur++;
                    }
                    ldepth++;

                    y = rwidth;
                    break;
                case 1:
                    for(int i=ldepth;i<=rdepth;i++){
                        matrix[i][y] = cur++;
                    }
                    rwidth--;
                    x = rdepth;

                    break;
                case 2:
                    for(int i=rwidth;i>=lwidth;i--){
                        matrix[x][i] = cur++;
                    }
                    rdepth--;
                    y = lwidth;
                    break;
                case 3:
                    for(int i=rdepth;i>=ldepth;i--){
                        matrix[i][y] = cur++;
                    }
                    lwidth++;
                    x = ldepth;
                    break;
                default:
                    break;
            }

            direct = (direct+1)%4;
        }
        return matrix;
    }
 */
public class SpiralMatrixII {
}
