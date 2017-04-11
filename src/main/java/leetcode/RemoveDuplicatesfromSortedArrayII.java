package leetcode;

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A.length <= 2) return A.length;
        int index = 2;
        for(int i=2;i<A.length;i++){
            if(A[i] != A[index-2]){
                A[index++] = A[i];
            }
        }
        return index;
    }
}
