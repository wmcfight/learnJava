package leetcode;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // for diagonal line rotate
        for(int i = 0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }

        //for horizontal line rotate
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-i][j];
                matrix[len-1-i][j] = temp;
            }
        }

    }
}
