import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }
    public void enqueue(Item v){
        Node oldLast = last;
        last = new Node();
        last.item = v;
        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        n--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
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

    public static void main(String args[]){
        Queue<String> Q = new Queue<String>();
        System.out.println("before enqueue: " + Q.isEmpty());
        Q.enqueue("to");
        Q.enqueue("be");
        Q.enqueue("or");
        Q.enqueue("not");
        Q.enqueue("to");
        Q.enqueue("be");
        Q.enqueue("that");
        Q.enqueue("is");
        System.out.println("the size of Queue: " + Q.size());
        for(String v : Q){
            System.out.println("iterator: " + v);
        }
        System.out.println("the value dequeue: " + Q.dequeue());

    }
}
