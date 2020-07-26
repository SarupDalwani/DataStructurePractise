package linkedlist;

public class ListHelper {
    public static <T extends Comparable> String toString(ListNode<T> listNode) {

        StringBuilder stringBuilder = new StringBuilder();

        while (listNode!=null){
            stringBuilder.append(listNode.getData());
            stringBuilder.append(" ");
            listNode = listNode.getNext();
        }
        return stringBuilder.toString();
    }

    public static <T extends Comparable> ListNode<T> get(ListNode<T> head , int i){
        int count =1;
        if(head ==null || i<=0)return null;

        while (count<i && head!=null){
            head = head.getNext();
            count++;
        }
        return head;
    }

    public static <T extends Comparable> int length(ListNode<T> head){
        int count = 0 ;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;

    }

    public static <T extends Comparable> Integer indexOfNode(ListNode<T> list , ListNode<T> node){
        int count = 1;
        if(list == null || node==null)return null;

        while(list!=null && list !=node){
            count++;
            list = list.next;
        }

        if(list ==null)return null;
        return count;

    }

    public static <T extends Comparable> ListNode<T> getNthLastNode(ListNode<T> list, int k){
        if(list!=null && k>0){

            ListNode<T> slow,fast;
            slow=fast = list;
            while(k>=1 && fast!=null){
                fast=fast.next;
                k--;
            }

            if(k==0){
                while(fast!=null){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
