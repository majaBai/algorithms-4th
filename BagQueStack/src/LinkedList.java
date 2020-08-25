import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    private ListNode first;
    private int n;

    private class ListNode{
        Item item;
        ListNode next;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void add(Item val){
        ListNode t = new ListNode();
        t.item = val;
        if(isEmpty()){
            first = t;
        } else {
            first.next = t;
        }
        n++;
    }

    public Item deleteLast(){
        ListNode current = first;
        int j = n;
        while(j >=2){
            if(current != null){
                current = current.next;
            }
            j--;
        }
        Item lastValue = current.next.item;
        current.next = null;
        n--;
        return lastValue;
    }

    public Item deleteFirst(){
        ListNode f = first;
        first = first.next;
        n--;
        return f.item;
    }

    public Item deleteAtIndex(int k){
        if(k > n) throw new NoSuchElementException("the length of list is less than k");
        ListNode current = first;
        if(k == 1){
           Item v =  deleteFirst();
           return v;
        } else {
            for (int i = 2; i <= n; i++) {
                if (i + 1 == k) {
                    Item y = current.next.item;
                    ListNode next = current.next;
                    current.next = next.next;
                    n--;
                    return y;
                } else {
                    current = current.next;
                }
            }
            throw new NoSuchElementException("the length of list is less than k");
        }
    }

    public boolean isExist(Item val){
        ListNode current = first;
        boolean r = false;
        int j = n;
        while(j > 0){
            if(current.item == val){
                r = (current.item == val);
                break;
            } else {
                current = current.next;
            }
            j--;
        }
        return r;
    }

    private ListNode find(Item val){
        ListNode current = first;
        ListNode r = new ListNode();
        int j = n;
        while(j > 0){
            if(current.item == val){
                r = current;
            } else {
                current = current.next;
            }
            j--;
        }
        return r;
    }

    public void delete(Item val){
        ListNode current = first;
        int j = n;
        while(j >0){
            if(first.item == val) {
                first = first.next;
                n--;
            } else if(current.next.item == val){
                ListNode next = current.next;
                current.next = next.next;
                n--;
            } else {
                current = current.next;
            }
            j--;
        }
    }

    public void removeAfter(ListNode L){
        Item val = L.item;
        ListNode H = new ListNode();
        if(isExist(val)){
            H = find(val);
        }
        if(H.next != null){
            H.next = null;
            n--;
        }
    }

    public Iterator iterator(){
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator<Item>{
        private ListNode current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }

    public static void remove(LinkedList<String> L, String s){
        L.delete(s);
    }

    public static int max(LinkedList<Integer> L){
        int m = 0;
        for(int k : L){
            if(m < k){
                m = k;
            }
        }
        return m;
    }

    public void reverse(){
       ListNode reversedL = null;
       while(first != null){
           ListNode second = first.next;
           first.next = reversedL;
           reversedL = first;
           first = second;
       }
    }

    public ListNode recursion_reverse(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode second = head.next;
        ListNode rest = recursion_reverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args){

    }




}