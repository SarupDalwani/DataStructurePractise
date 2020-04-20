package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes an array denoting the daily stock price, and returns the maximum profit that could be made by buying and then selling one share of that stock.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class StockBuySell {
    public static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {7,1,5,3,6,4};
        int[] input3 = {7,6,4,3,1};
        int[] input4 = {310,315,275,295,260,270,290,230,255,250};

        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input1)+" is "+maxProfit(input1));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input2)+" is "+maxProfit(input2));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input3)+" is "+maxProfit(input3));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input4)+" is "+maxProfit(input4));

    }

    public static int maxProfit(int[] stockPrice){
        int minValue = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<stockPrice.length;i++){
            if(minValue>stockPrice[i]){
                minValue=stockPrice[i];
            }else {
                profit = Math.max(profit,stockPrice[i]-minValue);
            }
        }
        return profit;
    }
}
