package linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 *
 * Problem :  Write a program which takes two singly linked lists of digits, and returns the list corresponding to the sum of the integers they represent. The least significant digit comes first.
 *<br>
 *<br>
 * Time Complexity : O(n+m)
 * <br>
 * Space Complexity : O(max(n,m))
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/add-two-numbers">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class AddNumbers {
    public static void main(String[] args) {

        ListNode<Integer> test1One = ListBuilder.build(Arrays.asList(1,2,3,4,5,6,7));
        ListNode<Integer> test1Two = ListBuilder.build(Arrays.asList(6,7,8,9));

        ListNode<Integer> test2One = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListNode<Integer> test2Two = ListBuilder.build(Arrays.asList(2,3,4,5,8,3,4,5,6));

        ListNode<Integer> test3One = ListBuilder.build(Arrays.asList());
        ListNode<Integer> test3Two = ListBuilder.build(Arrays.asList(2,3,4,5));

        ListNode<Integer> test4One = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListNode<Integer> test4Two = ListBuilder.build(Arrays.asList());

        System.out.println("Adding number(Least) : " + ListHelper.toString(test1One) +" and "+ListHelper.toString(test1Two) +
                " is "+ListHelper.toString(addNumbersLessSignificantDigits(test1One,test1Two)) );
        System.out.println("Adding number(Least) : " + ListHelper.toString(test2One) +" and "+ListHelper.toString(test2Two) + " is "+ListHelper.toString(addNumbersLessSignificantDigits(test2One,test2Two)) );
        System.out.println("Adding number(Least) : " + ListHelper.toString(test3One) +" and "+ListHelper.toString(test3Two) + " is "+ListHelper.toString(addNumbersLessSignificantDigits(test3One,test3Two)) );
        System.out.println("Adding number(Least) : " + ListHelper.toString(test4One) +" and "+ListHelper.toString(test4Two) + " is "+ListHelper.toString(addNumbersLessSignificantDigits(test4One,test4Two)) );

        System.out.println("Adding number(Most) : " + ListHelper.toString(test1One) +" and "+ListHelper.toString(test1Two) + " " +
                "is "+ListHelper.toString(addNumbersMostSignificantDigits(test1One,test1Two)) );
        System.out.println("Adding number(Most) : " + ListHelper.toString(test2One) +" and "+ListHelper.toString(test2Two) + " is "+ListHelper.toString(addNumbersMostSignificantDigits(test2One,test2Two)) );
        System.out.println("Adding number(Most) : " + ListHelper.toString(test3One) +" and "+ListHelper.toString(test3Two) + " is "+ListHelper.toString(addNumbersMostSignificantDigits(test3One,test3Two)) );
        System.out.println("Adding number(Most) : " + ListHelper.toString(test4One) +" and "+ListHelper.toString(test4Two) + " is "+ListHelper.toString(addNumbersMostSignificantDigits(test4One,test4Two)) );

        System.out.println("Adding number(Most NonRecur) : " + ListHelper.toString(test1One) +" and "+ListHelper.toString(test1Two) + " " +
                "is "+ListHelper.toString(addNumbersMostSignificantDigitsWithoutRecursion(test1One,test1Two)) );
        System.out.println("Adding number(Most NonRecur) : " + ListHelper.toString(test2One) +" and "+ListHelper.toString(test2Two) +
                " is "+ListHelper.toString(addNumbersMostSignificantDigitsWithoutRecursion(test2One,test2Two)) );
        System.out.println("Adding number(Most NonRecur) : " + ListHelper.toString(test3One) +" and "+ListHelper.toString(test3Two) +
                " is "+ListHelper.toString(addNumbersMostSignificantDigitsWithoutRecursion(test3One,test3Two)) );
        System.out.println("Adding number(Most NonRecur) : " + ListHelper.toString(test4One) +" and "+ListHelper.toString(test4Two) +
                " is "+ListHelper.toString(addNumbersMostSignificantDigitsWithoutRecursion(test4One,test4Two)) );

    }

    public static ListNode<Integer> addNumbersLessSignificantDigits(ListNode<Integer> one,ListNode<Integer> two){
        ListNode<Integer> ans = null,ansEnd = null;
        int carry = 0;
        while(one!=null && two!=null){
            int num = one.data + two.data + carry;

            if(ans ==null)
                ansEnd = ans = new ListNode<Integer>(num%10);
            else{
                ansEnd.next = new ListNode<Integer>(num%10);
                ansEnd = ansEnd.next;
            }
            one = one.next;
            two = two.next;
            carry = num/10;
        }

        while(one!=null){
            int num = one.data + carry;

            if(ans ==null)
                ansEnd = ans = new ListNode<Integer>(num%10);
            else{
                ansEnd.next = new ListNode<Integer>(num%10);
                ansEnd = ansEnd.next;
            }
            one = one.next;
            carry = num/10;
        }

        while(two!=null){
            int num = two.data + carry;

            if(ans ==null)
                ansEnd = ans = new ListNode<Integer>(num%10);
            else{
                ansEnd.next = new ListNode<Integer>(num%10);
                ansEnd = ansEnd.next;
            }
            two = two.next;
            carry = num/10;
        }
        while(carry!=0){
            ansEnd.next = new ListNode<Integer>(carry%10);
            ansEnd = ansEnd.next;
            carry/=10;
        }
        return ans;
    }

    public static ListNode<Integer> addNumbersMostSignificantDigits(ListNode<Integer> one,ListNode<Integer> two){
        one = ReverseList.reverse(one);
        two = ReverseList.reverse(two);
        ListNode<Integer> ans = addNumbersLessSignificantDigits(one,two);
        ReverseList.reverse(one);
        ReverseList.reverse(two);
        ans = ReverseList.reverse(ans);
        return ans;
    }

    public static ListNode<Integer> addNumbersMostSignificantDigitsWithoutRecursion(ListNode<Integer> one,ListNode<Integer> two){

        ListNode<Integer> ans = null,ansEnd = null;

        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        while(one!=null) {
            stackOne.push(one.data);
            one = one.next;
        }
        while(two!=null) {
            stackTwo.push(two.data);
            two = two.next;
        }

        int carry = 0;

        while(!stackOne.empty() && !stackTwo.empty()){
            int num = stackOne.pop() + stackTwo.pop() + carry;
            if(ans== null)
                ans = ansEnd = new ListNode<>(num%10);
            else {
                ansEnd.next = new ListNode<>(num%10);
                ansEnd = ansEnd.next;
            }
            carry = num/10;
        }

        while(!stackTwo.empty()){
            int num = stackTwo.pop() + carry;
            if(ans== null)
                ans = ansEnd = new ListNode<>(num%10);
            else {
                ansEnd.next = new ListNode<>(num%10);
                ansEnd = ansEnd.next;
            }
            carry = num/10;
        }

        while(!stackOne.empty() ){
            int num = stackOne.pop()  + carry;
            if(ans== null)
                ans = ansEnd = new ListNode<>(num%10);
            else {
                ansEnd.next = new ListNode<>(num%10);
                ansEnd = ansEnd.next;
            }
            carry = num/10;
        }

        while(carry!=0){
            ansEnd.next = new ListNode<Integer>(carry%10);
            ansEnd = ansEnd.next;
            carry/=10;
        }

        ans = ReverseList.reverse(ans);

        return ans;
    }

}
