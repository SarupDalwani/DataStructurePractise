package hashtable;

import binaryTrees.ParentTreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 *
 * Problem : Design an algorithm for computing the LCA of two nodes in a binary tree.
 *<br>
 *<br>
 * Time Complexity : O(h)
 * <br>
 * Space Complexity : O(h)
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
        ParentTreeNode<Integer> tree1 = buildTree(Arrays.asList(1,2,5,3,4,6,7,8,9,10));

        System.out.println("LCA of 3 & 4 is "+lowestCommonAncestor(find(tree1,3),find(tree1,4)));
        System.out.println("LCA of 3 & 6 is "+lowestCommonAncestor(find(tree1,3),find(tree1,6)));
        System.out.println("LCA of 9 & 10 is "+lowestCommonAncestor(find(tree1,9),find(tree1,10)));
        System.out.println("LCA of 2 & 4 is "+lowestCommonAncestor(find(tree1,2),find(tree1,4)));
        System.out.println("LCA of 1 & 10 is "+lowestCommonAncestor(find(tree1,1),find(tree1,10)));

    }

    public static ParentTreeNode<Integer> find(ParentTreeNode<Integer> root,int num){
        if(root ==null)return null;
        if(num==root.data)return root;
        ParentTreeNode<Integer> val = find(root.left,num);
        if(val!=null)return val;
        return find(root.right,num);
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

    public static <T> ParentTreeNode<T> lowestCommonAncestor(ParentTreeNode<T> root1,
                                                               ParentTreeNode<T> root2){
        HashSet<ParentTreeNode<T>> hashSet = new HashSet<>();
        while (root1!=null || root2!=null){
            if(root1!=null){
                if(!hashSet.add(root1))
                    return root1;
                root1 = root1.parent;
            }
            if(root2 != null){
                if(!hashSet.add(root2))
                    return root2;
                root2 = root2.parent;
            }
        }
        return null;
    }
}
