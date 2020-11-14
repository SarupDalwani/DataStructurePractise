package search;

import java.util.Arrays;

/**
 *
 *
 * Problem : Design an algorithm to find the min and max elements in an array
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

public class MinMax {
    public static void main(String[] args) {

        minMax(new int[]{1,2,3,4,5,6,7});
        minMax(new int[]{7,6,5,4,3,2,1});
        minMax(new int[]{1,2,3,4,3,2,1});
        minMax(new int[]{7,6,5,4,5,6,7});

    }

    public static void minMax(int[] arr){
        if(arr.length>0){
            int min=arr[0],max=arr[0];

            for(int i=1;i<arr.length;i++){
                if(arr[i]>max)
                    max=arr[i];
                else if(arr[i]<min)
                    min =arr[i];
            }
            System.out.println("For "+ Arrays.toString(arr)+" min: "+min+" max: "+max);

        }

    }
}
