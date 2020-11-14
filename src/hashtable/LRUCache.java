package hashtable;

import linkedlist.DoublyLinkedList;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private DoublyLinkedList<Book> queue;
    private HashMap<Integer,DoublyLinkedList.Node<Book>> map;

    public LRUCache(int capacity) {
        queue = new DoublyLinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public Integer lookup(int key){
        if(map.containsKey(key)){
            DoublyLinkedList.Node<Book> node= map.get(key);
            queue.delete(node);
            map.replace(key,queue.add(node.getData()));
            return node.getData().price;
        }
        return null;
    }

    public void add(Book book){
        if(map.size() == capacity){
            DoublyLinkedList.Node<Book> front=queue.poll();
            System.out.println("Removing : "+front.getData());
            map.remove(front.getData().isbn);
        }
        map.put(book.isbn,queue.push(book));
    }
    public Book erase(int isbn){
        Book book = queue.delete(map.get(isbn)).getData();
        map.remove(isbn);
        return book;
    }
}

class Book{
    int isbn,price;

    public Book(int isbn, int price) {
        this.isbn = isbn;
        this.price = price;
    }

    @Override public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", price=" + price +
                '}';
    }
}
