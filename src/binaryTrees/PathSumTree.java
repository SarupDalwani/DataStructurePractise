package binaryTrees;

import java.util.Arrays;

/**
 *
 *
 * Problem : Design an algorithm to compute the sum of the binary numbers represented by the root-to-leaf paths
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

public class PathSumTree {
    public static void main(String[] args) {
        TreeNode<Integer> tree1 = TreeBuilder.buildTree(Arrays.asList(1,0,1,0,1,0,0,0,1,null,1,null,0,null,0,null,null,null,
                null,null, null,0,null));


        System.out.println("Path sum from tree is "+pathSum(tree1));
    }

    public static int pathSum(TreeNode<Integer> root){
        return pathSumRecur(root,0);
    }

    public static int pathSumRecur(TreeNode<Integer> root,int pathSum){
        if(root ==null)return 0;

        pathSum *=2;
        pathSum += root.data;

        if(root.left == null && root.right == null)return pathSum;

        return pathSumRecur(root.left,pathSum) + pathSumRecur(root.right,pathSum);
    }
}
