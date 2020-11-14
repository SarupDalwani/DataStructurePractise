package binarysearch;

/**
 *
 *
 * Problem : Write a program which takes a nonnegative integer and returns the largest integer whose square is less than or equal to the given integer.
 *<br>
 *<br>
 * Time Complexity : O(log (num/precision))
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

public class IntegerRoot {
    public static void main(String[] args) {

        System.out.println("Integer root of 100 is "+integerRoot(100));
        System.out.println("Integer root of 101 is "+integerRoot(101));
        System.out.println("Integer root of 16 is "+integerRoot(16));
        System.out.println("Integer root of 300 is "+integerRoot(300));
        System.out.println("Integer root of 325 is "+integerRoot(325));
        System.out.println("Integer root of 1 is "+integerRoot(1));
        System.out.println("Integer root of 4 is "+integerRoot(4));


        System.out.println("Real root of 100 is "+realRoot(100));
        System.out.println("Real root of 101 is "+realRoot(101));
        System.out.println("Real root of 16 is "+realRoot(16));
        System.out.println("Real root of 300 is "+realRoot(300));
        System.out.println("Real root of 325 is "+realRoot(325));
        System.out.println("Real root of 1 is "+realRoot(1));
        System.out.println("Real root of 4 is "+realRoot(4));
        System.out.println("Real root of 0.25 is "+realRoot(0.25));

    }

    public static Integer integerRoot(int num){
        int low = 0, high = num;
        int mid = (low + high)/2;

        while (low<=high){
            if(mid*mid == num)return mid;
            else if( mid*mid > num)
                high = mid-1;
            else low = mid+1;
            mid = (low + high)/2;
        }
        return low-1;
    }

    public static Double realRoot(double num){

        double low,mid,high;
        if(num >=1){
            int intRoot =integerRoot((int)num);
            low=intRoot;
            high=intRoot+1;
        }else {
            low = 0 ;
            high =1;
        }

        mid = (low+high)/2;

        while(low<high){
            if(mid*mid == num)return mid;
            if(mid*mid > num)
                high = mid;
            else low =mid;
            mid = (low+high)/2;
            if(low == mid)break;
        }

        return low;
    }
}
