package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a program which takes as input two sorted arrays, and returns a new array containing elements that are present in both of the input arrays.
 *<br>
 *<br>
 * Time Complexity : O(n+m)
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

public class Intersection {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(2,3,3,5,5,6,7,7,8,12);
        List<Integer> b = Arrays.asList(5,5,6,8,8,9,10,10);

        System.out.println("Intersection is "+intersection(a,b));
    }

    public  static List<Integer> intersection(List<Integer> a, List<Integer> b){

        int i=0,j=0;
        List<Integer> result = new ArrayList<>();
        while(i<a.size() && j<b.size()){
            if(a.get(i) < b.get(j))i++;
            else if(a.get(i) > b.get(j))j++;
            else {
                result.add(a.get(i));
                while (i<a.size() && a.get(i)==b.get(j))i++;
            }
        }
        return result;
    }
}
