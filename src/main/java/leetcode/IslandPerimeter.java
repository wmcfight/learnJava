package leetcode;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents
land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
// 只需要考虑右边，下边，有就减2
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int totalResult = 0;
        for (int i = 0 ;i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isIand(i, j, grid)) {
                    totalResult += 4;
                    if (isIand(i+1, j, grid)) {
                        totalResult-=2;
                    }
                    if (isIand(i, j+1, grid)) {
                        totalResult-=2;
                    }
                }
            }
        }
        return totalResult;
    }

    private boolean isIand(int x, int y, int[][] grid) {
        if ((x < 0 || x >= grid.length) || (y < 0 || y >= grid[0].length)) {
            return false;
        }
        return grid[x][y] == 1;
    }
}
