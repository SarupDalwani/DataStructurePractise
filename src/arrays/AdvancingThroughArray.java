package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem :In a particular board game, a player has to try to advance through a sequence of positions. Each position has a
 * nonnegative integer associated with it, representing the maximum you can advance from that position in one move. You begin
 * at the first position,and win by getting to the last position.
 * <br>
 * Write a program which takes an array of n integers, where A[i] denotes the maximum you can advance from index i, and returns whether it is possible to advance to the last index starting from the beginning of the array.
 * <br>
 * <br>
 * <br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 * <br>
 * <br/>
 *<br>
 * External links :
 * <ul>
 *     <li><a href="https://leetcode.com/problems/jump-game">LeetCode</a></a></li>
 * </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class AdvancingThroughArray {
    public static void main(String[] args) {
        int[] input1 = {3,3,1,0,2,0,1};
        int[] input2 = {2,3,1,1,4};
        int[] input3 = {3,2,1,0,4};

        System.out.println("Possible to reach end of array" + Arrays.toString(input1) +" : "+ traversalPossible(input1));
        System.out.println("Possible to reach end of array" + Arrays.toString(input2) +" : "+ traversalPossible(input2));
        System.out.println("Possible to reach end of array" + Arrays.toString(input3) +" : "+ traversalPossible(input3));
    }

    public static boolean traversalPossible(int[] arr){
        int maxPossible=0;
        int current=0;

        while(current<=maxPossible && current<arr.length){
            maxPossible = Math.max(maxPossible,current+arr[current]);
            current++;
        }

        return maxPossible>=arr.length-1;
    }
}
