package linkedlist;

public class DoublyLinkedList<T> {

    public static class Node<T> {
        private T data;
        private Node<T> left,right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head,tail;
    int size = 0;

    public Node<T> add(T data){
        if(tail==null){
            head = tail = new Node(data);
        }else {
            tail.right = new Node<>(data);
            tail.right.left = tail;
            tail = tail.right;
        }
        size++;
        return tail;
    }

    public Node<T> delete(Node<T> node){
        Node<T> left = node.left;
        if(node.left!=null){
            node.left.right = node.right;
        }
        if(node.right!=null){
            node.right.left = left;
        }
        if(node == head)
            head = node.right;
        if(node == tail)
            tail=left;

        node.left = node.right = null;
        size--;
        return node;
    }

    public T get(int index){
        Node<T> temp = head;

        while(index>0 && temp!=null){
            index--;
            temp=temp.right;
        }
        return temp.data;
    }

    public Node<T> delete(int index){
        Node<T> temp = head;

        while(index>0 && temp!=null){
            index--;
            temp=temp.right;
        }

        if(temp == null)return null;
        return delete(temp);
    }

    public Node<T> push(T data){
        return add(data);
    }

    public T front(){
        if(head==null)return null;
        return head.data;
    }

    public T back(){
        if(tail==null)return null;
        return tail.data;
    }

    public Node<T> poll(){
        if(head==null)return null;
        return delete(head);
    }

}

