package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 *
 * Problem : Write a program which takes as input a set of integers represented by an array, and returns the size of a largest subset of integers in the array having the property that if two integers are in the subset, then so are all integers between them
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="LeetCode">https://leetcode.com/problems/longest-consecutive-sequence/</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LongestContainedInterval {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,5,3,11,6,100,4);
        System.out.println("LongestContainedInterval length "+longestContianedInterval(numbers));
    }

    public static int longestContianedInterval(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<Integer>(numbers);
        int result= 0;
        while (!set.isEmpty()){
            int curr = set.iterator().next();
            set.remove(curr);
            int start=curr-1,end=curr+1;
            while(set.contains(start)){
                set.remove(start);
                start--;
            }
            while (set.contains(end)){
                set.remove(end++);
            }

            result = Math.max(result,end - start -1);
        }
        return result;
    }
}
