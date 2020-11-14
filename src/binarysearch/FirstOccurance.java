package binarysearch;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a method that takes a sorted array and a key and returns the index of the first occurrence of that key in the array.
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

public class FirstOccurance {
    public static void main(String[] args) {

        int[] arr1= {1,2,3,4,5,6};

        System.out.println("firstOccurance of 4 in "+Arrays.toString(arr1)+": " +firstOccurance(arr1,4));
        System.out.println("lastOccurance of 4 in "+Arrays.toString(arr1)+": " +lastOccurance(arr1,4));
        System.out.println("firstOccurance of 6 in "+ Arrays.toString(arr1)+" : " +firstOccurance(arr1,6));
        System.out.println("lastOccurance of 6 in "+ Arrays.toString(arr1)+" : " +lastOccurance(arr1,6));
        System.out.println("firstOccurance of 1 in "+Arrays.toString(arr1)+" : " +firstOccurance(arr1,1));
        System.out.println("lastOccurance of 1 in "+Arrays.toString(arr1)+" : " +lastOccurance(arr1,1));
        System.out.println("firstOccurance of 7 in "+Arrays.toString(arr1)+" : " +firstOccurance(arr1,7));
        System.out.println("lastOccurance of 7 in "+Arrays.toString(arr1)+" : " +lastOccurance(arr1,7));

        int[] arr2= {1,2,3,4,5};

        System.out.println("firstOccurance of 4 in "+Arrays.toString(arr2)+": " +firstOccurance(arr2,4));
        System.out.println("lastOccurance of 4 in "+Arrays.toString(arr2)+": " +lastOccurance(arr2,4));
        System.out.println("firstOccurance of 6 in "+Arrays.toString(arr2)+" : " +firstOccurance(arr2,6));
        System.out.println("lastOccurance of 6 in "+Arrays.toString(arr2)+" : " +lastOccurance(arr2,6));
        System.out.println("firstOccurance of 1 in "+Arrays.toString(arr2)+" : " +firstOccurance(arr2,1));
        System.out.println("lastOccurance of 1 in "+Arrays.toString(arr2)+" : " +lastOccurance(arr2,1));

        int[] arr3= {};

        System.out.println("firstOccurance of 4 in "+Arrays.toString(arr3)+": " +firstOccurance(arr3,4));
        System.out.println("lastOccurance of 4 in "+Arrays.toString(arr3)+": " +lastOccurance(arr3,4));

        int[] arr4= {1,1,4,4,6,6,6};

        System.out.println("firstOccurance of 4 in "+Arrays.toString(arr4)+": " +firstOccurance(arr4,4));
        System.out.println("lastOccurance of 4 in "+Arrays.toString(arr4)+": " +lastOccurance(arr4,4));
        System.out.println("firstOccurance of 6 in "+Arrays.toString(arr4)+" : " +firstOccurance(arr4,6));
        System.out.println("lastOccurance of 6 in "+Arrays.toString(arr4)+" : " +lastOccurance(arr4,6));
        System.out.println("firstOccurance of 1 in "+Arrays.toString(arr4)+" : " +firstOccurance(arr4,1));
        System.out.println("lastOccurance of 1 in "+Arrays.toString(arr4)+" : " +lastOccurance(arr4,1));




    }

    public static Integer search(int[] arr,int key){
        int low=0,high = arr.length;
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
    
    public static Integer firstOccurance(int[] arr,int key){
        int low=0,high = arr.length;
        int mid = (high+low)/2;
        while(low<high){
            if(arr[mid] == key){
                if(mid==0 || (mid>0 && arr[mid-1]!=key))
                    return mid;
                high = mid;
                
            }
            else if(arr[mid]>key)
                high=mid;
            else low= mid+1;
            mid = (high+low)/2;
        }

        return null;
    }


    public static Integer lastOccurance(int[] arr,int key){
        int low=0,high = arr.length;
        int mid = (high+low)/2;
        while(low<high){
            if(arr[mid] == key){
                if(mid==arr.length-1 || arr[mid+1]!=key)
                    return mid;
                low = mid+1;

            }
            else if(arr[mid]>key)
                high=mid;
            else low= mid+1;
            mid = (high+low)/2;
        }

        return null;
    }

}
