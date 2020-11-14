package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program which takes a singly linked list L and two integers s and / as arguments, and reverses the order of the nodes from the sth node to /th node, inclusive.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/reverse-linked-list-ii/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class ReverseSubList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList());
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList(1));
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1,2,3,4,5,6));


        System.out.println("Reverse of list "+ ListHelper.toString(list1)
                +" is "+ ListHelper.toString(reverseSubList(list1, ListHelper.get(list1,2), ListHelper.get(list1,4))));
        System.out.println("Reverse of list "+ ListHelper.toString(list2)
                +" is "+ ListHelper.toString(reverseSubList(list2, ListHelper.get(list2,2), ListHelper.get(list2,4))));
        System.out.println("Reverse of list "+ ListHelper.toString(list3)
                +" is "+ ListHelper.toString(reverseSubList(list3, ListHelper.get(list3,2), ListHelper.get(list3,4))));
        System.out.println("Reverse of list "+ ListHelper.toString(list4)
                +" is "+ ListHelper.toString(reverseSubList(list4, ListHelper.get(list4,2), ListHelper.get(list4,7))));

    }


    public static <T extends Comparable> ListNode<T> reverseSubList(ListNode<T> head,ListNode<T> start,ListNode<T> end){

        if(head==null)return null;

        if(start==null)start=head;

        ListNode<T> prev=null,curr,next;
        ListNode<T> listStart = head,prevStart;


        curr = head;
        while(curr != start && curr!=null){
            prev =curr;
            curr = curr.getNext();
        }
        prevStart = prev;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr= next;
            if(prev== end)break;
        }

        if(prevStart != null)
            prevStart.setNext(prev);
        start.setNext(curr);

        if(start == listStart)
            return prev;
        else return listStart;
    }

}

