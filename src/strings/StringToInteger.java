package strings;

/**
 *
 *
 * Problem : Implement string/integer inter-conversion functions.
 *<br>
 *<br>
 * Time Complexity : O(len(digits))
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/string-to-integer-atoi/"LeetCode stoi></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class StringToInteger {
    public static void main(String[] args) {

        int input1 = 123623;
        int input2 = -23234;
        int input3 = 0;

        System.out.println("String for int : " +input1 + " is : "+integerToString(input1) );
        System.out.println("String for int : " +input2 + " is : "+integerToString(input2) );
        System.out.println("String for int : " +input3 + " is : "+integerToString(input3) );

        String stringInput1 = "";
        String stringInput2 = "0";
        String stringInput3 = "96532";
        String stringInput4 = "-456";

        System.out.println("Integer for string : "+stringInput1+" is : "+stringToInteger(stringInput1));
        System.out.println("Integer for string : "+stringInput2+" is : "+stringToInteger(stringInput2));
        System.out.println("Integer for string : "+stringInput3+" is : "+stringToInteger(stringInput3));
        System.out.println("Integer for string : "+stringInput4+" is : "+stringToInteger(stringInput4));

    }


    private static String integerToString(int n){
        StringBuilder stringBuilder = new StringBuilder();
        boolean isNegative = false;
        if(n<0){
            isNegative = true;
            n*=-1;
        }
        while(n>0){
            stringBuilder.append(n%10);
            n/=10;
        }
        if(isNegative)
            stringBuilder.append("-");
        return stringBuilder.reverse().toString();
    }


    private static Integer stringToInteger(String num){
        boolean isNegative = false;
        int result = 0;
        if(num.length()<=0 ){
            return null;
        }
        int startIndex =0;
        if(num.charAt(0) == '-'){
            isNegative = true;
            startIndex=1;
        }

        while(startIndex<num.length()){
            result *=10;
            result+=num.charAt(startIndex++) - '0';
        }
        if(isNegative)
            result *= -1;
        return result;
    }
}
