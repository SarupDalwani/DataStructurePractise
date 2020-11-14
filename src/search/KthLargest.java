package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * Problem :  Design an algorithm for computing the kth largest element in an array. Assume entries are distinct.
 *<br>
 *<br>
 * Time Complexity : O(n)
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

public class KthLargest {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(5,7,1,8,6);
        System.out.println("3rd largest number in "+list1+" is "+kthLargest(list1,3));
        List<Integer> list2 = Arrays.asList(5,7,1,8,6);
        System.out.println("4th largest number in "+list2+" is "+kthLargest(list2,4));

    }

    public static Integer kthLargest(List<Integer> list, int k){
        int low  = 0 , high = list.size()-1;

        while(low<=high){
            int pivot = partition(list,low,high);
            if(pivot == k-1){
                return list.get(pivot);
            }else if(pivot < (k-1)){
                low = pivot+1;
            }else {
                high = pivot-1;
            }
        }
        return null;
    }

    public static int partition(List<Integer> list, int low,int high){
        int p = list.get(high);
        int i=low-1;

        for(int index= low; index<high;index++){
            if(list.get(index)<p){
                Collections.swap(list,index,++i);
            }
        }

        Collections.swap(list,++i,high);
        return i;
    }
}
