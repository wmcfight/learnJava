package leetcode;

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] A) {
        if(A == null || A.length <= 1) return;
        int rindex = 0, bindex = A.length - 1;
        int temp = 0;
        for (int i = 0; i <= bindex; ) {
            if(A[i] == 0) {
                if (rindex < i) {
                    temp = A[rindex];
                    A[rindex++] = A[i];
                    A[i] = temp;
                } else {
                    rindex++;
                    i++;
                }
            } else if (A[i] == 2) {
                if (i < bindex) {
                    temp = A[bindex];
                    A[bindex--] = A[i];
                    A[i] = temp;
                } else {
                    bindex--;
                    i++;
                }
            } else {
                i++;
            }
        }
    }
}
