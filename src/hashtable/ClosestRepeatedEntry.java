package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * Problem : Write a program which takes as input an array and finds the distance between a closest pair of equal entries.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(m), where m is number of distinct strings
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

public class ClosestRepeatedEntry {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("All", "work", "and", "no", "play", "makes", "for", "no", "work",
                    "no", "fun", "and", "no", "results");
        System.out.println("Minimum distance between repeated words is "+nearestRepeated(strings));
    }

    public static int nearestRepeated(List<String> strs){
        Map<String,Integer> map = new HashMap<>();
        int lowest = Integer.MAX_VALUE;

        for(int i=0;i<strs.size();i++){
            if(map.containsKey(strs.get(i))){
                lowest = Math.min(lowest,i-map.get(strs.get(i)));
            }
            map.put(strs.get(i),i);
        }
        return lowest;
    }
}
