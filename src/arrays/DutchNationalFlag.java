package arrays;

import java.util.Arrays;

/**
 *
 *
 *
 * Problem : Write a program that takes an array A and an index i into A, and rearranges the elements such that all elements
 * less than A[i] (the "pivot") appear first, followed by elements equal to the pivot, followed by elements greater than the pivot.
 *
 *
 * Complexity <br>
 *     Time : O(n)
 *     Space : O(n)
 * @author Sarup Dalwnani
 */



public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {0,0,0,1,1,1,2,2,2};
        int[] input3 = {0,1,2,0,1,2};
        int[] input4 = {2,2,2,0,0,0,1,1,1};
        int[] input5 = {2,2,1,1,0,0,2,1,0};
        int[] input6 = {1,1,1,1,1};

        dutchNationalFlagSort(input1);
        dutchNationalFlagSort(input2);
        dutchNationalFlagSort(input3);
        dutchNationalFlagSort(input4);
        dutchNationalFlagSort(input5);
        dutchNationalFlagSort(input6);

        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(input3));
        System.out.println(Arrays.toString(input4));
        System.out.println(Arrays.toString(input5));
        System.out.println(Arrays.toString(input6));

    }

    public static void dutchNationalFlagSort(int[] arr){
        int zero=0,one=0,two = arr.length-1;

        while(one<=two){
            if(arr[one]==0){
                arr[one]=arr[zero];
                arr[zero]=0;
                one++;
                zero++;
            }else if(arr[one]==2){
                arr[one]=arr[two];
                arr[two]=2;
                two--;
            }else {
                one++;
            }
        }
    }
}
