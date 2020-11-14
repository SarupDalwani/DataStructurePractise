package binaryTrees;

import java.util.Arrays;

/**
 *
 *
 * Problem : Write a program that checks whether a binary tree is symmetric.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/symmetric-tree/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class Symmetreec {
    public static void main(String[] args) {
 /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
         */
        TreeNode<Integer> tree1 = TreeBuilder.buildTree(Arrays.asList(1,2,2,3,4,4,3));

        /*
                1
               / \
              2   2
               \   \
               3    3
         */
        TreeNode<Integer> tree2 = TreeBuilder.buildTree(Arrays.asList(1,2,2,null,3,null,3));

        /*
                1
               / \
              2   2
             /     \
            3       3
         */
        TreeNode<Integer> tree3 = TreeBuilder.buildTree(Arrays.asList(1,2,2,3,null,null,3));

        System.out.println("Tree1 is symmetric = "+checkSymmetry(tree1));
        System.out.println("Tree2 is symmetric = "+checkSymmetry(tree2));
        System.out.println("Tree3 is symmetric = "+checkSymmetry(tree3));
    }

    public static <T> boolean checkSymmetry(TreeNode<T> root){
        if(root==null)return true;
        return checkSymmetry(root.left,root.right);
    }

    private static <T> boolean checkSymmetry(TreeNode<T> one, TreeNode<T> two){
        if(one==null && two==null)return true;
        if(one==null || two==null)return false;

        if(!one.data.equals(two.data))return false;

        return checkSymmetry(one.left,two.right) && checkSymmetry(one.right,two.left);
    }
}
