package arrays;

import java.util.Arrays;

/**
 *
 * @author Sarup Dalwani
 *
 *
 * Problem : Your input is an array of integers, and you have to reorder its entries so that the even entries appear first.
 * Source : EPI topic:  Array
 */

public class ArrangeEvenOdd {
    public static void main(String [] args){
        int [] input1 = {1,2,3,4,5,6};
        int [] input2 = {};
        int [] input3 = {2,4,6,1,3,5};
        int [] input4 = {1,3,5,2,4,6};
        int [] input5 = {1,3,5,4,7};

        evenOdd(input1);
        evenOdd(input2);
        evenOdd(input3);
        evenOdd(input4);
        evenOdd(input5);

        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(input3));
        System.out.println(Arrays.toString(input4));
        System.out.println(Arrays.toString(input5));
    }

    public static void evenOdd(int[] array){
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]%2 == 0){
                i++;
                continue;
            }
            if(array[j]%2 == 1){
                j--;
                continue;
            }
            int temp = array[i];
            array[i++]=array[j];
            array[j--]=temp;
        }
    }
}
