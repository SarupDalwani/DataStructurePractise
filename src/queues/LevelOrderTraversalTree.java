package queues;

import binaryTrees.TreeBuilder;
import binaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * Problem :  Given a binary tree, return an array consisting of the keys at the same level. Keys should appear in the order of the corresponding nodes' depths, breaking ties from left to right.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n)
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/binary-tree-level-order-traversal">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class LevelOrderTraversalTree {
    public static void main(String[] args) {

        TreeNode<Integer> root = TreeBuilder.buildTree(Arrays.asList(314,6,6,271,561,2,271,28,0,null,3,null,1,null,28,null,
                null,null,null,null,null,null,null,null,null,401,257));

        System.out.println("Lvl order traversal is "+levelOrderTraverse(root));
    }

    public static <T> List<List<T>> levelOrderTraverse(TreeNode<T> root){
        TreeNode<T> dummy = new TreeNode<>(null);

        Deque<TreeNode<T>> q = new LinkedList<>();

        List<List<T>> traversal = new ArrayList<>();

        if(root != null){
            q.add(dummy);
            q.add(root);
            while (q.size()!=1){
                TreeNode<T> currNode = q.poll();
                if(currNode == dummy){
                    traversal.add(new ArrayList<>());
                    q.add(dummy);
                }else{
                    traversal.get(traversal.size()-1).add(currNode.data);
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!=null) q.add(currNode.right);
                }
            }
        }
        return traversal;
    }
}
