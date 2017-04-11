package leetcode;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Subscribe to see which companies asked this question.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <=0 ) return 0;
        if (ratings.length == 1) return 1;
        int[] result = new int[ratings.length];

        for (int i = 0; i<result.length; i++) {
            result[i] = 0;
        }

        for (int i = 0; i< ratings.length - 1; i++) {
            if(ratings[i] > ratings[i+1] && result[i] <= result[i+1] ) result[i] = result[i+1] + 1;
            if(ratings[i] < ratings[i+1] && result[i] >= result[i+1] ) result[i+1] = result[i] + 1;
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i] > ratings[i-1] && result[i] <= result[i-1] ) result[i] = result[i-1] + 1;
            if(ratings[i] < ratings[i-1] && result[i] >= result[i-1] ) result[i-1] = result[i] + 1;
        }
        int con = 0;
        for (int i = 0; i<result.length; i++) {
            con += result[i];
        }

        return con + ratings.length;

    }
}
