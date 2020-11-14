package linkedlist;

import java.util.Arrays;

/**
 *
 *
 * Problem : Find find point of intersection of linkedlists, there could be cycle in one or both lists.
 *<br>
 *<br>
 * Time Complexity : O(n+m) , where n amd m are size of lists
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href=""></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class IntersectionWithCycle {
    public static void main(String[] args) {


        // Non cyclic, non intersection
        ListNode<Integer> test1One = ListBuilder.build(Arrays.asList(1,5,7,8,10));
        ListNode<Integer> test1Two = ListBuilder.build(Arrays.asList(2,3));

        //Non cyclic, intersection
        ListNode<Integer> test2One = ListBuilder.build(Arrays.asList(1,5,7,8));
        ListNode<Integer> test2Two = ListBuilder.build(Arrays.asList(2,3,6,9,11));
        ListHelper.get(test2Two,5).next = ListHelper.get(test2One,2);

        //Only One with cycle
        ListNode<Integer> test3One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test3Two = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListHelper.get(test3Two,4).next = ListHelper.get(test3Two,2);


        //Cycle with intersection, intersection before cycle
        ListNode<Integer> test4One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test4Two = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListHelper.get(test4One,5).next = ListHelper.get(test4One,3);
        ListHelper.get(test4Two,4).next = ListHelper.get(test4One,2);

        //Cycle with intersection, intersection in cycle
        ListNode<Integer> test5One = ListBuilder.build(Arrays.asList(1,2,3,4,5));
        ListNode<Integer> test5Two = ListBuilder.build(Arrays.asList(6,7,8,9));
        ListHelper.get(test5One,5).next = ListHelper.get(test5One,3);
        ListHelper.get(test5Two,4).next = ListHelper.get(test5One,4);


        System.out.println("Intersection of list is "+
                findIntersection(test1One,test1Two));
        System.out.println("Intersection of list is "+
                findIntersection(test2One,test2Two));
        System.out.println("Intersection of list is "+
                findIntersection(test3One,test3Two));
        System.out.println("Intersection of list is "+
                findIntersection(test4One,test4Two));
        System.out.println("Intersection of list is "+
                findIntersection(test5One,test5Two));

    }


    public static <T  extends Comparable> ListNode<T> findIntersection(ListNode<T> one, ListNode<T> two ){
        ListNode<T> loopStartOne = LoopyList.detectLoop(one);
        ListNode<T> loopStartTwo = LoopyList.detectLoop(two);

        // Both list are non-cyclic, so intersection point(if any) would be same for liner linked list
        if(loopStartOne==null && loopStartTwo==null)
            return IntersectingPointOfLists.detectInsertingPoint(one, two);

        // In this case, both list have cycle. Both list may or may not intersect
        if(loopStartOne!= null && loopStartTwo!=null){

            ListNode<T> itr = loopStartTwo;

            do{
                itr = itr.next;
            }while (itr!=loopStartOne && itr!=loopStartTwo);

            // We iterate loop of second list, if both list intersect then both will have same cycle
            // As iterating entire cycle we didnt find loop start of first list, this means both list do not intersect
            if(itr!=loopStartOne)return null;

            int oneDistanceTillLoop = ListHelper.indexOfNode(one,loopStartOne);
            int twoDistanceTillLoop = ListHelper.indexOfNode(two,loopStartTwo);

            if(oneDistanceTillLoop > twoDistanceTillLoop){
                int diff = oneDistanceTillLoop - twoDistanceTillLoop;
                one = ListHelper.get(one,diff+1);
            }else {
                int diff = twoDistanceTillLoop - oneDistanceTillLoop;
                two = ListHelper.get(two,diff+1);
            }

            while(one!=two  && one!=loopStartOne && two!=loopStartTwo){
                one = one.next;
                two = two.next;
            }

            return one;

        }else {
            //In this case, one list as cycle as other list does not have cycle means there exist no intersection between both
            // list
            return null;
        }




    }


}
