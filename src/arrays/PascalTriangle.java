package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program which takes as input a nonnegative integer n and returns the first n rows of Pascal's triangle.
 *<br>
 *<br>
 * Time Complexity : O(n^2)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/pascals-triangle">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class PascalTriangle {
    public static void main(String[] args) {
        int arr[][]=generatePascalTriangle(10);
        print(arr);


        int nthRow[] = generateNthRowForPascalTriangle(10);
        System.out.println("10th row of pascal triangle is "+ Arrays.toString(nthRow));
    }

    public static void print(int arr[][]){
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println("");
        }
    }

    private static int[][] generatePascalTriangle(int n){
        n=n+1;
        int arr[][] = new int[n][n];

        if(n>=1){
            arr[0][0]=1;
        }
        for(int i=0;i<n;i++){
            arr[i][0]=arr[i][i]=1;
            for(int j=1;j<i;j++)
                arr[i][j]=arr[i-1][j] + arr[i-1][j-1];
        }
        return arr;
    }

    private static int[] generateNthRowForPascalTriangle(int n){
        int prev[]=new int[n+1],curr[] = new int[n+1];
        prev[0]=1;
        for(int i=0;i<=n;i++){
            curr[0]=1;
            for(int j=1;j<i;j++)
                curr[j]=prev[j-1]+prev[j];
            curr[i]=1;

            int temp[] = prev;
            prev =curr;
            curr = temp;
        }
        return prev;
    }
}
