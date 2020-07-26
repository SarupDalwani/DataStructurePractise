package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that tests whether a singly linked list is palindromic.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/palindrome-linked-list/"> LeetCode </a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class PalindromeList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(1,2,3,2,1));
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList(2,3,4,4,3,1));
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(2,3,4,4,3,2));

        System.out.println(ListHelper.toString(list1) +" isPalin "+isPalindorme(list1));
        System.out.println(ListHelper.toString(list2) +" isPalin "+isPalindorme(list2));
        System.out.println(ListHelper.toString(list3) +" isPalin "+isPalindorme(list3));
        System.out.println(ListHelper.toString(list4) +" isPalin "+isPalindorme(list4));

    }

    public static <T extends Comparable> boolean isPalindorme(ListNode<T> list){

        int len = ListHelper.length(list);
        if(len <2)return true;
        int mid = len%2 == 0 ? len/2 : len/2 + 1;

        ListNode<T> midNode, secondList,temp;
        midNode = ListHelper.get(list,mid);
        secondList = midNode.next;

        temp = secondList = ReverseList.reverse(secondList);

        while(list!=null && secondList!=null && list.getData().equals(secondList.getData())){
            list= list.next;
            secondList = secondList.next;
        }

        boolean isPalin = false;
        if(secondList==null) isPalin = true;

        ReverseList.reverse(temp);
        return isPalin;
    }
}
