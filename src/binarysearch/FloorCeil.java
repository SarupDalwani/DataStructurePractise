package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : : Design an efficient algorithm that takes a sorted array and a key, and finds the index of the first occurrence of an element greater than that key.
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

public class FloorCeil {
    public static void main(String[] args) {

        int[] arr = {1,10,100,1000,10000};
        System.out.println("ceil of 0 in "+ Arrays.toString(arr)+": " +ceil(arr,0));
        System.out.println("ceil of 1 in "+Arrays.toString(arr)+": " +ceil(arr,1));
        System.out.println("ceil of 2 in "+Arrays.toString(arr)+": " +ceil(arr,2));
        System.out.println("ceil of 56 in "+Arrays.toString(arr)+": " +ceil(arr,56));
        System.out.println("ceil of 456 in "+Arrays.toString(arr)+": " +ceil(arr,456));
        System.out.println("ceil of 7890 in "+Arrays.toString(arr)+": " +ceil(arr,7890));
    }

    public static Integer ceil(int[] arr,int key){
        int low=0,high = arr.length;
        int mid = (high+low)/2;

        while(low<high){
            if(arr[mid] == key)
                return arr[mid];
            else if(arr[mid]>key)
                high=mid;
            else low= mid+1;
            mid = (high+low)/2;
        }

        return arr[low];
    }
}
