package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes as input a permutation, and returns the previous permutation under dictionary ordering. If
 * the permutation is the last permutation, return the empty array. For example, if the input is (1,3,2) your function should
 * return (1, 2,3). If the input is (1,2,3), return ().
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href=""></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class PreviousPermutation {
    public static void main(String[] args) {
        int[] input1 = {};
        int[] input2 = {1,2,3};
        int[] input3 = {4, 2, 5, 2, 1, 3};
        int[] input4 = {5, 6, 7, 9, 8};
        int[] input5 = {1, 4, 6, 2, 3, 5, 6, 7, 8, 9, 4, 3, 3, 5, 6, 6, 7, 8, 9};
        int[] input6 = {4, 2, 3, 5, 3, 1};

        System.out.println("Previous Permutation for "+Arrays.toString(input1)+" is "+Arrays.toString(previousPermutation(input1)));
        System.out.println("Previous Permutation for "+Arrays.toString(input2)+" is "+Arrays.toString(previousPermutation(input2)));
        System.out.println("Previous Permutation for "+Arrays.toString(input3)+" is "+Arrays.toString(previousPermutation(input3)));
        System.out.println("Previous Permutation for "+Arrays.toString(input4)+" is "+Arrays.toString(previousPermutation(input4)));
        System.out.println("Previous Permutation for "+Arrays.toString(input5)+" is "+Arrays.toString(previousPermutation(input5)));
        System.out.println("Previous Permutation for "+Arrays.toString(input6)+" is "+Arrays.toString(previousPermutation(input6)));

    }

    public static int[] previousPermutation(int[] arr){

        int[] temp = Arrays.copyOf(arr,arr.length);
        int i=temp.length-2;
        for(;i>=0;i--){
            if(temp[i]>temp[i+1])break;
        }
        if(i<0)return new int [0];

        int j = temp.length-1;
        while(j>i && temp[j]>=temp[i])j--;
        int tempNum = temp[j];
        temp[j]=temp[i];
        temp[i]=tempNum;


        int a=i+1,b=temp.length-1;
        while(a<b){
            tempNum = temp[a];
            temp[a]=temp[b];
            temp[b]=tempNum;
            a++;b--;
        }

        return temp;

    }
}
