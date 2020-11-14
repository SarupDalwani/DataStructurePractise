package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : Let A be an unsorted array of n integers, with A[0] > A[l] and A[n - 2] < A[n - 1]. Call an index i a local
 * minimum if A[i] is less than or equal to its neighbors. How would you efficiently find a local minimum, if one exists?
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

public class LocalMinima {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,3,6,7};
        System.out.println("Local minima in "+ Arrays.toString(arr1)+" is "+minima(arr1));

        int[] arr2 = {1,2,3,4,5,6,7};
        System.out.println("Local minima in "+ Arrays.toString(arr2)+" is "+minima(arr2));


        int[] arr3 = {5,4,3,2,1};
        System.out.println("Local minima in "+ Arrays.toString(arr3)+" is "+minima(arr3));


        int[] arr4 = {2};
        System.out.println("Local minima in "+ Arrays.toString(arr4)+" is "+minima(arr4));


    }

    public static Integer minima(int[] arr){
        int low=0,high = arr.length;
        int mid = (high+low)/2;

        while(low<high){

            Integer left = mid == 0 ? Integer.MAX_VALUE : arr[mid-1];
            Integer right = mid == arr.length-1 ? Integer.MAX_VALUE : arr[mid+1];

            if(arr[mid]<= left && arr[mid]<=right)
                return mid;
            else if(arr[mid]>= left && arr[mid]<=right)
                high=mid;
            else low=mid+1;

            mid = (high+low)/2;
        }

        return null;
    }
}
