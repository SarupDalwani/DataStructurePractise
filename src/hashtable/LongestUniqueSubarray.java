package hashtable;

import java.util.*;

/**
 *
 *
 * Problem : Write a program that takes an array and returns the length of a longest subarray with the property that all its elements are distinct.
 *<br>
 *<br>
 * Time Complexity : O(n) as hashset operations are O(1) and each element is added and remove atmost once
 * <br>
 * Space Complexity : O(n) number of distint elements
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="LeetCode">https://leetcode.com/problems/longest-substring-without-repeating-characters/</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LongestUniqueSubarray {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("hello","world","my","name","is","hello","mister");
        List<String> strings2 = Arrays.asList("s","e","t","i","e","n","w","r","f","s","e");
        List<String> strings3 = Arrays.asList("hello","world","my","name","is","mister");
        System.out.println("Longest unique subarray length : "+longestUniqueSubarray(strings));
        System.out.println("Longest unique subarray length : "+longestUniqueSubarray(strings2));
        System.out.println("Longest unique subarray length : "+longestUniqueSubarray(strings3));
    }

    public static int longestUniqueSubarray(List<String> strings){
        int result=0,start=0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<strings.size();i++){
            if(set.add(strings.get(i))){
                result = Math.max(result,i-start+1);
            }else {
                while (set.contains(strings.get(i))){
                    set.remove(strings.get(start++));
                }
                set.add(strings.get(i));
            }
        }
        return result;
    }
}
