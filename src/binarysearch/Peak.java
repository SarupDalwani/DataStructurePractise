package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : A sequence is strictly ascending if each element is greater than its predecessor. Suppose it is known that an
 * array A consists of a strictly ascending sequence followed by a strictly a strictly descending sequence. Design an algorithm for finding the maximum element in A.
 *<br>
 *<br>
 * Time Complexity : O(log n)
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

public class Peak {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,3,2,1};
        System.out.println("Peak in "+ Arrays.toString(arr1)+" is "+peak(arr1));

        int[] arr2 = {1,2,3,1};
        System.out.println("Peak in "+ Arrays.toString(arr2)+" is "+peak(arr2));


        int[] arr3 = {1,10,2};
        System.out.println("Peak in "+ Arrays.toString(arr3)+" is "+peak(arr3));


        int[] arr4 = {2};
        System.out.println("Peak in "+ Arrays.toString(arr4)+" is "+peak (arr4));


    }

    public static Integer peak(int[] arr){
        int low=0,high = arr.length;
        int mid = (high+low)/2;

        while(low<high){

            Integer left = mid == 0 ? Integer.MIN_VALUE : arr[mid-1];
            Integer right = mid == arr.length-1 ? Integer.MIN_VALUE : arr[mid+1];

            if(arr[mid]>= left && arr[mid]>=right)
                return mid;
            else if(arr[mid]>= left && arr[mid]<=right)
                low = mid+1;
            else high = mid;

            mid = (high+low)/2;
        }

        return null;
    }
}
