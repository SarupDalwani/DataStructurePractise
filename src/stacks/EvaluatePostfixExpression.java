package stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem :
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n) for stack
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class EvaluatePostfixExpression {
    public static void main(String[] args) {

        String input1="2,3,+";
        String input2="2,3,-";
        String input3="2,3,*";
        String input4="3,2,/";
        String input5="9,3,/";
        String input6="2,3,+,2,*,1,-,5,+";
        String input7="10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +";

        System.out.println("Evalutation of exp : "+input1+" is "+valuatePostfix(input1));
        System.out.println("Evalutation of exp : "+input2+" is "+valuatePostfix(input2));
        System.out.println("Evalutation of exp : "+input3+" is "+valuatePostfix(input3));
        System.out.println("Evalutation of exp : "+input4+" is "+valuatePostfix(input4));
        System.out.println("Evalutation of exp : "+input5+" is "+valuatePostfix(input5));
        System.out.println("Evalutation of exp : "+input6+" is "+valuatePostfix(input6));
        System.out.println("Evalutation of exp : "+input7+" is "+valuatePostfix(input7));

        String preInput1="+,2,3";
        String preInput2="-,2,3";
        String preInput3="*,2,3";
        String preInput4="/,3,2";
        String preInput5="/,9,3";
        String preInput6="+,-,*,+,2,3,2,1,5";

        System.out.println("Evalutation of exp : "+preInput1+" is "+valuatePrefix(preInput1));
        System.out.println("Evalutation of exp : "+preInput2+" is "+valuatePrefix(preInput2));
        System.out.println("Evalutation of exp : "+preInput3+" is "+valuatePrefix(preInput3));
        System.out.println("Evalutation of exp : "+preInput4+" is "+valuatePrefix(preInput4));
        System.out.println("Evalutation of exp : "+preInput5+" is "+valuatePrefix(preInput5));
        System.out.println("Evalutation of exp : "+preInput6+" is "+valuatePrefix(preInput6));
    }

    public static int valuatePostfix(String expression){
        String[] tokens = expression.split(",");
        Deque<Integer> integerStack = new LinkedList<>();

        for(String token:tokens){
            token = token.trim();
            if(token.length() > 1){
                integerStack.push(Integer.parseInt(token));
                continue;
            }
            switch (token.charAt(0)){
                case '+' :
                    integerStack.push(integerStack.pop() + integerStack.pop());
                    break;
                case '-' :
                    integerStack.push(-1 * integerStack.pop() + integerStack.pop());
                    break;
                case '*' :
                    integerStack.push(integerStack.pop() * integerStack.pop());
                    break;
                case '/' :
                    int x =integerStack.pop();
                    integerStack.push(integerStack.pop() / x);
                    break;
                default:
                    integerStack.push(Integer.parseInt(token.trim()));
            }
        }

        return integerStack.peek();

    }

    public static int valuatePrefix(String expression){
        expression = new StringBuilder(expression).reverse().toString();
        String[] tokens = expression.split(",");
        Deque<Integer> integerStack = new LinkedList<>();

        for(String token:tokens){
            switch (token.charAt(0)){
                case '+' :
                    integerStack.push(integerStack.pop() + integerStack.pop());
                    break;
                case '-' :
                    integerStack.push( integerStack.pop() - integerStack.pop());
                    break;
                case '*' :
                    integerStack.push(integerStack.pop() * integerStack.pop());
                    break;
                case '/' :
                    integerStack.push(integerStack.pop() / integerStack.pop());
                    break;
                default:
                    integerStack.push(Integer.parseInt(token));
            }
        }

        return integerStack.peek();

    }
}
