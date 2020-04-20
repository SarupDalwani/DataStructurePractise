package arrays;

import java.util.Arrays;

/**
 *
 * Problem : Write a program that takes two arrays representing integers, and returns an integer representing their product.
 *
 * Time Complexity : O(m*n)
 * Space Complexity: O(1) excluding output
 *
 * @author Sarup Dalwani
 *
 */

public class MultipleTwoNumbers {

    public static void main(String[] args) {
        int[] one1={5,7,6};
        int[] two1= {4,3};

        int[] one2={-7,6,1,8,3,8,2,5,7,2,8,7};
        int[] two2= {1,9,3,7,0,7,7,2,1};

        System.out.println(Arrays.toString(one1) + " * "+Arrays.toString(two1) +" = "+Arrays.toString(multiply(one1,two1)));
        System.out.println(Arrays.toString(one2) + " * "+Arrays.toString(two2) +" = "+Arrays.toString(multiply(one2,two2)));
    }

    public static int[] multiply(int[] one, int[] two) {
        boolean neg = false;
        if(one.length > 0 && one[0]<0){
            neg = neg ^ true;
            one[0] = -1* one[0];
        }

        if(two.length > 0 && two[0]<0){
            neg = neg ^ true;
            two[0] = -1* two[0];
        }

        int len = one.length+two.length;
        int[] result = new int[len];

        int mulCarry=0,index,mul;

        for(int j = two.length-1; j>=0; j--){
            index = len-j-1;
            for(int i=one.length-1;i>=0;i--){
                index = i+j+1;
                mul = two[j]* one[i];
                mulCarry+=mul + result[index];
                result[index] = mulCarry%10;
                mulCarry/=10;
            }

            while(mulCarry>0 && index >=0){
                mulCarry += result[--index];
                result[index] = mulCarry%10;
                mulCarry/=10;
            }
        }

        if(neg){
            index =0 ;
            while(index<len && result[index]==0)index++;
            result[index]*=-1;
        }

        return result;

    }

}
