
public class RedBlackTree<Key extends Comparable<Key>, Value>{
    Node root;
    private class Node{
        Key key;
        Value val;
        int N;
        Node left, right;

        public Node(Key key, Value val, int n){
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }

    public int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        Value v = get(root, key);
        return v;
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int tmp = key.compareTo(x.key);
        if(tmp < 0) return get(x.left, key);
        else if( tmp > 0) return get(x.right, key);
        return x.val;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        int tmp = key.compareTo(x.key);
        if(tmp < 0) x.left = put(x.left, key, val);
        else if(tmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }
    private Node select(Node x, int k){
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x.right, k);
        else return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }
    private int rank(Node x, Key key){
        if(x == null) return 0;
        int tmp = key.compareTo(x.key);
        if(tmp < 0) return rank(x.left, key);
        else if(tmp > 0) return rank(x.right, key);
        else return size(x.left);
    }

    public Key getMin(){
        return getMin(root).key;
    }
    private Node getMin(Node x){
        if(x.left == null) return x;
        return getMin(x.left);
    }


    public Key getMax(){
        return getMax(root);
    }
    private Key getMax(Node x){
        if(x.right == null) return x.key;
        return getMax(x.right);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left= deleteMin(x.left);
        x.N= size(x.left) + size(x.right) +1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node x, Key key){
        if(x == null) return null;
        int tmp = key.compareTo(x.key);
        if(tmp < 0) x.left = delete(x.left, key);
        else if(tmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = getMin(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(getMin(), getMax());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> q = new Queue<Key>();
        keys(root, q, lo, hi);
        return q;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if( x == null) return ;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left, queue, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args){
        RedBlackTree<String, Integer> st  = new RedBlackTree<String, Integer>();
        String [] a = {"E", "F", "M", "A"};
        for(int i = 0; i < a.length; i++){
            st.put(a[i], i);
        }
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }
        st.delete(a[3]);
        System.out.println("after delete:");
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }
    }
}