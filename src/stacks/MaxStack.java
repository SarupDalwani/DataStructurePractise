package stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Design a stack that includes a max operation, in addition to push and pop. The max method should return the maximum value stored in the stack
 *<br>
 *<br>
 * Time Complexity :
 * <table>
 *     <tr>
 *         <th>Operation</th>
 *         <th>Complexity</th>
 *     </tr>
 *     <tr>
 *         <td>Push</td>
 *         <td>O(1)</td>
 *     </tr>
 *     <tr>
 *         <td>Pop</td>
 *         <td>O(1)</td>
 *     </tr>
 *     <tr>
 *         <td>Max</td>
 *         <td>O(1)</td>
 *     </tr>
 * </table>
 * <br>
 * Space Complexity : O(n) for storing max
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/min-stack">LeetCode Min Stack</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class MaxStack {

    Deque<Integer> stk = new LinkedList<>();
    Deque<Integer> maxStk = new LinkedList<>();
    public void push(int num){
        stk.push(num);
        if(maxStk.isEmpty())
            maxStk.push(num);
        else
            maxStk.push(num>maxStk.peek() ?num:maxStk.peek());
    }

    public Integer pop(){
        maxStk.pop();
        return stk.pop();
    }

    public Integer peek(){
        return stk.peek();
    }

    public Integer max(){
        return maxStk.peek();
    }

    public static void main(String[] args) {

        MaxStack maxStack = new MaxStack();
        System.out.println("Pushing 2");
        maxStack.push(2);
        System.out.println(String.format("Peek element : %s and Max element : %s",maxStack.peek(),maxStack.max()));
        System.out.println("Pushing 1");
        maxStack.push(1);
        System.out.println(String.format("Peek element : %s and Max element : %s",maxStack.peek(),maxStack.max()));
        System.out.println("Pushing 3");
        maxStack.push(3);
        System.out.println(String.format("Peek element : %s and Max element : %s",maxStack.peek(),maxStack.max()));
        System.out.println("Poping 3");
        maxStack.pop();
        System.out.println(String.format("Peek element : %s and Max element : %s",maxStack.peek(),maxStack.max()));
        System.out.println("Poping 1");
        maxStack.pop();
        System.out.println(String.format("Peek element : %s and Max element : %s",maxStack.peek(),maxStack.max()));

    }

}



