package arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Problem : Generate Spiral Order for given matrix size
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

public class SpiralOrder {
    public static void main(String[] args) {

        System.out.println(genetateSpiralOrder(6));
    }


    public static List<Pair> genetateSpiralOrder(int n){
        n=n-1;
        List<Pair> response = new ArrayList<>();
        for(int i=0;i<=n/2;i++){


            // for ith row travel from i to n-i col
            for(int j=i;j<=n-i ;j++){
                response.add(new Pair(i,j));
            }

            // for n-i th col travel from i+1 th to n-i-1 th row
            for(int j=i+1;j<=n-i-1 ;j++){
                response.add(new Pair(j,n-i));
            }

            // for n-ith row travel from n-i to i col
            for(int j=n-i; j>=i && n-i!=i;j--){
                response.add(new Pair(n-i,j));
            }

            // for i th col travel from n-i-1 to i+1 th row
            for(int j=n-i-1;j>=i+1 ;j--){
                response.add(new Pair(j,i));
            }

        }

        return response;
    }
}
