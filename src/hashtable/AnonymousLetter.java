package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * Problem : Write a program which takes text for an anonymous letter and text for a magazine and determines if it is possible to write the anonymous letter using the magazine. The anonymous letter can be written using the magazine if for each character in the anonymous letter, the number of times it appears in the anonymous letter is no more than the number of times it appears in the magazine.
 *<br>
 *<br>
 * Time Complexity : O(n+m) n is length of letter and m is length of magzine
 * <br>
 * Space Complexity : O(k) k is number of distinct alphabets in magzine
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

public class AnonymousLetter {
    public static void main(String[] args) {

        String letter1="hello",magzine1="helloworld";
        System.out.println("Letter possible for letter : "+ letter1+" magzine : "+magzine1+ " : "+isLetterPossible(letter1,magzine1));

        String letter2="hello",magzine2="heloworld";
        System.out.println("Letter possible for letter : "+ letter2+" magzine : "+magzine2+ " : "+isLetterPossible(letter2,
                magzine2));

        String letter3="hello",
                magzine3="heoworld";
        System.out.println("Letter possible for letter : "+ letter3+" magzine : "+magzine3+ " : "+isLetterPossible(letter3,
                magzine3));

        String letter4="sarup",
                magzine4="heoworld";
        System.out.println("Letter possible for letter : "+ letter4+" magzine : "+magzine4+ " : "+isLetterPossible(letter4,
                magzine4));
    }

    public static boolean isLetterPossible(String letter,String magzine){
        Map<Character,Integer>  frequency = new HashMap<>();

        for(int i=0;i<magzine.length();i++){
            if(frequency.containsKey(magzine.charAt(i))){
                frequency.replace(magzine.charAt(i),frequency.get(magzine.charAt(i))+1);
            }else {
                frequency.put(magzine.charAt(i),1);
            }
        }

        for(int i=0;i<letter.length();i++){
            if(frequency.containsKey(letter.charAt(i))){
                int updatedValue = frequency.get(letter.charAt(i))-1;
                if(updatedValue<0)return false;
                frequency.replace(letter.charAt(i),updatedValue);
            }else {
                return false;
            }
        }

        return true;
    }
}
