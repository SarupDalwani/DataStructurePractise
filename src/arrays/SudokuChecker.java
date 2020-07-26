package arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 *
 * Problem : Check whether a 9 X 9 2D array representing a partially completed Sudoku is valid. Specifically, check that no
 * row, column, or 3 X 3 2D subarray contains duplicates. A 0-value in the 2D array indicates that entry is blank; every other entry is in [1,9].
 *<br>
 *<br>
 * Time Complexity : O(n^2)
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

public class SudokuChecker {
    public static void main(String[] args) {

        int arr[][] = {{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}

        };

        System.out.println("Arr 1 Sudoku is "+(validateSudoku(arr)?"valid":"invalid"));

    }

    public static boolean validateSudoku(int arr[][]){
        for(int i=0;i<arr.length;i++){
            if(!validateRow(arr,i) || !validateCol(arr,i)){
                return false;
            }
        }
        int n=Double.valueOf(Math.sqrt(arr.length)).intValue();

        for(int rowNum=0;rowNum<n;rowNum++){
            for(int colNum = 0;colNum <n;colNum++){
                if(!validateSquare(arr,n,n*rowNum,n*colNum)){
                    return false;
                }

            }

        }
        return true;
    }


    public static boolean validateRow(int arr[][], int rowNum){
        HashSet<Integer> rowSet = new HashSet<>();
        for(int i=0;i<arr[0].length;i++){
            if(arr[rowNum][i] <0 || arr[rowNum][i]>9 || (arr[rowNum][i]!=0 && !rowSet.add(arr[rowNum][i])) )
                return false;
        }
        return true;
    }

    public static boolean validateCol(int arr[][], int colNum){
        HashSet<Integer> colSet = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i][colNum] <0 || arr[i][colNum]>9 || (arr[i][colNum]!=0 && !colSet.add(arr[i][colNum])) )
                return false;
        }
        return true;
    }

    public static boolean validateSquare(int arr[][],int n,int rowNum, int colNum){
        HashSet<Integer> colSet = new HashSet<>();

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (arr[rowNum+i][colNum+j] < 0 || arr[rowNum+i][colNum+j] > 9 || (arr[rowNum+i][colNum+j] != 0 && !colSet.add(arr[rowNum+i][colNum+j])))
                    return false;
            }
        }
        return true;
    }

}
