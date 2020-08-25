import edu.princeton.cs.algs4.*;

public class BinarySearchST<Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] vals;
    private int N;
@SuppressWarnings("unchecked")
    public BinarySearchST(int max){
        keys = (Key[]) new Comparable[max];
        vals = (Value[]) new Object[max];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N ==0;
    }
@SuppressWarnings("unchecked")
    public void resizing(int max){
        Key[] keys_temp = (Key[]) new Comparable[max];
        Value[] vals_temp = (Value[]) new Object[max];
        for(int i = 0; i < N; i++){
            keys_temp[i] = keys[i];
            vals_temp[i] = vals[i];
        }
        keys = keys_temp;
        vals = vals_temp;
    }

    public void put(Key key, Value val){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        if(N == keys.length){
            resizing(keys.length*2);
        }
        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i] = val;
        N++;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }
    public int rank(Key key){
        int lo = 0, hi = N-1;
        while(lo <= hi){
            int mid = lo+(hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid -1;
            else if(cmp >0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public int rank(Key key, int lo, int hi){
        if(lo > hi) return lo;
        int mid = lo +(hi - lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) return rank(key, lo, mid-1);
        else if(cmp > 0) return rank(key, mid+1, hi);
        else return mid;
    }

    public Key select(int j){
        return keys[j];
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        if(i < N && key.compareTo(keys[i])==0) return keys[i];
        if(i == 0) return null;
        else return keys[i-1];
    }

    public void delete(Key key){
        if(!contains(key)) return;
        int i = rank(key);
        for(int j = i ; j < N-1; j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        N--;
        if(N > 0 && N == keys.length/4){
            resizing(keys.length/2);
        }
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> q = new Queue<Key>();
        for(int i = rank(lo); i < rank(hi); i++){
            q.enqueue(keys[i]);
        }
        if(contains(hi)) q.enqueue(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        for(int i = 0; i < N; i++){
            if(contains(keys[i])){
                q.enqueue(keys[i]);
            }
        }
        return q;
    }

    public static void main(String[] args){
//        < st.txt
        BinarySearchST<String, Integer> st  = new BinarySearchST<String, Integer>(10);
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }
    }

}