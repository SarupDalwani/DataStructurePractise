package linkedlist;

import java.util.List;

public class ListBuilder<T> {

    public static <T extends Comparable> ListNode<T>  build(List<T> args) {
        if(args.size()==0)return null;
        ListNode<T> list,iterator;
        list = iterator = new ListNode<T>(args.get(0));

        for(int i=1;i<args.size();i++){
            iterator.setNext(new ListNode(args.get(i)));
            iterator = iterator.getNext();
        }

        return list;

    }
}
