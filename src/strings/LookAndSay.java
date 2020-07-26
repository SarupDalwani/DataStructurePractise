package strings;

/**
 *
 *
 * Problem : Write a program that takes as input an integer n and returns the nth integer in the look-and-say sequence. Return the result as a string.
 *<br>
 *<br>
 * Time Complexity : O(n* 2^n)
 * <br>
 *     Len of min string will happen when string has all same number, so minimum would be 2
 *     Len of max string will happen when there are no consecutive number, max length would be double of prev
 *     If max length happens for all iteration, max length of last iteration would be 2^n
 * <br>
 * Space Complexity : O(1)
 * Not counting space for output
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/count-and-say/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LookAndSay {
    public static void main(String[] args) {

        int input1 =7;
        String str = "1";
        System.out.println(str);
        for(int i=0;i<input1;i++){
            str = nextNumber(str);
            System.out.println(str);
        }

    }

    private static String nextNumber(String str){
        int count=0;
        char num = '0';
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        if(str.length()>0){
            num = str.charAt(startIndex++);
            count=1;
        }

        while (startIndex<str.length()){
            if(str.charAt(startIndex) == num){
                count ++;
            }
            else {
                sb.append(count);
                sb.append(num);
                count=1;
                num=str.charAt(startIndex);
            }
            startIndex++;
        }
        sb.append(count);
        sb.append(num);

        return sb.toString();
    }
}
