
import edu.princeton.cs.algs4.*;

public class SequentialSearchST<Key, Value>{
    private Node first;
    private int N;

    private class Node{
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val){
        if(val == null){
            delete(key);
            return;
        }
        for(Node x = first; x != null; x = x.next){
            if(x.key.equals(key)){
                x.val = val;
                return;
            }
        }
//        put new element at the head
        first = new Node(key, val, first);
        N++;
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        for(Node x = first; x!=null; x = x.next){
            q.enqueue(x.key);
        }
        return q;
    }

    public void delete (Key key){
        if(contains(key)) {
            for (Node x = first; x != null; x = x.next) {
                if (x.next.key.equals(key)) {
                    Node current = x.next;
                    x.next = current.next;
                    N--;
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        //        < st.txt
        SequentialSearchST<String, Integer> st  = new SequentialSearchST<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }
    }

}