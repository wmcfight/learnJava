package leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

int maxProfit(vector<int> &prices) {
        //if(prices.size() <=0) return 0;
        int cur_min = INT_MAX,result = INT_MIN;
        for(int i=0;i<prices.size();i++){
            cur_min = min(cur_min,prices[i]);
            result = max(result,prices[i]-cur_min);
        }
        return result == INT_MIN ? 0 : result;
    }

 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] data) {
        int curMin = Integer.MAX_VALUE, result = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            curMin = Math.min(curMin, data[i]);
            result = Math.max(result, data[i] - curMin);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
