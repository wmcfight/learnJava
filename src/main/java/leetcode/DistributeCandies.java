package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
Given an integer array with even length, where different numbers
 in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind.
 You need to distribute these candies equally in number to brother and sister.
 Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.
 */

/**
直接将每种糖果存入set，则可获得所有糖果的种类，若种类大于一半
 ，则返回数组长度的一半（因为妹妹最多获得一半数量糖果），则获取种类数
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kindSize = new HashSet<>();
        for (int candy : candies) {
            kindSize.add(candy);
        }
        return kindSize.size() >= candies.length / 2 ? candies.length /2 : kindSize.size();
    }
}
