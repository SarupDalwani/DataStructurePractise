package binaryTrees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Write a program which takes as input a binary tree and performs an inorder traversal of the tree. Do not use recursion. Nodes do not contain parent references.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(h) stack storage space
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/binary-tree-inorder-traversal">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class InOrderTraversalIterative {
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
        traverse(tree1);

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
        traverse(tree2);
    }

    public static <T> void traverse(TreeNode<T> root){
        Deque<TreeNode<T>> stack = new LinkedList<>();


        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }

    }
}
