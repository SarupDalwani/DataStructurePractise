package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes as input a singly linked list of integers in sorted order, and removes duplicates from it.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class RemoveDuplicateFromSortedList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(1,1,1,1,1,5,5,5,7,8,10));
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList(1,5,7,7,7,7,8,10,10,10));
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1,1,1,1,1));

        System.out.println("Removing duplicates from list "+ListHelper.toString(list1));
        removeDuplicate(list1);
        System.out.println("Resulting list is "+ListHelper.toString(list1));

        System.out.println("Removing duplicates from list "+ListHelper.toString(list2));
        removeDuplicate(list2);
        System.out.println("Resulting list is "+ListHelper.toString(list2));

        System.out.println("Removing duplicates from list "+ListHelper.toString(list3));
        removeDuplicate(list3);
        System.out.println("Resulting list is "+ListHelper.toString(list3));

        System.out.println("Removing duplicates from list "+ListHelper.toString(list4));
        removeDuplicate(list4);
        System.out.println("Resulting list is "+ListHelper.toString(list4));

    }

    public static <T extends Comparable> void removeDuplicate(ListNode<T> list) {
        while (list!=null && list.next!=null){
            if(list.next.getData().equals(list.data)){
                list.next = list.next.next;
            }else list=list.next;
        }
    }
}
