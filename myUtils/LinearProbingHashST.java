import java.util.HashMap;
import edu.princeton.cs.algs4.StdIn;


public class LinearProbingHashST<Key, Value>{

    private static final int INIT_CAPACITY = 16;
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    @SuppressWarnings("unchecked")
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
@SuppressWarnings("unchecked")
    public LinearProbingHashST(int cap){
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return size()==0;
    }


    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
@SuppressWarnings("unchecked")
    private void resize(int cap){
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for(int i = 0; i < M; i++){
            if(keys[i] != null){
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }
        if(N == M/2) resize(2*M);
        int i ;
        for(i = hash(key); keys[i] !=null; i = (i+1) % M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for(int i = hash(key); keys[i] !=null; i = (i+1)%M){
            if(keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if(!contains(key)) return;
        int i = hash(key);
        while(!key.equals(keys[i])) i = (i+1)%M;
        keys[i] = null;
        vals[i] = null;
//        the place after element deleted
        i = (i+1) % M;
//        move the rest elements
        while(keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i+1)%M;
        }
        N--;
        if(N > 0 && N == M/8) resize(M/2);
        assert check();
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        for(int i = 0; i < M; i++){
            if(keys[i] == null) continue;
            if(get(keys[i]) != null)  q.enqueue(keys[i]);
        }
        return q;
    }

    private boolean check() {
        // check that hash table is at most 50% full
        if (M < 2*N) {
            System.err.println("Hash table size m = " + M + "; array size n = " + N);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < M; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        < st.txt
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
////               for (int i = 0; !StdIn.isEmpty(); i++) {
////            String key = StdIn.readString();
////            st.put(key, i);
////        }
        String [] a = {"E", "A", "S", "F", "M", "P", "Y", "H", "A", "E"};
        for(int i = 0; i < a.length; i++){
            st.put(a[i], i);
        }
        // print keys
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
        st.delete("A");
        System.out.println("after delete key A: ");
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }


}