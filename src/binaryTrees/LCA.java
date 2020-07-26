package binaryTrees;

import java.util.Arrays;

/**
 *
 *
 * Problem : Design an algorithm for computing the LCA of two nodes in a binary tree in which nodes do not have a parent field.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(h) stack storage
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LCA {
    public static void main(String[] args) {
        /*
                  1
               /     \
               2      5
             /  \    / \
            3    4  6  7
           / \  /
          8  9 10
         */
        TreeNode<Integer> tree1 = TreeBuilder.buildTree(Arrays.asList(1,2,5,3,4,6,7,8,9,10));

        System.out.println("LCA of 3 & 4 is "+lca(tree1,3,4).lca);
        System.out.println("LCA of 3 & 6 is "+lca(tree1,3,6).lca);
        System.out.println("LCA of 9 & 10 is "+lca(tree1,9,10).lca);
        System.out.println("LCA of 2 & 4 is "+lca(tree1,2,4).lca);
        System.out.println("LCA of 1 & 10 is "+lca(tree1,1,10).lca);
    }

    public static LCATraversalResponse<Integer> lca(TreeNode<Integer> root, int one, int two){
        if(root == null)return new LCATraversalResponse<Integer>(0,null);
        LCATraversalResponse<Integer> left,right;
        left = lca(root.left,one,two);
        right = lca(root.right,one,two);
        if(left.numOfNodes == 2)return left;
        if(right.numOfNodes == 2) return right;

        int numOfNodes = left.numOfNodes + right.numOfNodes + ((root.data == one || root.data == two) ? 1:0);
        if(numOfNodes ==2)return new LCATraversalResponse<Integer>(2,root);
        else  return new LCATraversalResponse<Integer>(numOfNodes,null);

    }
}

class LCATraversalResponse<T>{
    int numOfNodes;
    TreeNode<T> lca;

    public LCATraversalResponse(int numOfNodes, TreeNode<T> lca) {
        this.numOfNodes = numOfNodes;
        this.lca = lca;
    }
}
