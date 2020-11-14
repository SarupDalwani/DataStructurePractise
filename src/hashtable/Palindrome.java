package hashtable;

import java.util.HashMap;

/**
 *
 *
 * Problem : Write a program to test whether the letters forming a string can be permuted to form a palindrome.
 *<br>
 *<br>
 * Time Complexity : O(n) n is length of string
 * <br>
 * Space Complexity : O(n) for hashmap
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

public class Palindrome {
    public static void main(String[] args) {

        String s1 ="hello",s2="world",s3="holo",s4 ="lleve",s5="edified",s6="daamm",s7="hhtthh";
        System.out.println("Palindrome possible for "+s1+" : "+isPalindromePossible(s1));
        System.out.println("Palindrome possible for "+s2+" : "+isPalindromePossible(s2));
        System.out.println("Palindrome possible for "+s3+" : "+isPalindromePossible(s3));
        System.out.println("Palindrome possible for "+s4+" : "+isPalindromePossible(s4));
        System.out.println("Palindrome possible for "+s5+" : "+isPalindromePossible(s5));
        System.out.println("Palindrome possible for "+s6+" : "+isPalindromePossible(s6));
        System.out.println("Palindrome possible for "+s7+" : "+isPalindromePossible(s7));

    }

    public static boolean isPalindromePossible(String s){
        HashMap<Character,Integer> characterFrequency = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(characterFrequency.containsKey(s.charAt(i))){
                characterFrequency.replace(s.charAt(i),characterFrequency.get(s.charAt(i))+1);
            }else{
                characterFrequency.put(s.charAt(i),1);
            }
        }

        long oddCount = characterFrequency.values().stream().filter(i -> i%2 ==1).count();
        if(s.length()%2 == 0)
            return oddCount==0;
        else return oddCount==1;

    }
}
