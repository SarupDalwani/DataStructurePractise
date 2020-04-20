package arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 *
 * Problem : Given an array A of n elements and a permutation P, apply P to A.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://www.geeksforgeeks.org/permute-the-elements-of-an-array-following-given-order/">GeeksForGeeks</a>
 *       </li>
 *  </ul>
 *
 * <br/>
 * <br/>
 * <br/>
 * Assumption :
 * <ul>
 *     <li>
 *         We are allowed to modify permutation array
 *     </li>
 * </ul>
 *
 *
 * @author Sarup Dalwani
 *
 */

public class ApplyPermutation {
    public static void main(String[] args) {

        int[] A1= {2,3,4,5,6};
        int[] P1= {1,2,4,0,3};

        System.out.println("Perm : "+ Arrays.toString(P1)+" on Array : "+Arrays.toString(A1));
        nonNegavtiveNumbersPermutations(A1,P1);
        System.out.println(" is "+Arrays.toString(A1));


    }

    public static void nonNegavtiveNumbersPermutations(int[] arr,int[] p){
        for(int i=0;i<arr.length;i++){
            int next =i ;
            while(p[next]>=0){
                int temp = arr[p[next]];
                arr[p[next]] = arr[i];
                arr[i]=temp;
                temp = p[next];
                p[next] -= arr.length;
                next = temp;
            }
        }
    }
}
