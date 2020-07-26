package linkedlist;

public class ListNode<T extends Comparable> {
    T data;
    ListNode next;

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override public String toString() {
        return "ListNode{" +
                "data=" + data +
                '}';
    }
}

