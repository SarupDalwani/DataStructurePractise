package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 * Problem :
 *<br>
 *<br>
 * Time Complexity : O()
 * <br>
 * Space Complexity : O()
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

public class SmallestStringCoveringLetters {
    public static void main(String[] args) {

        System.out.println("Smallest String is "+smallestString(
                Arrays.asList("apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana","banana", "apple", "cat", "dog"),
                new HashSet<>(Arrays.asList("banana","cat"))));
    }

    public static String smallestString(List<String> para, Set<String> words){
        Map<String,Integer> present = new HashMap<>();
        for(String s: words){
            present.put(s,0);
        }
        int start=0,minSize = Integer.MAX_VALUE, minStart=0;
        int count = present.size();

        for(int i=0;i<para.size();i++){

            if(present.containsKey(para.get(i))){
                present.put(para.get(i),present.get(para.get(i))+1);
                if(present.get(para.get(i)) == 1){
                    count--;
                    while(count == 0 && start<=i){
                        int diff = i-start;
                        if(diff<minSize){
                            minSize = diff;
                            minStart=start;
                        }
                        if(present.containsKey(para.get(start))){
                            present.put(para.get(start),present.get(para.get(start))-1);
                            if(present.get(para.get(start)) == 0)
                                count++;
                        }
                        start++;
                    }
                }

            }

        }

        String result = "";

        for(int i=minStart ; i<=(minStart+minSize);i++){
            result += para.get(i) +" ";
        }
        return result;
    }
}
