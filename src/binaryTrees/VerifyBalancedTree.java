package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a program that takes as input the root of a binary tree and checks whether the tree is height-balanced
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class VerifyBalancedTree {
    public static void main(String[] args) {

        /*
                3
               / \
              9  20
                /  \
               15   7
         */
        HeightTreeNode<Integer> tree1 = HeightTreeNode.buildHeightTreeRecur(Arrays.asList(3,9,20,null,null,15,7));

        /*
                   1
                  / \
                 2   2
                / \
               3   3
              / \
             4   4
         */
        HeightTreeNode<Integer> tree2 = HeightTreeNode.buildHeightTreeRecur(Arrays.asList(1,2,2,3,3,null,null,4,4));

        System.out.println("Tree1 is balanced = "+checkBalance(tree1));
        System.out.println("Tree2 is balanced = "+checkBalance(tree2));

    }

    public static <T> boolean checkBalance(HeightTreeNode<T> root){
        if(root==null) return true;
        if(!checkBalance(root.left))return false;
        if(!checkBalance(root.right))return false;

        int leftHeight = root.left!=null? root.left.height : 0;
        int rightHeight = root.right!=null? root.right.height : 0;

        root.height = Math.max(leftHeight,rightHeight)+1;

        return Math.abs(leftHeight-rightHeight)<=1;

    }
}




class HeightTreeNode<T> extends TreeNode<T>{

    int height;
    HeightTreeNode<T> left,right;

    public HeightTreeNode(T data) {
        super(data);
        height=0;
    }

    public static <T> HeightTreeNode<T> buildHeightTreeRecur(List<T> list){
        return buildHeightTreeRecur(list,0);
    }

    private static <T> HeightTreeNode<T> buildHeightTreeRecur(List<T> list,int index){
        if(list.size()<=index || list.get(index) == null)return null;
        HeightTreeNode<T> root = new HeightTreeNode<>(list.get(index));
        root.left = buildHeightTreeRecur(list,2*index + 1);
        root.right = buildHeightTreeRecur(list,2*index + 2);
        return root;
    }
}