package binaryTrees;

public class ParentTreeNode<T> extends TreeNode<T> {
    public ParentTreeNode<T> parent;
    public ParentTreeNode<T> left, right;

    public ParentTreeNode(T data) {
        super(data);
    }
}
