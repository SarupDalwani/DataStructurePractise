package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that computes the maximum profit that can be made by buying and selling a share at most twice. The second buy must be made on another date after the first sale.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii">LeetCode</a></li>
 *  </ul>
 *
 * Level : Red(must do)
 *
 * @author Sarup Dalwani
 *
 */

public class StockBuySellTwice {
    public static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {7,1,5,3,6,4};
        int[] input3 = {7,6,4,3,1};
        int[] input4 = {310,315,275,295,260,270,290,230,255,250};
        int[] input5 = {12,11,13,9,12,8,14,13,15};
        int[] input6 = {3,2,6,5,0,3};
        int[] input7 = {4,7,2,1,11};

        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input1)+" is "+maxProfit(input1));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input2)+" is "+maxProfit(input2));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input3)+" is "+maxProfit(input3));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input4)+" is "+maxProfit(input4));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input5)+" is "+maxProfit(input5));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input6)+" is "+maxProfit(input6));
        System.out.println("Max Profit from stockPrices "+ Arrays.toString(input7)+" is "+maxProfit(input7));

    }

    public static int maxProfit(int[] stockPrice){
        int minValue = Integer.MAX_VALUE;
        int maxProfit=0;
        int[] profits = new int[stockPrice.length];
        for(int i=0;i<stockPrice.length;i++){
            if(minValue>stockPrice[i]){
                minValue=stockPrice[i];
            }else {
                maxProfit = Math.max(maxProfit,stockPrice[i]-minValue);
            }
            profits[i] = maxProfit;
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i=stockPrice.length-1;i>0;i--){
            if(stockPrice[i]>maxValue){
                maxValue = stockPrice[i];
            }else{
                maxProfit = Math.max(maxProfit,profits[i-1]+ (maxValue-stockPrice[i]));
                //System.out.println("index i :"+i+" maxProfit : "+maxProfit +);
            }
        }
        return maxProfit;
    }
}
