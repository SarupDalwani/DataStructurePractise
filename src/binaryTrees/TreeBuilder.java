package binaryTrees;

import java.util.List;

public class TreeBuilder {

    public static <T> TreeNode<T> buildTree(List<T> list){
        return buildTreeRecur(list,0);
    }

    private static <T> TreeNode<T> buildTreeRecur(List<T> list,int index){
        if(list.size()<=index || list.get(index) == null)return null;
        TreeNode<T> root = new TreeNode<>(list.get(index));
        root.left = buildTreeRecur(list,2*index + 1);
        root.right = buildTreeRecur(list,2*index + 2);
        return root;
    }
}
