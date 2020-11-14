package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : Design an efficient algorithm that takes a sorted array of distinct integers, and returns an index i such that the element at index i equals i.
 *<br>
 *<br>
 * Time Complexity : O(logn)
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

public class IndexEqualElement {
    public static void main(String[] args) {

        int[] arr={-2,0,2,3,6,7,9};

        System.out.println("Element for "+ Arrays.toString(arr)+" is "+search(arr));
    }

    public static Integer search(int[] arr){
        int low=0,high = arr.length;
        int mid = (high+low)/2;

        while(low<high){
            if(arr[mid] == mid)
                return mid;
            else if(arr[mid]>mid)
                high=mid;
            else low= mid+1;
            mid = (high+low)/2;
        }

        return null;
    }
}
