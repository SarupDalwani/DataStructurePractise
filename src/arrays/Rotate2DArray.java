package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem :Write a function that takes as input an n X n 2D array, and rotates the array by 90 degrees clockwise.
 *<br>
 *<br>
 * Time Complexity : O(n^2)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/rotate-image/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class Rotate2DArray {
    public static void main(String[] args) {

        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        clockwise(arr);
        print(arr);
        System.out.println("");
        antiClockwise(arr);
        print(arr);

    }

    private static void print(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(arr[i][j] +" ");
            System.out.println("");
        }

    }

    private static void clockwise(int arr[][]){
        int n=arr.length;

        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[n-i-1][j];
                arr[n-i-1][j]=temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    private static void antiClockwise(int arr[][]){
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[n-i-1][j];
                arr[n-i-1][j]=temp;
            }
        }

    }
}
