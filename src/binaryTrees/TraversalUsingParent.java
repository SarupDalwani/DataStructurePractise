package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write a nonrecursive program for computing the inorder,preorder and postorder traversal sequence for a binary tree.
 * Assume nodes have parent fields.
 *<br>
 *<br>
 * Time Complexity : O(n)
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

public class TraversalUsingParent {
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

        System.out.println("Traversing inorder");
        inOrder(tree);

        System.out.println("Traversing preOrder");
        preOrder(tree);

        System.out.println("Traversing postOrder");
        postOrder(tree);


        /*
                       8
                     /   \
                    /     \
                   /       \
                  5         4
                /   \      /  \
               9     7    13   11
              / \   / \   / \  / \
             14 15 1  12 16 17 3  18

                  */
        ParentTreeNode<Integer> tree2 = buildTree(Arrays.asList(8,5,4,9,7,13,11,14,15,1,12,16,17,3,18));

        System.out.println("Traversing inorder");
        inOrder(tree2);

        System.out.println("Traversing preOrder");
        preOrder(tree2);

        System.out.println("Traversing postOrder");
        postOrder(tree2);
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

    public static <T> ParentTreeNode<T> inOrderSuccessor(ParentTreeNode<T> node){
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

    public static <T> void inOrder(ParentTreeNode<T> root){
        while(root!=null && root.left!=null)
            root = root.left;

        while(root!=null){
            System.out.println(root.data);
            root = inOrderSuccessor(root);
        }
    }

    public static <T> void preOrder(ParentTreeNode<T> root){
        while (root!=null){

            System.out.println(root.data);
            if(root.left!=null)
                root=root.left;
            else if(root.right !=null){
                root=root.right;
            }
            else {
                while(root.parent!=null && (root.parent.right==null  || root.parent.right==root)){
                    root = root.parent;
                }
                root = root.parent == null ? null : root.parent.right;
            }

        }

    }

    public static <T>  void postOrder(ParentTreeNode<T> root){
        while (root!=null){

            if(root.left!=null)
                root=root.left;
            else if(root.right !=null){
                root=root.right;
            }
            else {
                System.out.println(root.data);
                while(root.parent!=null && (root.parent.right==null  || root.parent.right==root)){
                    root = root.parent;
                    System.out.println(root.data);
                }
                root = root.parent == null ? null : root.parent.right;
            }

        }
    }
}
