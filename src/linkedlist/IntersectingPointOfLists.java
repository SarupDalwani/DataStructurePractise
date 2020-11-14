package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that takes two cycle-free singly linked lists, and determines if there exists a node that is common to both lists.
 *<br>
 *<br>
 * Time Complexity : O(n+m)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class IntersectingPointOfLists {
    public static void main(String[] args) {

        ListNode<Integer> test1One = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        ListNode<Integer> test1Two = ListBuilder.build(Arrays.asList(2,3));
        ListHelper.get(test1Two,2).next = ListHelper.get(test1One,3);

        ListNode<Integer> test2One = ListBuilder.build(Arrays.asList());
        ListNode<Integer> test2Two = ListBuilder.build(Arrays.asList(2,3,6,9,11));
        ListHelper.get(test2Two,5).next = test2One;


        ListNode<Integer> test3One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test3Two = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListHelper.get(test3One,5).next = ListHelper.get(test3Two,1);


        ListNode<Integer> test4One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test4Two = ListBuilder.build(Arrays.asList(6,7,8,9));

        System.out.println("Intersection of list "+ ListHelper.toString(test1One)+" and "+ ListHelper.toString(test1Two)+" is "+
                ListHelper.toString(detectInsertingPoint(test1One,test1Two)));
        System.out.println("Intersection of list "+ ListHelper.toString(test2One)+" and "+ ListHelper.toString(test2Two)+" is "+
                ListHelper.toString(detectInsertingPoint(test2One,test2Two)));
        System.out.println("Intersection of list "+ ListHelper.toString(test3One)+" and "+ ListHelper.toString(test3Two)+" is "+
                ListHelper.toString(detectInsertingPoint(test3One,test3Two)));
        System.out.println("Intersection of list "+ ListHelper.toString(test4One)+" and "+ ListHelper.toString(test4Two)+" is "+
                ListHelper.toString(detectInsertingPoint(test4One,test4Two)));

    }


    public static <T extends Comparable> ListNode<T> detectInsertingPoint(ListNode<T> one, ListNode<T> two){
        int oneLen = ListHelper.length(one);
        int twoLen = ListHelper.length(two);

        if(oneLen>twoLen){
            int k = oneLen-twoLen;
            while(k-- > 0){
                one=one.next;
            }
        }else {
            int k = twoLen - oneLen;
            while (k-- > 0){
                two = two.next;
            }
        }

        while (one!=two && one != null && two!=null){
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
