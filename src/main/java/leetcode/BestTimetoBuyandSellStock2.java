package leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However,
you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


int maxProfit(vector<int> &prices) {
        int cur_min = INT_MAX ,result = 0;
        for(int i=0;i<prices.size();i++){
            if(cur_min <= prices[i]){
                result += prices[i] - cur_min;
            }
            cur_min = prices[i];
        }
        return result;
    }
 */
public class BestTimetoBuyandSellStock2 {
}
