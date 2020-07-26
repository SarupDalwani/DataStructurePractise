package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Given a singly linked list and an integer k, write a program to remove the /cth last element from the list.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class DeleteKthLast {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        int k1 = 2;
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        int k2 = 4;
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        int k3 = 1;
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1));
        int k4 = 1;

        System.out.println("Deleting "+k1+" last node from list "+ListHelper.toString(list1));
        list1 = deleteKthKLast(list1,k1);
        System.out.println("Resulting list "+ListHelper.toString(list1));

        System.out.println("Deleting "+k2+" last node from list "+ListHelper.toString(list2));
        list2 = deleteKthKLast(list2,k2);
        System.out.println("Resulting list "+ListHelper.toString(list2));

        System.out.println("Deleting "+k3+" last node from list "+ListHelper.toString(list3));
        list3 = deleteKthKLast(list3,k3);
        System.out.println("Resulting list "+ListHelper.toString(list3));

        System.out.println("Deleting "+k4+" last node from list "+ListHelper.toString(list4));
        list4 = deleteKthKLast(list4,k4);
        System.out.println("Resulting list "+ListHelper.toString(list4));

    }

    public static <T extends Comparable> ListNode<T> deleteKthKLast(ListNode<T> list, int k){
        if(list!=null && k>0){

            ListNode<T> prev=null,slow,fast;
            slow=fast = list;
            while(k>=1 && fast!=null){
                fast=fast.next;
                k--;
            }

            if(k==0){
                while(fast!=null){
                    fast=fast.next;
                    prev=slow;
                    slow=slow.next;
                }
                if(prev==null)return slow.next;
                prev.next = prev.next.next;
            }
        }
        return list;
    }
}
