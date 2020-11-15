package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a program which takes as input an array of disjoint closed intervals with integer endpoints, sorted by increasing order of left endpoint, and an interval to be added, and returns the union of the intervals in the array and the added interval.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="LeetCode">https://leetcode.com/problems/insert-interval/</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class AddInterval {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(-4,-1),
                new Interval(0,2),
                new Interval(3,6),
                new Interval(7,9),
                new Interval(11,12),
                new Interval(14,17)
        );

        System.out.println("Result Intervals "+addInterval(intervals,new Interval(1,9)));
    }

    public static List<Interval> addInterval(List<Interval> intervals,Interval newInterval){
        List<Interval> resultantIntervals = new ArrayList<>();

        int i=0;
        while (i<intervals.size() && intervals.get(i).end < newInterval.start)
            resultantIntervals.add(intervals.get(i++));
        while (i<intervals.size() && intervals.get(i).start < newInterval.end){
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            i++;
        }
        resultantIntervals.add(newInterval);
        while (i<intervals.size())
            resultantIntervals.add(intervals.get(i++));

        return resultantIntervals;
    }
}
