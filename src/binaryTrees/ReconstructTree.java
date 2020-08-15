package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Given an inorder traversal sequence and a preorder traversal sequence of a binary tree write a program to reconstruct the tree. Assume each node has a unique key.
 *<br>
 *<br>
 * Time Complexity : O(n^2) can be improved by building lookup for inorder
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

public class ReconstructTree {
    public static void main(String[] args) {

        TreeNode<Integer> root = preorderAndInorder(Arrays.asList(9,5,1,7,2,12,8,4,3,11),Arrays.asList(8,5,9,7,1,12,2,4,11,3));
        System.out.println("Traversing inorder tree");
        inorderTraverse(root);
        System.out.println("Traversing preorder tree");
        preorderTraverse(root);
        System.out.println("Traversing postorder tree");
        postorderTraverse(root);

        TreeNode<Integer> root2 = postorderAndInorder(Arrays.asList(9,5,1,7,2,12,8,4,3,11),Arrays.asList(9,1,2,12,7,5,3,11,4,8));
        System.out.println("Traversing inorder tree");
        inorderTraverse(root2);
        System.out.println("Traversing preorder tree");
        preorderTraverse(root2);
        System.out.println("Traversing postorder tree");
        postorderTraverse(root2);

    }

    public static void inorderTraverse(TreeNode<Integer> root){
        if(root!=null){
            inorderTraverse(root.left);
            System.out.println(root.data);
            inorderTraverse(root.right);
        }
    }

    public static void preorderTraverse(TreeNode<Integer> root){
        if(root!=null){
            System.out.println(root.data);
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }
    }

    public static void postorderTraverse(TreeNode<Integer> root){
        if(root!=null){
            postorderTraverse(root.left);
            postorderTraverse(root.right);
            System.out.println(root.data);
        }
    }

    public static TreeNode<Integer> preorderAndInorder(List<Integer> inorder, List<Integer> preorder){
        return preorderAndInorderRecur(inorder,0,inorder.size()-1,preorder,0,preorder.size()-1);
    }
    public static TreeNode<Integer> postorderAndInorder(List<Integer> inorder, List<Integer> postorder){
        return postorderAndInorderRecur(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
    }

    public static TreeNode<Integer> preorderAndInorderRecur(List<Integer> inorder,int inorderStart, int inorderEnd,
            List<Integer> preorder,int preorderStart, int preorderEnd){

        System.out.println(String.format("preorderAndInorderRecur was called with inorder(%d,%d) and preorder(%d,%d)",
                inorderStart,inorderEnd,preorderStart,preorderEnd) );

        if(inorderEnd < inorderStart || preorderEnd<preorderStart)return null;
        if(inorderStart == inorderEnd || preorderStart == preorderEnd)return new TreeNode<>(inorder.get(inorderStart));

        int root = preorder.get(preorderStart);
        System.out.println("Root : "+root);
        int inorderRootIndex = inorder.indexOf(root);

        TreeNode<Integer> rootNode = new TreeNode<>(root);
        rootNode.left = preorderAndInorderRecur(inorder,inorderStart,inorderRootIndex-1,preorder,preorderStart+1,
                preorderStart+inorderRootIndex - inorderStart);
        rootNode.right = preorderAndInorderRecur(inorder,inorderRootIndex+1,inorderEnd,preorder,
                preorderStart+inorderRootIndex - inorderStart+1,preorderEnd);
        return rootNode;
    }

    public static TreeNode<Integer> postorderAndInorderRecur(List<Integer> inorder,int inorderStart, int inorderEnd,
            List<Integer> postorder,int postorderStart, int postorderEnd){

        System.out.println(String.format("preorderAndInorderRecur was called with inorder(%d,%d) and postorder(%d,%d)",
                inorderStart,inorderEnd,postorderStart,postorderEnd) );

        if(inorderEnd < inorderStart || postorderEnd<postorderStart)return null;
        if(inorderStart == inorderEnd || postorderStart == postorderEnd)return new TreeNode<>(inorder.get(inorderStart));

        int root = postorder.get(postorderEnd);
        System.out.println("Root : "+root);
        int inorderRootIndex = inorder.indexOf(root);

        TreeNode<Integer> rootNode = new TreeNode<>(root);
        rootNode.left = postorderAndInorderRecur(inorder,inorderStart,inorderRootIndex-1,postorder,postorderStart,
                postorderStart+inorderRootIndex - inorderStart-1);
        rootNode.right = postorderAndInorderRecur(inorder,inorderRootIndex+1,inorderEnd,postorder,
                postorderStart+inorderRootIndex - inorderStart,postorderEnd-1);
        return rootNode;
    }

}
