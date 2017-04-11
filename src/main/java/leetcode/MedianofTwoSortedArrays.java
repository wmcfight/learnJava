package leetcode;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) return 0.0;
        int tLen = A.length + B.length;
        if (tLen % 2 != 0 ) {
            return findKth(A, 0, B, 0, tLen / 2 + 1);
        } else {
            return ( findKth(A, 0, B, 0, tLen / 2) + findKth(A, 0, B, 0, tLen / 2 + 1) ) /2.0;
        }
    }

    private double findKth(int A[], int aCur, int B[], int bCur, int tLen) {
        int aLeft = A.length - aCur, bLeft = B.length - bCur;
        if (aLeft > bLeft) return findKth(B, bCur, A, aCur, tLen);
        if (aLeft == 0) return B[bCur + tLen - 1];
        if (tLen == 1) return Math.min(A[aCur], B[bCur]);

        int midA = Math.min(aLeft, tLen/2), midB = tLen - midA;
        if(A[aCur + midA-1] < B[bCur + midB-1]) return findKth(A , aCur + midA, B, bCur, tLen - midA);
        else if(A[aCur + midA-1] > B[bCur + midB-1]) return findKth(A, aCur, B , bCur + midB, tLen - midB);
        else return A[aCur + midA-1];
    }
}
