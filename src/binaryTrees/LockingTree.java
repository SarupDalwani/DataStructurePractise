package binaryTrees;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Problem : Write the following methods for a binary tree node class:
 * 1. A function to test if the node is locked.
 * 2. A function to lock the node.If the node cannot be locked,return false,otherwise
 * lock it and return true.
 * 3. A function to unlock the node.
 * Assume that each node has a parent field. The API will be used in a single
 * threaded program, so there is no need for concurrency constructs such as mutexes or synchronization.
 *<br>
 *<br>
 * Time Complexity :
 * lock - O(log h)
 * unlock O(log h)
 * isLocked - O(1)
 * <br>
 * Space Complexity : O()
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

public class LockingTree {
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
        LockingTreeNode<Integer> tree1 = buildTree(Arrays.asList(1,2,5,3,4,6,7,8,9,10));

        System.out.println("Locking node 1 : "+tree1.lock());
        System.out.println("Is Node 1 locked : "+tree1.isLocked());

        System.out.println("Locking node 2 : "+tree1.left.lock());
        System.out.println("Unlocking node 1");
        tree1.unlock();


        System.out.println("Locking node 2 : "+tree1.left.lock());
        System.out.println("Is Node 2 locked : "+tree1.left.isLocked());
        System.out.println("Locking node 3 : "+tree1.left.left.lock());
        System.out.println("Locking node 1 : "+tree1.lock());


    }

    public static <T> LockingTreeNode<T> buildTree(List<T> list){
        return buildTreeRecur(list,0);
    }

    private static <T> LockingTreeNode<T> buildTreeRecur(List<T> list,int index){
        if(list.size()<=index || list.get(index) == null)return null;
        LockingTreeNode<T> root = new LockingTreeNode<>(list.get(index));
        root.left = buildTreeRecur(list,2*index + 1);
        root.right = buildTreeRecur(list,2*index + 2);
        if(root.left!=null)root.left.parent = root;
        if(root.right!=null)root.right.parent = root;
        return root;
    }
}


class LockingTreeNode<T> extends TreeNode<T>{
    LockingTreeNode<T> parent;
    LockingTreeNode<T> left,right;
    boolean isLocked;
    int lockedChildren;

    public LockingTreeNode(T data) {
        super(data);
    }

    public boolean lock(){
        if(isLocked)return true;
        if(lockedChildren >0)return false;
        LockingTreeNode<T> tempParent = this.parent;
        while(tempParent != null){
            if(tempParent.isLocked)return false;
            tempParent = tempParent.parent;
        }
        isLocked = true;
        tempParent = this.parent;
        while (tempParent!=null){
            tempParent.lockedChildren++;
            tempParent = tempParent.parent;
        }
        return true;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void unlock(){
        isLocked = false;
        LockingTreeNode<T> tempParent = this.parent;
        while(tempParent !=null){
            tempParent.lockedChildren--;
            tempParent = tempParent.parent;
        }
    }
}
