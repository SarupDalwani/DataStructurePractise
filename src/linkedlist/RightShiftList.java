package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes as input a singly linked list and a nonnegative integer k, and returns the list cyclically shifted to the right by k.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/rotate-list">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class RightShiftList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5,6));
        int k1= 3;
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(6,7,4,3,5,2));
        int k2 = 5;

        System.out.println("Right shift of list " +ListHelper.toString(list1) +" by "+k1+" is "+ListHelper.toString(rightShift(list1,k1)));
        System.out.println("Right shift of list " +ListHelper.toString(list2) +" by "+k2+" is "+ListHelper.toString(rightShift(list2,k2)));

    }

    public static <T extends Comparable> ListNode<T> rightShift(ListNode<T> list, int n) {

        ListNode<T> nthLastNode = ListHelper.getNthLastNode(list,n+1);
        if(nthLastNode == null)return null;
        ListNode<T> resultNode = nthLastNode.next;
        ListNode<T> itr = nthLastNode.next;
        nthLastNode.next = null;

        while(itr!= null && itr.next!=null){
            itr = itr.next;
        }
        if(itr!=null)
            itr.next = list;
        return resultNode;
    }
}
