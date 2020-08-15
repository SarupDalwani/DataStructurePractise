package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Design an algorithm that computes the successor of a node in a binary tree. Assume that each node stores its parent.
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

public class Successor {
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
        ParentTreeNode<Integer> tree = buildTree(Arrays.asList(8,5,4,9,7,null,11,null,null,1,12,null,null,3,null,null,
                null,null,null,null,null,2));

        System.out.println("Successor for 9 is " + successor(find(tree,9)) );
        System.out.println("Successor for 5 is " + successor(find(tree,5)) );
        System.out.println("Successor for 3 is " + successor(find(tree,3)) );
        System.out.println("Successor for 12 is " + successor(find(tree,12)) );
        System.out.println("Successor for 11 is " + successor(find(tree,11)) );
    }

    public static <T> ParentTreeNode<T> buildTree(List<T> list){
        return buildTreeRecur(list,0);
    }

    private static <T> ParentTreeNode<T> buildTreeRecur(List<T> list,int index){
        if(list.size()<=index || list.get(index) == null)return null;
        ParentTreeNode<T> root = new ParentTreeNode<>(list.get(index));
        root.left = buildTreeRecur(list,2*index + 1);
        root.right = buildTreeRecur(list,2*index + 2);
        if(root.left!=null)root.left.parent = root;
        if(root.right!=null)root.right.parent = root;
        return root;
    }

    public static ParentTreeNode<Integer> find(ParentTreeNode<Integer> root,int num){
        if(root ==null)return null;
        if(num==root.data)return root;
        ParentTreeNode<Integer> val = find(root.left,num);
        if(val!=null)return val;
        return find(root.right,num);
    }

    public static <T> ParentTreeNode<T> successor(ParentTreeNode<T> node){
        if(node == null)return null;
        if(node.right!=null){
            node = node.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }else {
            while(node.parent!=null && node.parent.right == node){
                node = node.parent;
            }
            return node.parent;

        }
    }
}
