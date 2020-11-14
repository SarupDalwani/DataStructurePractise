package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 *
 * Problem :
 *<br>
 *<br>
 * Time Complexity : O()
 * <br>
 * Space Complexity : O()
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

public class SortAlmostSortedArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,-1,2,6,4,5,8);

        System.out.println(list + " sorted : "+sort(list,2));

    }

    public static List<Integer> sort(List<Integer> nums,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() == k + 1) {
                result.add(pq.poll());
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
