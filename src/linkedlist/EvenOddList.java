package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/odd-even-linked-list"> LeetCode </a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class EvenOddList {
    public static void main(String[] args) {

        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(2,3,4,5,6,7));
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList());
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1));

        System.out.println("Even Odd for list "+ListHelper.toString(list1)+" is "+ListHelper.toString(rearrangeEvenOdd(list1)));
        System.out.println("Even Odd for list "+ListHelper.toString(list2)+" is "+ListHelper.toString(rearrangeEvenOdd(list2)));
        System.out.println("Even Odd for list "+ListHelper.toString(list3)+" is "+ListHelper.toString(rearrangeEvenOdd(list3)));
        System.out.println("Even Odd for list "+ListHelper.toString(list4)+" is "+ListHelper.toString(rearrangeEvenOdd(list4)));
    }

    public static <T extends Comparable> ListNode<T> rearrangeEvenOdd(ListNode<T> list){
        ListNode<T> evenStart,oddStart,evenLast,oddLast;
        evenStart=evenLast =list;
        if(list!=null && list.next!=null)
            oddStart = oddLast = list.next;
        else return list;

        ListNode<T> itr;
        itr= list.next.next;
        int count=2;
        while(itr!=null){
            if(count%2==0){
                evenLast.next = itr;
                evenLast = itr;
            }else {
                oddLast.next = itr;
                oddLast = itr;
            }
            count++;
            itr = itr.next;
        }
        evenLast.next = oddStart;
        oddLast.next = null;
        return evenStart;
    }
}
