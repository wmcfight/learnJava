/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package leetcode;

import learnJava.maxPoint;

/**
 * Descriptions of the class Solution.java's implementation：TODO described the
 * implementation of class
 * 
 * @author wmc 2014年5月12日 下午10:25:12
 */
public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix.length <= 0 || matrix[0].length <= 0)
			return;
		int width = matrix.length;
		int len = matrix[0].length;

		boolean rflag1 = false, rflag2 = false;

		for (int i = 0; i < width; i++) {
			if (matrix[i][0] == 0) {
				rflag1 = true;
				break;
			}
		}

		for (int i = 0; i < len; i++) {
			if (matrix[0][i] == 0) {
				rflag2 = true;
				break;
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < len; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < width; i++) {
			for (int j = 1; j < len; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (rflag1) {
			for (int i = 0; i < width; i++) {
				matrix[i][0] = 0;
			}
		}

		if (rflag2) {
			for (int i = 0; i < len; i++) {
				matrix[0][i] = 0;
			}
		}
	}

	public int candy(int[] ratings) {
		int len = ratings.length;
		int[] result = new int[len];

		for (int i = 0; i < len - 1; i++) {
			if (ratings[i + 1] > ratings[i]) {
				result[i + 1] = Math.max(result[i] + 1, result[i + 1]);
			}
		}

		for (int i = len - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				result[i - 1] = Math.max(result[i] + 1, result[i - 1]);
			}
		}

		int sum = 0;
		for (int item : result) {
			sum += item;
		}

		return sum + len;
	}

	public boolean isAandB(String c, String a, String b) {
		if (c.length() != a.length() + b.length()) {
			return false;
		} else {
			boolean con[][] = new boolean[a.length() + 1][b.length() + 1];
			int wid = con.length, dep = con[0].length;
			for (int i = 0; i < wid; i++) {
				for (int j = 0; j < dep; j++) {
					con[i][j] = false;
				}
			}
			con[0][0] = true;
			int i, j;
			for (i = 0; i < wid - 1; i++) {
				if (a.charAt(i) == c.charAt(i)) {
					con[i + 1][0] = true;
				}
			}
			for (i = 0; i < dep - 1; i++) {
				if (b.charAt(i) == c.charAt(i)) {
					con[0][i + 1] = true;
				}
			}
			int total = c.length();
			int cur = 1;

			while (cur <= total) {
				for (i = 1; i <= wid - 1; i++) {
					for (j = cur - i; j <= dep - 1; j++) {
						if (j > 0) {
							if ((c.charAt(i + j - 1) == a.charAt(i - 1) && con[i - 1][j])
									|| (c.charAt(i + j - 1) == b.charAt(j - 1) && con[i][j - 1])) {
								con[i][j] = true;
							}
						}

					}
				}

				cur++;
			}

			return con[wid - 1][dep - 1];

		}
	}

	public boolean isPalindrome(String s) {
		boolean result = true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if ((Character.isLetter(s.charAt(i))
					&& Character.isLetter(s.charAt(j)) && (Character
					.toLowerCase(s.charAt(i)) == Character.toLowerCase(s
					.charAt(j))))
					|| (Character.isDigit(s.charAt(i))
							&& Character.isDigit(s.charAt(j)) && (s.charAt(i) == s
							.charAt(j)))) {
				i++;
				j--;
			} else {
				result = false;
				break;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		Solution handler = new Solution();
		// int[] data = { 4, 2, 3, 4, 1 };
		// int result = handler.candy(data);
		System.out.println(handler.isAandB("abcd", "ac", "db") ? "YES" : "NO");
	}
}