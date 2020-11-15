package sorting;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program which takes as input two sorted arrays of integers, and updates the first to the combined entries of the two arrays in sorted order.
 *<br>
 *<br>
 * Time Complexity : O(n+m)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="LeetCode">https://leetcode.com/problems/merge-sorted-array/</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class MergeSortedArrays {
    public static void main(String[] args) {
            int[] a= {5,13,17,0,0,0,0};
            int[] b ={3,7,11,19};

            merge(a,3,b,4);

        System.out.println("Merged array "+ Arrays.toString(a));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m--;
        n--;
        while(m>=0 && n>=0){
            if(nums2[n] > nums1[m])
                nums1[index--]=nums2[n--];
            else nums1[index--]=nums1[m--];
        }

        while (n>=0)
            nums1[index--]=nums2[n--];
    }
}
