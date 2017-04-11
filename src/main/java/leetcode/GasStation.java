package leetcode;

/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Subscribe to see which companies asked this question.
 */
public class GasStation  {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, cur = -1;
        for (int i = 0 ; i < gas.length; i++ ) {
            sum += gas[i] - cost[i];
            cur = Math.max(gas[i] - cost[i] , sum ) < 0 ? i : cur;
        }
        return sum >= 0 ? cur + 1 : -1;
    }
}
