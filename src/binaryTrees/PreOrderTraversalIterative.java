package binaryTrees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Write a program which takes as input a binary tree and performs a preorder traversal of the tree. Do not use recursion. Nodes do not contain parent references.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(h) for stack
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class PreOrderTraversalIterative {
    public static void main(String[] args) {
/*
                3
               / \
              9  20
                /  \
               15   7
         */
        TreeNode<Integer> tree1 = TreeBuilder.buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println("Traversing tree 1");
        preOrder(tree1);

        /*
                   1
                  / \
                 2   5
                / \
               3   6
              / \
             4   7
         */
        TreeNode<Integer> tree2 = TreeBuilder.buildTree(Arrays.asList(1,2,5,3,6,null,null,4,7));
        System.out.println("Traversing tree 2");
        preOrder(tree2);
    }

    public static <T> void preOrder(TreeNode<T> root){
        Deque<TreeNode<T>> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null){
            if(root!=null){
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
