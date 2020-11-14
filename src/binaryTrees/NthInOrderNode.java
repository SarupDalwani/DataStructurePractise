package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a program that efficiently computes the kth node appearing in an inorder traversal. Assume that each node stores the number of nodes in the subtree rooted at that node.
 *<br>
 *<br>
 * Time Complexity : O(h)
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

public class NthInOrderNode {
    public static void main(String[] args) {
/*
                    8
                  /   \
                 5     4
                / \     \
               9   7     11
                  / \   /
                 1  12 3
                   /
                  2
         */
        AugmentedTreeNode<Integer> tree = buildTree(Arrays.asList(8,5,4,9,7,null,11,null,null,1,12,null,null,3,null,null,
                null,null,null,null,null,2));
        System.out.println("1st Node in tree is "+nthNode(tree,1));
        System.out.println("2nd Node in tree is "+nthNode(tree,2));
        System.out.println("3rd Node in tree is "+nthNode(tree,3));
        System.out.println("4th Node in tree is "+nthNode(tree,4));
        System.out.println("5th Node in tree is "+nthNode(tree,5));
        System.out.println("6th Node in tree is "+nthNode(tree,6));
        System.out.println("7th Node in tree is "+nthNode(tree,7));
        System.out.println("8th Node in tree is "+nthNode(tree,8));
        System.out.println("9th Node in tree is "+nthNode(tree,9));
        System.out.println("10th Node in tree is "+nthNode(tree,10));


    }

    public static <T> AugmentedTreeNode<T> nthNode(AugmentedTreeNode<T> root,int n){
        int leftsize  = root.left != null? root.left.size : 0;
        if(n<= leftsize)
            return nthNode(root.left,n);
        if(n==leftsize+1)return root;
        return nthNode(root.right,n-leftsize-1);
    }

    public static <T> AugmentedTreeNode<T> buildTree(List<T> list){
        return buildTreeRecur(list,0);
    }

    private static <T> AugmentedTreeNode<T> buildTreeRecur(List<T> list,int index){
        if(list.size()<=index || list.get(index) == null)return null;
        AugmentedTreeNode<T> root = new AugmentedTreeNode<>(list.get(index));
        root.left = buildTreeRecur(list,2*index + 1);
        root.right = buildTreeRecur(list,2*index + 2);
        root.size = 1 + (root.left!=null?root.left.size : 0) + (root.right!=null?root.right.size : 0);
        return root;
    }
}

class AugmentedTreeNode<T> extends TreeNode<T>{
    int size;
    AugmentedTreeNode<T> left,right;

    public AugmentedTreeNode(T data) {
        super(data);
        size = 1;
    }
}
