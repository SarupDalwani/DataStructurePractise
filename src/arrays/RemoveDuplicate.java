package arrays;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program which takes as input a sorted array and updates it so that all duplicates have been removed and the remaining elements have been shifted left to fill the emptied indices.
 *<br>
 *<br>
 * Time Complexity : O()
 * <br>
 * Space Complexity : O()
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href=""></a></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] input1={};
        int[] input2={1,2,3,4,5,6};
        int[] input3={1,1,2,2,3,4,4,4,4,4,5,5,5,6,6,6,6,6};

        removeDuplicate(input1);
        removeDuplicate(input2);
        removeDuplicate(input3);

        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(input3));

    }

    public static void removeDuplicate(int[] arr){
        int writable=1;
        for(int i=1;i<arr.length;i++){
            if(arr[writable-1] != arr[i] ){
                arr[writable++]=arr[i];
            }
        }
        while (writable<arr.length)
            arr[writable++]=0;
    }
}
