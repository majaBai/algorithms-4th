import edu.princeton.cs.algs4.StdIn;

public class BST<Key extends Comparable<Key>, Value>{
    private Node root;
//    int compareCount;
    private class Node{
        private Key key;
        private Value val;
        Node left, right;
        int N;
        public Node(Key key, Value val, int n){
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        else{
            int c = x.N;
            return c;}
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Key key){
        if(key== null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
//        compareCount++;
        if(cmp < 0) x.left = put(x.left, key, val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        int leftSize = size(x.left);
        int rightSize = size(x.right);
        x.N = leftSize+rightSize +1;
        return x;
    }

    public Value get(Key key){
        Value v = get(root, key);
        return v;
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int tmp = key.compareTo(x.key);
        if(tmp < 0) return get(x.left, key);
        else if(tmp > 0) return get(x.right, key);
        return x.val;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x ==null) return null;
        int  cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }

    public Key ceiling(Key key){
        Node t = ceiling(root, key);
        if(t == null) return null;
        return t.key;
    }
    private Node ceiling(Node x, Key key){
        if(x == null) return null;
        int tmp = key.compareTo(x.key);
        if(tmp == 0) return x;
        if(tmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if(t != null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }
    private Node select(Node x, int k){
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x.right, k - t -1);
        else return x;
    }

    public int rank(Key key){
        return rank(key, root);
    }
    private int rank(Key key, Node x){
        if(x == null) return 0;
        int tmp = key.compareTo(x.key);
        if(tmp < 0) return rank(key, x.left);
        else if(tmp > 0) return rank(key, x.right);
        return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N=size(x.left) + size(x.right) +1;
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
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if( x == null) return ;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left, queue, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right, queue, lo, hi);
    }

//    public int getCompareCount(){
//        return compareCount;
//    }
    public static long treesCount(int n){
        int sum = 0;
        if(n == 0) return 1;
        for(int i = 0; i <= n-1; i++){
            sum+= treesCount(i) * treesCount(n-1-i);
        }
        return sum;
    }

    public static void main(String[] args){
        BST<String, Integer> st  = new BST<String, Integer>();
        String [] a = {"E", "A", "S", "F", "M", "P", "Y", "H", "A", "E"};
        for(int i = 0; i < a.length; i++){
            st.put(a[i], i);
        }
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }

//        for(int j = 1; j <= 20; j++ ) {
//            StopWatch timer = new StopWatch();
//            long sum = treesCount(j);
//            double t = timer.elapsedTime();
//            System.out.println("node: " + j + " tree count is: " + sum + " time: " + t);
//        }

    }


}
