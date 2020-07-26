package linkedlist;

import java.util.Arrays;


/**
 *
 *
 * Problem : Write a program that takes two lists, assumed to be sorted, and returns their merge. The only field your program can change in a node is its next field.
 *<br>
 *<br>
 * Time Complexity : O(m+n) where m and n are size of lists
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/merge-two-sorted-lists">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class MergeTwoSortedList {
    public static void main(String[] args) {

        ListNode<Integer> test1One = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        ListNode<Integer> test1Two = ListBuilder.build(Arrays.asList(2,3,6,9,11));

        ListNode<Integer> test2One = ListBuilder.build(Arrays.asList());
        ListNode<Integer> test2Two = ListBuilder.build(Arrays.asList(2,3,6,9,11));

        ListNode<Integer> test3One = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        ListNode<Integer> test3Two = ListBuilder.build(Arrays.asList());

        ListNode<Integer> test4One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test4Two = ListBuilder.build(Arrays.asList(6,7,8,9));

        ListNode<Integer> test5One = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListNode<Integer> test5Two = ListBuilder.build(Arrays.asList(2,3,4,5));


        System.out.println("Merge of list "+ ListHelper.toString(test1One)+" and "+ ListHelper.toString(test1Two)+" is "+
                ListHelper.toString(merge(test1One,test1Two)));
        System.out.println("Merge of list "+ ListHelper.toString(test2One)+" and "+ ListHelper.toString(test2Two)+" is "+
                ListHelper.toString(merge(test2One,test2Two)));
        System.out.println("Merge of list "+ ListHelper.toString(test3One)+" and "+ ListHelper.toString(test3Two)+" is "+
                ListHelper.toString(merge(test3One,test3Two)));
        System.out.println("Merge of list "+ ListHelper.toString(test4One)+" and "+ ListHelper.toString(test4Two)+" is "+
                ListHelper.toString(merge(test4One,test4Two)));
        System.out.println("Merge of list "+ ListHelper.toString(test5One)+" and "+ ListHelper.toString(test5Two)+" is "+
                ListHelper.toString(merge(test5One,test5Two)));
    }

    public static ListNode<Integer> merge(ListNode<Integer> one, ListNode<Integer> two){

        if(one == null)return two;
        if(two == null)return one;
        if(one.getData().compareTo(two.getData())>0)
            return merge(two,one);
        ListNode<Integer> firstList = one.getNext(), secondList = two;
        ListNode<Integer> resultList = one;
        resultList.setNext(null);

        while (firstList!=null && secondList!=null){
            if(firstList.getData().compareTo(secondList.getData()) <=0){
                resultList.setNext(firstList);
                firstList = firstList.getNext();

            }else {
                resultList.setNext(secondList);
                secondList = secondList.getNext();
            }
            resultList = resultList.getNext();
            resultList.setNext(null);
        }

        if(firstList!=null)
            resultList.setNext(firstList);
        else
            resultList.setNext(secondList);

        return one;
    }
}
