package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Given two nodes in a binary tree, design an algorithm that computes their LCA. Assume that each node has a parent pointer.
 *<br>
 *<br>
 * Time Complexity : O(h) for LCA calculation
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

public class LCAWithParentPointer {
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

        System.out.println("LCA of 3 & 4 is "+lca(tree1,3,4));
        System.out.println("LCA of 3 & 6 is "+lca(tree1,3,6));
        System.out.println("LCA of 9 & 10 is "+lca(tree1,9,10));
        System.out.println("LCA of 2 & 4 is "+lca(tree1,2,4));
        System.out.println("LCA of 1 & 10 is "+lca(tree1,1,10));
    }

    public static ParentTreeNode<Integer> lca(ParentTreeNode<Integer> root, int one, int two){
        ParentTreeNode<Integer> pOne =find(root,one) , pTwo=find(root,two);

        int depthOne = depth(pOne);
        int depthTwo = depth(pTwo);

        while (depthOne>depthTwo){
            depthOne--;
            pOne = pOne.parent;
        }

        while (depthTwo>depthOne){
            depthTwo--;
            pTwo = pTwo.parent;
        }

        while(pOne!=pTwo){
            pOne = pOne.parent;
            pTwo = pTwo.parent;
        }
        return pOne;
    }

    public static ParentTreeNode<Integer> find(ParentTreeNode<Integer> root,int num){
        if(root ==null)return null;
        if(num==root.data)return root;
        ParentTreeNode<Integer> val = find(root.left,num);
        if(val!=null)return val;
        return find(root.right,num);
    }

    public static int depth(ParentTreeNode<Integer> node){
        if(node==null)return Integer.MAX_VALUE;
        int d = 0;
        while(node.parent!=null){
            d++;
            node = node.parent;
        }
        return d;
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
}

