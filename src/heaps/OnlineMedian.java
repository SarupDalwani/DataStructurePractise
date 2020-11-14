package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *
 * Problem : Design an algorithm for computing the running median of a sequence.
 *<br>
 *<br>
 * Time Complexity : O(log n) for insertion , O(1) for get median
 * <br>
 * Space Complexity : O(n) for storing elements
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/find-median-from-data-stream">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class OnlineMedian {
    public static void main(String[] args) {

        MedianDataStructure medianDataStructure = new MedianDataStructure();

        System.out.println("Adding 1");
        medianDataStructure.add(1);
        System.out.println("Median is "+medianDataStructure.getMedian());

        System.out.println("Adding 0");
        medianDataStructure.add(0);
        System.out.println("Median is "+medianDataStructure.getMedian());

        System.out.println("Adding 3");
        medianDataStructure.add(3);
        System.out.println("Median is "+medianDataStructure.getMedian());


        System.out.println("Adding 5");
        medianDataStructure.add(5);
        System.out.println("Median is "+medianDataStructure.getMedian());


        System.out.println("Adding 2");
        medianDataStructure.add(2);
        System.out.println("Median is "+medianDataStructure.getMedian());


        System.out.println("Adding 0");
        medianDataStructure.add(0);
        System.out.println("Median is "+medianDataStructure.getMedian());


        System.out.println("Adding 1");
        medianDataStructure.add(1);
        System.out.println("Median is "+medianDataStructure.getMedian());


    }
}


class MedianDataStructure {

    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

    double getMedian(){
        if(left.size() == right.size())
            return (left.peek() + right.peek())/2.0;
        return left.peek();
    }

    void add(int num){

        if(left.isEmpty()){
            left.add(num);
            return;
        }
        if(left.peek() < num){
            right.add(num);
        }else{
            left.add(num);
        }

        if(left.size() > (right.size()+1)){
            right.add(left.poll());
        }else if(right.size() > left.size()){
            left.add(right.poll());
        }
    }

}