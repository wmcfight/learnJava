package leetcode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //1
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0 ) return false;
        int left = 0, right = matrix.length - 1, size = matrix.length, width = matrix[0].length;
        int row = 0 ;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][width - 1] == target) {
                return true;
            } else if (matrix[mid][width - 1] < target) {
                row = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(row >= size) return false;
        left = 0 ;
        right = width - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}
