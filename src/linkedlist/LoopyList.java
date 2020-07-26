package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes the head of a singly linked list and returns null if there does not exist a cycle, and the node at the start of the cycle, if a cycle is present.
 *<br>
 *<br>
 * Time Complexity : for non loopy LL TimeComplexity is O(n) , for loopy it is multiple of n O(k*n). Finding value of k
 * requires analysis which is not needed for interview.
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/linked-list-cycle/">LeetCode : Has cycle</a></li>
 *       <li><a href="https://leetcode.com/problems/linked-list-cycle-ii/">LeetCode : Detect start of cycle</a></li>
 *
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LoopyList {
    public static void main(String[] args) {

        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(1,2,3,4,5));

        ListNode<Integer> fourth = ListHelper.get(list1,4), tenth= ListHelper.get(list1,10);
        tenth.next = fourth;

        System.out.println("Loop in list 1 is " + detectLoop(list1) );
        System.out.println("Loop in list 2 is " + detectLoop(list2) );

    }

    public static <T extends Comparable> ListNode<T> detectLoop(ListNode<T> head){
        if(head == null)return null;
        ListNode<T> slow,fast;
        slow = fast = head;
        slow = head.next;
        if(head.next!=null)
        fast = head.next.next;

        while(fast!= null && fast.next!= null && slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow==fast){
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else return null;

    }
}
