package arrays;

import java.util.Arrays;

/**
 *
 * Problem : Write a program which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D + 1.
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1) excluding output
 *
 * @author Sarup Dalwani
 */

public class NumberPlusOne {
    public static void main(String[] args) {
        int[] input1={};
        int[] input2={1,2,9};
        int[] input3={9,9,9,9,9,9};
        int[] input4={0,0,0,0};
        int[] input5={5,4,3,2,1};

        System.out.println(Arrays.toString(numberPlusOne(input1)));
        System.out.println(Arrays.toString(numberPlusOne(input2)));
        System.out.println(Arrays.toString(numberPlusOne(input3)));
        System.out.println(Arrays.toString(numberPlusOne(input4)));
        System.out.println(Arrays.toString(numberPlusOne(input5)));
    }

    public static int[] numberPlusOne(int[] number){
        int numberOfDigits = number.length;
        int[] successor = new int[numberOfDigits+1];
        int carry=1;

        for(int i = numberOfDigits ; i>=0; i--){
            if(i==0)
                successor[i]=carry;
            else {
                successor[i] = (number[i-1]+carry)%10;
                carry = (number[i-1]+carry)/10;
            }
        }
        return successor;
    }
}
