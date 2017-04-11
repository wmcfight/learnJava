package leetcode;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length<=0 || matrix[0].length<=0) return;
        int width = matrix.length;
        int len = matrix[0].length;

        boolean rflag1 = false, rflag2= false;

        for(int i=0;i<width;i++){
            if(matrix[i][0] == 0){
                rflag1 = true;
                break;
            }
        }

        for(int i=0;i<len;i++){
            if(matrix[0][i] == 0){
                rflag2 = true;
                break;
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < len; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < width; i++) {
            for (int j = 1; j < len; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rflag1){
            for(int i=0;i<width;i++){
                matrix[i][0] = 0;
            }
        }

        if(rflag2){
            for(int i=0;i<len;i++){
                matrix[0][i] = 0;
            }
        }
    }
}
