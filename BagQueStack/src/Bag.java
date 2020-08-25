import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private int n;
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
         return n;
    }

    public void add(Item v){
        Node oldFirst = first;
       first = new Node();
       first.item = v;
       first.next = oldFirst;
        n++;
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
            Item m = current.item;
            current = current.next;
            return m;
        }
        public void remove(){}
    }

    public static void main(String args[]){
        Bag<String> B = new Bag<String>();
        System.out.println("is bag empty: " + B.isEmpty());
        B.add("to");
        B.add("be");
        B.add("or");
        B.add("not");
        B.add("to");
        B.add("be");
        B.add("that");
        B.add("is");
        System.out.println("the size of Bag: " + B.size());
        for(String t : B){
            System.out.println("iterator: " + t);
        }
    }
}