package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Implement a function which takes as input a singly linked list and an integer k and performs a pivot of the list with respect to k. The relative ordering of nodes that appear before k, and after k, must remain unchanged; the same must hold for nodes holding keys equal to k.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/partition-list"> LeetCode </a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class PivotList {
    public static void main(String[] args) {
        ListNode<Integer> list1 = ListBuilder.build(Arrays.asList(5,7,2,4,1,7,3));
        int key1 = 3;
        ListNode<Integer> list2 = ListBuilder.build(Arrays.asList(7,8,2,5,1,6));
        int key2 = 4;
        ListNode<Integer> list3 = ListBuilder.build(Arrays.asList());
        int key3 = 2;
        ListNode<Integer> list4 = ListBuilder.build(Arrays.asList(1,1,2,3,4,5));
        int key4 = 1;
        ListNode<Integer> list5 = ListBuilder.build(Arrays.asList(1,1,3,4));
        int key5 = 5;
        ListNode<Integer> list6 = ListBuilder.build(Arrays.asList(1,1,1));
        int key6 = 1;
        ListNode<Integer> list7 = ListBuilder.build(Arrays.asList(1,1,2,3,4,5));
        int key7 = 5;

        System.out.println("Pivoting of list "+ListHelper.toString(list1)+" for key "+key1+" is "+ListHelper.toString(pivot(list1,key1)));
        System.out.println("Pivoting of list "+ListHelper.toString(list2)+" for key "+key2+" is "+ListHelper.toString(pivot(list2,key2)));
        System.out.println("Pivoting of list "+ListHelper.toString(list3)+" for key "+key3+" is "+ListHelper.toString(pivot(list3,key3)));
        System.out.println("Pivoting of list "+ListHelper.toString(list4)+" for key "+key4+" is "+ListHelper.toString(pivot(list4,key4)));
        System.out.println("Pivoting of list "+ListHelper.toString(list5)+" for key "+key5+" is "+ListHelper.toString(pivot(list5,key5)));
        System.out.println("Pivoting of list "+ListHelper.toString(list6)+" for key "+key6+" is "+ListHelper.toString(pivot(list6,key6)));
        System.out.println("Pivoting of list "+ListHelper.toString(list7)+" for key "+key7+" is "+ListHelper.toString(pivot(list7,key7)));

    }

    public static <T extends Comparable> ListNode<T> pivot(ListNode<T> list,T key){

        ListNode<T> lessThanKeyStart=null, lessThanKeyEnd=null, keyStart=null,keyEnd=null, moreThanKeyStart=null,moreThanKeyEnd
                =null;

        ListNode<T> itr=list ;

        while (itr!=null){
            if(itr.getData().compareTo(key) < 0){

                if(lessThanKeyStart ==null){
                    lessThanKeyStart=itr;
                    lessThanKeyEnd=itr;
                }
                else {
                    lessThanKeyEnd.next = itr;
                    lessThanKeyEnd = itr;
                }

            }else if(itr.getData().compareTo(key) == 0){

                if(keyStart ==null){
                    keyStart=itr;
                    keyEnd=itr;
                }
                else {
                    keyEnd.next = itr;
                    keyEnd = itr;
                }

            }else {
                if(moreThanKeyStart ==null){
                    moreThanKeyStart=itr;
                    moreThanKeyEnd=itr;
                }
                else {
                    moreThanKeyEnd.next = itr;
                    moreThanKeyEnd = itr;
                }
            }
            itr = itr.next;
        }

        ListNode<T> responseList = null;
        responseList = lessThanKeyStart!=null ? lessThanKeyStart : keyStart!=null ? keyStart : moreThanKeyStart;

        if(lessThanKeyEnd!=null)
            lessThanKeyEnd.next = keyStart!=null?keyStart:moreThanKeyStart;
        if(keyEnd!=null)
            keyEnd.next = moreThanKeyStart;
        if(moreThanKeyEnd!=null)
            moreThanKeyEnd.next = null;

        return responseList;
    }
}
