package sorting;

import java.util.*;

/**
 *
 *
 * Problem : Write a program that takes a set of events, and determines the maximum number of events that take place concurrently.
 *<br>
 *<br>
 * Time Complexity : O(nlogn)
 * <br>
 * Space Complexity : O(n)
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

public class MaximumConcurrentIntervals {
    public static void main(String[] args) {

        List<Interval> intervals = Arrays.asList(
                new Interval(1,5),
                new Interval(2,7),
                new Interval(4,5),
                new Interval(5,10),
                new Interval(8,9),
                new Interval(9,17),
                new Interval(11,13),
                new Interval(14,15),
                new Interval(12,13)
        );

        System.out.println("Maximum concurrent intervals : "+maxConcurrentIntervals(intervals));
    }

    public static int maxConcurrentIntervals(List<Interval> intervals){

        List<Endpoint> endpoints = new ArrayList<>();

        for(Interval interval : intervals){
            endpoints.add(new Endpoint(interval.start,true));
            endpoints.add(new Endpoint(interval.end,false));
        }

        Comparator<Endpoint> comparator = (a,b) -> {
            return a.time == b.time ? (a.isStart? -1: 1) : a.time-b.time;
        };

        Collections.sort(endpoints,comparator);

        int result =0 ,count =0;
        for(Endpoint endpoint:endpoints){
            if(endpoint.isStart)count++;
            else count --;

            result = Math.max(result,count);
        }
        return result;
    }
}

class Endpoint{
    public int time;
    public boolean isStart;

    public Endpoint(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
}
