package leetcode;

/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class SqrtX {
    public int sqrt(int x) {
        if (x < 2) return x;
        int left = 1 , right = x / 2;
        int mid = 0, result = 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if (x / mid > mid) {
                left = mid + 1;
                result = mid;
            } else if( x / mid == mid) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
