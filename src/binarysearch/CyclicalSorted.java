package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : Design an O(log n) algorithm for finding the position of an element k in a cyclically sorted array of distinct
 * elements.
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

public class CyclicalSorted {
    public static void main(String[] args) {

        int[] arr={ 378, 478, 550, 631, 103, 203, 220, 234, 279, 368};

        System.out.println("Index for 378 "+Arrays.toString(arr)+" is "+findElement(arr,378));
        System.out.println("Index for 631 "+Arrays.toString(arr)+" is "+findElement(arr,631));
        System.out.println("Index for 103 "+Arrays.toString(arr)+" is "+findElement(arr,103));
        System.out.println("Index for 368 "+Arrays.toString(arr)+" is "+findElement(arr,368));
        System.out.println("Index for 202 "+Arrays.toString(arr)+" is "+findElement(arr,202));



    }

    public static Integer findIndex(int[] arr){
        int low=0,high = arr.length;
        int mid = (high+low)/2;

        while(low<high){

            //System.out.println("low "+low+" high "+high);
            Integer left = mid == 0 ? Integer.MAX_VALUE : arr[mid-1];
            Integer right = mid == arr.length-1 ? Integer.MAX_VALUE : arr[mid+1];

            if(arr[mid]<= left && arr[mid]<=right)
                return mid;
            else if(arr[mid]<= arr[low])
                high=mid;
            else low=mid+1;

            mid = (high+low)/2;
        }

        return null;
    }

    public static Integer findElement(int[] arr, int key){
        int cycStart = findIndex(arr);
        if(arr.length>0){
            if(key >= arr[0])
                return search(arr,key,0,cycStart);
            else return search(arr,key,cycStart,arr.length);
        }
        return null;
    }

    public static Integer search(int[] arr,int key ,int l,int h){
        int low=l,high = h;
        int mid = (high+low)/2;

        while(low<high){
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]>key)
                high=mid;
            else low= mid+1;
            mid = (high+low)/2;
        }

        return null;
    }
}
