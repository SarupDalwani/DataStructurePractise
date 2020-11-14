package heaps;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 *
 * Problem : Given a max-heap, represented as an array A,design an algorithm that computes the k largest elements stored in the max-heap. You cannot modify the heap.
 *<br>
 *<br>
 * Time Complexity : O(klogk) As there will never be more than k elements in heapOfHeap
 * <br>
 * Space Complexity : O(k) to build heapOfHeap
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

public class KLargestNumbersInMaxHeap {
    public static void main(String[] args) {

        int[] heap ={561,314,401,28,156,359,271,11,3};

        System.out.println("4 largest elements in heap are " + kLargest(heap,4) );
        System.out.println(heap.length +" largest elements in heap are " + kLargest(heap,heap.length) );
    }


    public static List<Integer> kLargest(int[] heap,int k){
        List<Integer> result = new ArrayList<>();

        if(heap.length==0)return result;
        PriorityQueue<HeapElement> heapOfHeap = new PriorityQueue<HeapElement>(Comparator.comparingInt(HeapElement::getValue).reversed());
        heapOfHeap.add(new HeapElement(heap[0],0));
        while(result.size() != k && !heapOfHeap.isEmpty()){
            HeapElement e = heapOfHeap.poll();
            result.add(e.value);
            int left = 2*e.position +1;
            int right  = left+1;
            if(left < heap.length)
                heapOfHeap.add(new HeapElement(heap[left],left));
            if(right < heap.length)
                heapOfHeap.add(new HeapElement(heap[right],right));
        }
        return result;
    }
}

class HeapElement {
    int value;
    int position;

    public int getValue() {
        return value;
    }

    public HeapElement(int value, int position) {
        this.value = value;
        this.position = position;
    }
}