package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Design an algorithm that takes a 2D sorted array and a number and checks whether that number appears in the array.
 *<br>
 *<br>
 * Time Complexity : O(n+m)
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

public class SearchSorted2DMatrix {
    public static void main(String[] args) {

        List<List<Integer>> mat = new ArrayList<>();
        mat.add(Arrays.asList(-1, 2, 4, 4, 6));
        mat.add(Arrays.asList(1, 5, 5, 9, 21));
        mat.add(Arrays.asList(3, 6, 6, 9, 22));
        mat.add(Arrays.asList(3, 6, 8, 10, 24));
        mat.add(Arrays.asList(6, 8, 9, 12, 25));
        mat.add(Arrays.asList(8, 10,12,13,40));

        System.out.println("Search for -1 : "+search(mat,-1));
        System.out.println("Search for 1 : "+search(mat,1));
        System.out.println("Search for 25 : "+search(mat,25));
        System.out.println("Search for 10 : "+search(mat,10));
        System.out.println("Search for 3 : "+search(mat,3));
        System.out.println("Search for 2 : "+search(mat,2));

        System.out.println("Search for 23 : "+search(mat,23));
        System.out.println("Search for 50 : "+search(mat,50));
        System.out.println("Search for -5 : "+search(mat,-5));
        System.out.println("Search for 7 : "+search(mat,7));
        System.out.println("Search for 11 : "+search(mat,11));
        System.out.println("Search for 42 : "+search(mat,42));

    }

    public static boolean search(List<List<Integer>> mat,int key){
        int row =0, col = mat.get(0).size()-1;
        while(row< mat.size() && col>=0){
            if(mat.get(row).get(col) == key)
                return true;
            else if(mat.get(row).get(col) > key )
                col--;
            else row++;
        }

        return false;
    }
}
