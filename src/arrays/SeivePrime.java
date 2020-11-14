package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 *
 * Problem : Write a program that takes an integer argument and returns all the primes between 1 and that integer.
 *<br>
 *<br>
 * Time Complexity : O(n * log(log(n)))
 * <br>
 * Space Complexity : O(n)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/count-primes">LeetCode</a></li>
 *       <li><a href="https://www.geeksforgeeks.org/sieve-of-eratosthenes/?ref=rp">GeeksForGeeks</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class SeivePrime {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 10;
        int n3 = 100;
        int n4 = 1000;

        System.out.println("Primes from 1 to "+n1+" are "+primes(n1));
        System.out.println("Primes from 1 to "+n2+" are "+primes(n2));
        System.out.println("Primes from 1 to "+n3+" are "+primes(n3));
        System.out.println("Primes from 1 to "+n4+" are "+primes(n4));

        System.out.println("---primesMethod2---");

        System.out.println("Primes from 1 to "+n1+" are "+primesMethod2(n1));
        System.out.println("Primes from 1 to "+n2+" are "+primesMethod2(n2));
        System.out.println("Primes from 1 to "+n3+" are "+primesMethod2(n3));
        System.out.println("Primes from 1 to "+n4+" are "+primesMethod2(n4));

    }

    public static List<Integer> primes(int n){
        boolean[] notPrimes = new boolean[n+1];
        notPrimes[0]=notPrimes[1]=true;
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<n-1;i++){
            if(!notPrimes[i]){
                primes.add(i);
                for(int j = i;i*j <= n;j++){
                    notPrimes[i*j] = true;
                }
            }
        }
        return primes;
    }

    public static List<Integer> primesMethod2(int n){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=2;i<=n;i++)
            hashSet.add(i);

        for(int i=2;i*i<=n;i++){
            if(hashSet.contains(i)){
                for(int j=i;i*j<=n;j++)
                    hashSet.remove(i*j);
            }
        }

        return new ArrayList<>(hashSet);

    }
}
