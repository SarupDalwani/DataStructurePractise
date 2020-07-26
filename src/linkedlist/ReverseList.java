package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Reverse a singly linked list.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/reverse-linked-list/">LeetCode</a></li>
 *       <li><a href="https://leetcode.com/problems/add-two-numbers-ii/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class ReverseList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList());
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList(1));

        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> list5 = ListBuilder.build(Arrays.asList());
        ListNode<Integer> list6 = ListBuilder.build(Arrays.asList(1));

        System.out.println("Reverse of list "+ ListHelper.toString(list1) +" is "+ ListHelper.toString(reverse(list1)));
        System.out.println("Reverse of list "+ ListHelper.toString(list2) +" is "+ ListHelper.toString(reverse(list2)));
        System.out.println("Reverse of list "+ ListHelper.toString(list3) +" is "+ ListHelper.toString(reverse(list3)));

        System.out.println("Reverse of list "+ ListHelper.toString(list4) +" is "+ ListHelper.toString(reverseRecurrsive(list4)));
        System.out.println("Reverse of list "+ ListHelper.toString(list5) +" is "+ ListHelper.toString(reverseRecurrsive(list5)));
        System.out.println("Reverse of list "+ ListHelper.toString(list6) +" is "+ ListHelper.toString(reverseRecurrsive(list6)));

    }


    public static <T extends Comparable> ListNode<T> reverse(ListNode<T> head){

        ListNode<T> prev=null,curr,next;

        curr = head;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr= next;
        }

        return prev;
    }

    public static <T extends Comparable> ListNode<T> reverseRecurrsive(ListNode<T> head){

        if(head == null)return null;

        ListNode<T> next = head.getNext();

        head.setNext(null);

        ListNode<T> recurrResponse = reverseRecurrsive(next);
        if(next != null){
            next.setNext(head);
        }else {
            return head;
        }

        return recurrResponse;
    }
}

