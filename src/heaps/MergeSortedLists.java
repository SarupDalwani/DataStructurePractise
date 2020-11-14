package heaps;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 *
 * Problem : Write a program that takes as input a set of sorted sequences and computes the union of these sequences as a sorted sequence.
 *<br>
 *<br>
 * Time Complexity : O(n logk) where k is number of lists and n is number all elements across lists
 * <br>
 * Space Complexity : O(k) size of heap
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/merge-k-sorted-lists">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class MergeSortedLists {
    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(3,5,7),Arrays.asList(0,6),
                Arrays.asList(0, 6,28)));

        System.out.println("Sorted order of "+lists +" is "+sort(lists));

    }

    public static List<Integer> sort(List<List<Integer>> lists){
        PriorityQueue<Element> pq = new PriorityQueue<Element>(Comparator.comparingInt(a -> a.value));

        for(int i=0;i<lists.size();i++){
            if(lists.get(i).size()>0){
                pq.add(new Element(lists.get(i).get(0),i,0));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()){
            Element e = pq.poll();
            result.add(e.value);
            if((e.index +1)< lists.get(e.listIndex).size()){
                pq.add(new Element(lists.get(e.listIndex).get(e.index+1),e.listIndex,e.index+1));
            }
        }

        return result;
    }
}

class Element{
    int value;
    int listIndex;
    int index;

    public Element(int value, int listIndex, int index) {
        this.value = value;
        this.listIndex = listIndex;
        this.index = index;
    }
}