package binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a program that computes the exterior of a binary tree.
 *<br>
 *<br>
 * Time Complexity : O(n) Every node will be visited once
 * <br>
 * Space Complexity : O(1)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li>
 *           <a href="https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/#:~:text=Given%20a%20binary%20tree%2C%20print,in%20order%20without%20duplicate%20nodes.&text=The%20right%20boundary%20is%20defined,to%20the%20right%2Dmost%20node">
 *               GeeksforGeeks</a>
 *       </li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class BoundaryTraversal {
    public static void main(String[] args) {
/*
                3
               / \
              9  20
                /  \
               15   7
         */
        TreeNode<Integer> tree1 = TreeBuilder.buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println("Traversing tree 1 : "+boundaryTraversal(tree1));


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
        System.out.println("Traversing tree 2 : "+ boundaryTraversal(tree2));
    }

    public static <T> List<TreeNode<T>> boundaryTraversal(TreeNode<T> root) {
        List<TreeNode<T>> traversal= new ArrayList<>();
        traversal.add(root);
        traversal.addAll(leftBoundaryAndLeaf(root.left,true));
        traversal.addAll(rightBoundaryAndLeaf(root.right,true));
        return traversal;
    }


    public static <T> List<TreeNode<T>> leftBoundaryAndLeaf(TreeNode<T> root,boolean isBoundary){
        if(root==null)return new ArrayList<>();
        List<TreeNode<T>> response = new ArrayList<>();
        if(isBoundary || isLeaf(root)){
            response.add(root);
        }

        response.addAll(leftBoundaryAndLeaf(root.left,isBoundary));
        response.addAll(leftBoundaryAndLeaf(root.right, isBoundary ? root.left == null : false));
        return response;
    }


    public static <T> List<TreeNode<T>> rightBoundaryAndLeaf(TreeNode<T> root,boolean isBoundary){
        if(root==null)return new ArrayList<>();
        List<TreeNode<T>> response = new ArrayList<>();

        response.addAll(rightBoundaryAndLeaf(root.left,isBoundary ? root.right == null : false));
        response.addAll(rightBoundaryAndLeaf(root.right, isBoundary));
        if(isBoundary || isLeaf(root)){
            response.add(root);
        }
        return response;
    }

    public static <T> boolean isLeaf(TreeNode<T> root){
        return root.left ==null && root.right == null;
    }

}
