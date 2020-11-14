package stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Infix to Postfix convertion & Infix to Prefix convertion
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n)
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

public class ExpressionConvertion {
    public static void main(String[] args) {
        String input1 = "A * B + C / D";
        String input2 = "a+b*(c*d-e)*(f+g*h)-i";
        String input3 = "(A - B/C) * (A/K-L)";
        System.out.println("Infix : "+input1+" Postfix : "+infixToPostfix(input1));
        System.out.println("Infix : "+input2+" Postfix : "+infixToPostfix(input2));
        System.out.println("Infix : "+input3+" Postfix : "+infixToPostfix(input3));


        System.out.println("Infix : "+input1+" Prefix : "+infixToPrefix(input1));
        System.out.println("Infix : "+input2+" Prefix : "+infixToPrefix(input2));
        System.out.println("Infix : "+input3+" Prefix : "+infixToPrefix(input3));

    }

    public static String infixToPostfix(String infix){
        Deque<String> exp = new LinkedList<>();
        Deque<Character> sign = new LinkedList<>();

        for(int i=0;i<infix.length();i++){
            switch (infix.charAt(i)){
                case '*':
                case '/':
                case '(':
                    sign.push(infix.charAt(i));
                    break;
                case '-':
                case '+':
                    while (!sign.isEmpty()  &&  sign.peek() != '(' ){
                        String b = exp.pop();
                        exp.push(exp.pop()+b+sign.pop());
                    }
                    sign.push(infix.charAt(i));
                    break;
                case ')':
                    while (!sign.isEmpty() && sign.peek() != '('){
                        String b = exp.pop();
                        exp.push(exp.pop()+b+sign.pop());
                    }
                    if(!sign.isEmpty())
                        sign.pop();
                    break;
                default:
                    if (infix.charAt(i)!=' ')
                        exp.push(""+infix.charAt(i));
            }
        }

        while (!sign.isEmpty()){
            String b = exp.pop();
            exp.push(exp.pop()+b+sign.pop());
        }

        return exp.peek();

    }


    public static String infixToPrefix(String infix){
        Deque<String> exp = new LinkedList<>();
        Deque<Character> sign = new LinkedList<>();

        for(int i=0;i<infix.length();i++){
            switch (infix.charAt(i)){
                case '*':
                case '/':
                case '(':
                    sign.push(infix.charAt(i));
                    break;
                case '-':
                case '+':
                    while (!sign.isEmpty()  &&  sign.peek() != '(' ){
                        String b = exp.pop();
                        exp.push(sign.pop()+exp.pop()+b);
                    }
                    sign.push(infix.charAt(i));
                    break;
                case ')':
                    while (!sign.isEmpty() && sign.peek() != '('){
                        String b = exp.pop();
                        exp.push(sign.pop()+exp.pop()+b);
                    }
                    if(!sign.isEmpty())
                        sign.pop();
                    break;
                default:
                    if (infix.charAt(i)!=' ')
                        exp.push(""+infix.charAt(i));
            }
        }

        while (!sign.isEmpty()){
            String b = exp.pop();
            exp.push(sign.pop()+exp.pop()+b);
        }

        return exp.peek();

    }
}
