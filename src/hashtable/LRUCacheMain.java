package hashtable;

/**
 *
 *
 * Problem : You implement lookup, insert, and remove methods. Use the Least Recently Used (LRU) policy for cache eviction.
 *<br>
 *<br>
 * Time Complexity : O(1) for lookup, insert and remove
 * <br>
 * Space Complexity : O(capacity) amount of storage used for hasmap as well as doublyLinkedList both of which are capped at
 * capacity
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

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println("Adding book 1");
        lruCache.add(new Book(123,2));

        System.out.println("Adding book 2");
        lruCache.add(new Book(234,4));

        System.out.println("Getting book1 :"+lruCache.lookup(123));

        System.out.println("Adding book 3");
        lruCache.add(new Book(789,6));

        System.out.println("Getting book2 :"+lruCache.lookup(234));

        System.out.println("Getting book3 :"+lruCache.lookup(789));

        System.out.println("Getting book1 :"+lruCache.lookup(123));

        System.out.println("Removing book 1");
        lruCache.erase(123);

        System.out.println("Adding book 4");
        lruCache.add(new Book(567,8));

        System.out.println("Getting book1 :"+lruCache.lookup(123));

        System.out.println("Adding book 5");
        lruCache.add(new Book(002,10));

        System.out.println("Getting book4 :"+lruCache.lookup(567));
        System.out.println("Getting book5 :"+lruCache.lookup(002));
    }

}
