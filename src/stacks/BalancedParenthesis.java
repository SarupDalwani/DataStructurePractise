package stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Write a program that tests if a string made up of the characters '(', ')', '[', and"}' is well-formed.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n) for stack
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/valid-parentheses/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class BalancedParenthesis {
    public static void main(String[] args) {
        String input1 ="([]){()}";
        String input2 ="[()[]{()()}]";
        String input3 ="{)";
        String input4 ="[()[]{()()";
        String input5 ="([)]";
        String input6 ="{[]}";
        String input7 ="([]{()}";

        System.out.println("Exp "+input1+ " isValid : "+isBalancedParenthesis(input1));
        System.out.println("Exp "+input2+ " isValid : "+isBalancedParenthesis(input2));
        System.out.println("Exp "+input3+ " isValid : "+isBalancedParenthesis(input3));
        System.out.println("Exp "+input4+ " isValid : "+isBalancedParenthesis(input4));
        System.out.println("Exp "+input5+ " isValid : "+isBalancedParenthesis(input5));
        System.out.println("Exp "+input6+ " isValid : "+isBalancedParenthesis(input6));
        System.out.println("Exp "+input7+ " isValid : "+isBalancedParenthesis(input7));


    }

    public static boolean isBalancedParenthesis(String exp){
        Deque<Character> stk = new LinkedList<>();
        for(int i=0;i<exp.length();i++){
            switch (exp.charAt(i)){
                case '(':
                case '{':
                case '[' :
                    stk.push(exp.charAt(i));
                    break;
                case ')':
                    if(stk.isEmpty() || stk.peek()!='(')return false;
                    stk.pop();
                    break;
                case '}':
                    if(stk.isEmpty() || stk.peek()!='{')return false;
                    stk.pop();
                    break;
                case ']':
                    if(stk.isEmpty() || stk.peek()!='[')return false;
                    stk.pop();
                    break;
            }
        }

        return stk.isEmpty();
    }
}
