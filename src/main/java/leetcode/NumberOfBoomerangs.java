package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Example:
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

/**
   不能超时，
    类似An2 的解法
    所有的点都要遍历，记得去除相等点。
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) return 0;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> disMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                long curDis = getDistance(points, i, j);
                if (curDis == 0) continue;
                Integer mixedPoint = disMap.get(curDis);
                if (mixedPoint != null) {
                    result += mixedPoint * 2;
                    mixedPoint++;
                } else {
                    mixedPoint = 1;
                }
                disMap.put(curDis, mixedPoint);
            }
        }
        return result;
    }

    private long getDistance(int[][] points, int begin, int end) {
        int width = points[begin][0] - points[end][0];
        int length = points[begin][1] - points[end][1];
        return width*width + length*length;
    }


    public static void main(String[] args) {
        NumberOfBoomerangs sample = new NumberOfBoomerangs();
        //[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        int[][] points = new int[][] {{0,0}, {1,0}, {-1,0}, {0,1},{0,-1}};
        System.out.println(sample.numberOfBoomerangs(points));
    }
}
