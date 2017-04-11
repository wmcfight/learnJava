package leetcode;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int> result;
        if(matrix.size()<=0 || matrix[0].size()<=0) return result;
        int ldepth = 0, rdepth = matrix.size()-1, lwidth = 0, rwidth =matrix[0].size()-1;
        int direct = 0,x = 0,y=0;
        while(ldepth<=rdepth && lwidth <= rwidth){
            switch(direct){
                case 0:
                    for(int i=lwidth;i<=rwidth;i++){
                        result.push_back(matrix[x][i]);
                    }
                    ldepth++;

                    y = rwidth;
                    break;
                case 1:
                    for(int i=ldepth;i<=rdepth;i++){
                        result.push_back(matrix[i][y]);
                    }
                    rwidth--;
                    x = rdepth;

                    break;
                case 2:
                    for(int i=rwidth;i>=lwidth;i--){
                        result.push_back(matrix[x][i]);
                    }
                    rdepth--;
                    y = lwidth;
                    break;
                case 3:
                    for(int i=rdepth;i>=ldepth;i--){
                        result.push_back(matrix[i][y]);
                    }
                    lwidth++;
                    x = ldepth;
                    break;
                default:
                    break;
            }

            direct = (direct+1)%4;
        }
        return result;
    }
 */
public class SpiralMatrix {

}
